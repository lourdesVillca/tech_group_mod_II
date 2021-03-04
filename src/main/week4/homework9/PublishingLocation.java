package week4.homework9;

public class PublishingLocation {
    private String city;
    private String state;
    private String postCode;

    PublishingLocation(String city, String state, String postCode) {
        this.city = city;
        this.state = state;
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostCode() {
        return postCode;
    }

}
