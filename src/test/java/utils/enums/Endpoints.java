package utils.enums;

public enum Endpoints {
    POSTS("posts/"),
    USERS("users/");

    Endpoints(String value) {
        this.value = value;
    }

    private final String value;

    public String getValue() {
        return value;
    }
}
