package api;

import apipojos.User;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.Test;
import testbase.TestBase;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class APITest extends TestBase {

    @Test
    public void testASimpleGet() throws Exception {
        String url = "https://jsonplaceholder.typicode.com/posts/1";
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> responseEntity = template.getForEntity(url, String.class);
        User user = new Gson().fromJson(responseEntity.getBody(), User.class);
        assertThat(user.getId()).isEqualTo(1);

        log.info("responseHeaders: " + responseEntity.getHeaders());
        log.info("responseBody: " + responseEntity.getBody());
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
