package cn.oureda.realm;

/**
 * Created by webhugo on 3/27/17.
 */
public enum LoginType {
    USER("User"),
    BOOKSTORE("Bookstore");

    private String type;

    private LoginType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type.toString();
    }
}
