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

    @BeforeClass()
    public void setup() {
        System.setProperty("webdriver.chrome.driver", driverPath);

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        registerPage = new RegisterPage(driver);
        driver.get(registerPage.getRegisterUrl());
        driver.manage().window().maximize();

    }

    @Test
    public void checkHomeLink() {
        registerPage.clickHomeLink();
        registerPage.compareCurrentUrlWithBaseUrl();
    }
    @Test
    public void checkProjectsLink() {
        registerPage.clickProjectsLink();
        registerPage.compareCurrentUrlWithBaseUrl();
    }
    @Test
    public void checkHelpLink() {
        registerPage.clickHelpLink();
        registerPage.compareCurrentUrlWithBaseUrl();
    }
    @Test
    public void checkLoginLink() {
        registerPage.clickLoginLink();
        registerPage.compareCurrentUrlWithBaseUrl();
    }
    @Test
    public void checkRegisterLink() {
        registerPage.clickRegisterLink();
        registerPage.compareCurrentUrlWithBaseUrl();
    }
    @Test
    public void checkRedmineLink() {
        registerPage.clickRedmineLink();
        registerPage.compareCurrentUrlWithBaseUrl();
    }

    @AfterMethod
    public void afterMethod() {
        driver.navigate().back();
    }


    @AfterClass
    public void afterTest() {
        driver.quit();
    }

}

