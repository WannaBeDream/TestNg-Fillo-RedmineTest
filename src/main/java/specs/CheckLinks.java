package specs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.RegisterPage;

import java.io.File;
import java.time.Duration;

public class CheckLinks {
    String driverPath = new File("browser/chromedriver.exe").getAbsolutePath();
    WebDriver driver;
    RegisterPage registerPage;

    @BeforeTest
    public void setup() {

        System.setProperty("webdriver.chrome.driver", driverPath);

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        registerPage = new RegisterPage(driver);
        driver.get(registerPage.registerUrl);
        driver.manage().window().maximize();
    }

    @Test
    public void checkHomeLink() {
        registerPage = new RegisterPage(driver);
        registerPage.clickHomeLink();
        registerPage.compareCurrentUrlWithBaseUrl();
        registerPage.checkForBreakPage();
        registerPage.softassert.assertAll();
    }
    @Test
    public void checkProjectsLink() {
        registerPage = new RegisterPage(driver);
        registerPage.clickProjectsLink();
        registerPage.compareCurrentUrlWithBaseUrl();
        registerPage.checkForBreakPage();
        registerPage.softassert.assertAll();
    }
    @Test
    public void checkHelpLink() {
        registerPage = new RegisterPage(driver);
        registerPage.clickHelpLink();
        registerPage.compareCurrentUrlWithBaseUrl();
        registerPage.checkForBreakPage();
        registerPage.softassert.assertAll();
    }
    @Test
    public void checkLoginLink() {
        registerPage = new RegisterPage(driver);
        registerPage.clickLoginLink();
        registerPage.compareCurrentUrlWithBaseUrl();
        registerPage.checkForBreakPage();
        registerPage.softassert.assertAll();
    }
    @Test
    public void checkRegisterLink() {
        registerPage = new RegisterPage(driver);
        registerPage.clickRegisterLink();
        registerPage.compareCurrentUrlWithBaseUrl();
        registerPage.checkForBreakPage();
        registerPage.softassert.assertAll();
    }
    @Test
    public void checkRedmineLink() {
        registerPage = new RegisterPage(driver);
        registerPage.clickRedmineLink();
        registerPage.compareCurrentUrlWithBaseUrl();
        registerPage.checkForBreakPage();
        registerPage.softassert.assertAll();
    }


    @AfterTest
    public void afterTest() {
        driver.quit();
    }

}

