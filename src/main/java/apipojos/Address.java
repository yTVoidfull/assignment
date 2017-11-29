package apipojos;

public class Address {

    private String street;
    private String suite;
    private String city;
    private String zipCode;
    private Geo geo;

    public Address(String street, String suite, String city, String zipCode, Geo geo) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipCode = zipCode;
        this.geo = geo;
    }

    public String getStreet() {
        return street;
    }

    public String getSuite() {
        return suite;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public Geo getGeo() {
        return geo;
    }

    @Override
    public String toString() {
        return "Address{" +
            "street='" + street + '\'' +
            ", suite='" + suite + '\'' +
            ", city='" + city + '\'' +
            ", zipCode='" + zipCode + '\'' +
            ", geo=" + geo +
            '}';
    }
}
