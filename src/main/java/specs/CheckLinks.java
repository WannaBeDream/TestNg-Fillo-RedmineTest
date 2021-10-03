package specs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.RegisterPage;

import java.io.File;
import java.time.Duration;

public class CheckLinks extends pages.RegisterPage {
    String driverPath = new File("browser/chromedriver.exe").getAbsolutePath();
    WebDriver driver;
    RegisterPage registerPage;

    @BeforeTest
    public void setup() {

        System.setProperty("webdriver.chrome.driver", driverPath);

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        driver.get(super.registerUrl);
        driver.manage().window().maximize();
    }


    @Test
    public void checkLinks() throws Exception {
        try {
            registerPage = new RegisterPage(driver);
            registerPage.checkAllLinksByHttpCode();
        } finally {
            driver.quit();
        }

    }

}

