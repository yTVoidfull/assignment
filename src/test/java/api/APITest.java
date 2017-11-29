package api;

import apipojos.User;
import apipojos.UserPost;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.hamcrest.Matcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.Test;
import testbase.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.core.Is.is;

public class APITest extends TestBase {

    private final String EMAIL_PATTERN = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[a-z]{2,4}$";
    private final String USERS_URL = "https://jsonplaceholder.typicode.com/users";
    private final String USER_POSTS_URL = "http://jsonplaceholder.typicode.com/posts?userId=";

    private RestTemplate template = new RestTemplate();
    private Gson gson = new Gson();

    @Test
    public void testASimpleGet() throws Exception {
        ResponseEntity<String> responseEntity = template.getForEntity(USERS_URL, String.class);
        List<User> users = gson.fromJson(responseEntity.getBody(), new TypeToken<ArrayList<User>>(){}.getType());

        Random random = new Random();
        int userPosition = random.nextInt(users.size());

        User u = users.get(userPosition);
        log.info("selected userId: " + u.getId());
        log.info(u.getAddress());

        customAssertThat("email matches pattern", u.getEmail().matches(EMAIL_PATTERN), is(true));

        Integer userId = u.getId();
        responseEntity = template.getForEntity(USER_POSTS_URL + userId, String.class);
        List<UserPost> posts = gson.fromJson(responseEntity.getBody(), new TypeToken<ArrayList<UserPost>>(){}.getType());

        for(UserPost post : posts){
            log.info("validating post " + post.getId());

            customAssertThat("userId in post", post.getUserId(), is(u.getId()));
            customAssertThat("body is empty", post.getBody().isEmpty(), is(false));
            customAssertThat("title is empty", post.getTitle().isEmpty(), is(false));
        }

        UserPost newPost = new UserPost(userId, -1, "Test Title", "Test Body");
        responseEntity = template.postForEntity(USER_POSTS_URL, newPost.toString(), String.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

}
