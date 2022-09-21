import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPullRequest {
    @Test
    public void someTest(){
        Assert.assertEquals(2, 2, "Failed test");
    }

    @Test
    public void alsoSomeTest(){
        Assert.assertEquals(1, 1, "Great test");
    }
}
