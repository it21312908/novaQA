import com.novaqa.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest extends BaseTest {

    @Test
    public void openGoogle() {

        driver.get("https://www.google.com");

        String title = driver.getTitle();

        Assert.assertTrue(title.contains("Google"));
    }
}