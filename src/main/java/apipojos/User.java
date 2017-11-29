package apipojos;

import com.google.gson.Gson;
import org.springframework.http.converter.HttpMessageConverter;

public class User {

    private int id;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;

    public User(int id, String username, String email, Address address, String phone, String website, Company company) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public Company getCompany() {
        return company;
    }

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", email='" + email + '\'' +
            ", address=" + address +
            ", phone='" + phone + '\'' +
            ", website='" + website + '\'' +
            ", company=" + company +
            '}';
    }
}
