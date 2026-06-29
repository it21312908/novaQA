import com.novaqa.base.BaseTest;
import com.novaqa.pages.HomePage;
import com.novaqa.pages.LoginPage;
import com.novaqa.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest extends BaseTest {

    @Test
    public void openGoogle() {

        driver.get("https://www.google.com");

        String title = driver.getTitle();

        Assert.assertTrue(title.contains("Google"));
    }

    @Test
    public void loginTest() {

        driver.get("https://www.saucedemo.com/");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
    }

    @Test
    public void loginHomeTest() {

        driver.get(ConfigReader.getApplicationUrl());

        LoginPage loginPage = new LoginPage(driver);

        HomePage homePage = loginPage.login(
                ConfigReader.getUsername(),
                ConfigReader.getPassword()
        );

        Assert.assertTrue(homePage.isHomePageLoaded());
    }
}