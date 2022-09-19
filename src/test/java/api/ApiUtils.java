package api;

import api.models.Post;
import api.models.user.User;
import utils.enums.Endpoints;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ApiUtils {
    public static List<Post> getPosts() {
        return given()
                .spec(RequestSpec.requestSpec())
                .basePath(Endpoints.POSTS.getValue())
                .when()
                .get()
                .then().spec(ResponseSpec.OK())
                .log().all()
                .extract().jsonPath().getList("", Post.class);
    }

    public static Post getPost(Integer id) {
        return given()
                .spec(RequestSpec.requestSpec())
                .basePath(Endpoints.POSTS.getValue())
                .when()
                .get(id.toString())
                .then().spec(ResponseSpec.OK())
                .log().all()
                .extract().as(Post.class);
    }

    public static String getNoSuchPost(Integer id) {
        return given()
                .spec(RequestSpec.requestSpec())
                .basePath(Endpoints.POSTS.getValue())
                .when()
                .get(id.toString())
                .then().spec(ResponseSpec.NOT_FOUND())
                .log().all()
                .extract().asString();
    }

    public static Post createPost(Post post) {
        return given()
                .spec(RequestSpec.requestSpec())
                .basePath(Endpoints.POSTS.getValue())
                .body(post)
                .when()
                .post()
                .then().spec(ResponseSpec.CREATE())
                .log().all()
                .extract().as(Post.class);
    }

    public static List<User> getUsers() {
        return given()
                .spec(RequestSpec.requestSpec())
                .basePath(Endpoints.USERS.getValue())
                .when()
                .get()
                .then().spec(ResponseSpec.OK())
                .log().all()
                .extract().jsonPath().getList("", User.class);
    }

    public static User getUser(Integer id) {
        return given()
                .spec(RequestSpec.requestSpec())
                .basePath(Endpoints.USERS.getValue())
                .when()
                .get(id.toString())
                .then().spec(ResponseSpec.OK())
                .log().all()
                .extract().as(User.class);
    }
}
