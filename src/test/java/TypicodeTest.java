import api.ApiUtils;
import api.models.Post;

import api.models.user.User;
import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.logging.Logger;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.JsonParser;
import utils.SortUtils;
import utils.enums.TestData;

public class TypicodeTest {
    private final Logger logger = AqualityServices.getLogger();

    @Test
    public void apiTest() {
        logger.info("Send GET Request to get all posts");
        Assert.assertTrue(SortUtils.isPostsSorted(ApiUtils.getPosts()), "Posts are sorted ascending");

        logger.info("Send GET request to get post with id=99");
        Post actualPost = ApiUtils.getPost(TestData.POST_ID_99.getValue());
        Assert.assertEquals(actualPost.getUserId(), TestData.POST_USER_ID_10.getValue(), "User Ids don't match");
        Assert.assertEquals(actualPost.getId(), TestData.POST_ID_99.getValue(), "Ids don't match");
        Assert.assertNotNull(actualPost.getTitle(), "Title is empty");
        Assert.assertNotNull(actualPost.getBody(), "Body is empty");

        logger.info("Send GET request to get post with id=150 (no such post)");
        String noSuchPostResponse = ApiUtils.getNoSuchPost(TestData.POST_ID_150.getValue());
        Assert.assertEquals(noSuchPostResponse, "{}", "Response body isn't empty");

        logger.info("Send POST request to create post with userId=1 and random body and random title");
        Post sendedPost = new Post(
                TestData.POST_USER_ID_1.getValue(),
                RandomStringUtils.randomAlphanumeric(10),
                RandomStringUtils.randomAlphanumeric(10));
        Post createdPost = ApiUtils.createPost(sendedPost);
        Assert.assertEquals(createdPost.getUserId(), sendedPost.getUserId(), "User ids don't match");
        Assert.assertNotNull(createdPost.getId(), "Id isn't present in response");
        Assert.assertEquals(createdPost.getTitle(), sendedPost.getTitle(), "Titles don't match");
        Assert.assertEquals(createdPost.getBody(), sendedPost.getBody(), "Bodies Ids don't match");

        logger.info("Send GET request to get users");
        User expectedUser = JsonParser.setUser("user5.json");
        User actualUser = User.getUserFromList(ApiUtils.getUsers(), TestData.USER_ID_5.getValue());
        Assert.assertEquals(actualUser, expectedUser, "Users don't match");

        logger.info("Send GET request to get user with id=5");
        actualUser = ApiUtils.getUser(TestData.USER_ID_5.getValue());
        Assert.assertEquals(actualUser, expectedUser, "Users don't match");
    }
}
