import com.novaqa.base.BaseTest;
import com.novaqa.pages.HomePage;
import com.novaqa.pages.LoginPage;
import com.novaqa.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest extends BaseTest {

    @Test
    public void loginHomeTest() {

        driver.get(ConfigReader.getApplicationUrl());

        LoginPage loginPage = new LoginPage(driver);

        HomePage homePage = loginPage.login(
                ConfigReader.getUsername(),
                ConfigReader.getPassword()
        );

        Assert.assertFalse(homePage.isHomePageLoaded());
    }
}