package specs;

import helpers.DataExtractor;
import helpers.Screenshot;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.RegisterPage;

import java.io.File;
import java.time.Duration;

import static org.testng.Assert.assertFalse;

public class CheckInputsAtOnce {
    String driverPath = new File("browser/chromedriver.exe").getAbsolutePath();
    WebDriver driver;
    RegisterPage registerPage;
    Screenshot screenshot;

    @BeforeClass
    public void setup() {

        System.setProperty("webdriver.chrome.driver", driverPath);

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        registerPage = new RegisterPage(driver);
        driver.get(registerPage.getRegisterUrl());
        driver.manage().window().maximize();
        screenshot = new Screenshot(driver);
    }


    @Test(dataProvider = "userData", dataProviderClass = DataExtractor.class)
    public void checkInputsAtOnce(String id, String login, String email, String password, String passwordConfirm, String firstName, String lastName, String ircNick, String searchValue) throws Exception {

        registerPage.setUserInput(login);
        registerPage.setUserEmailInput(email);
        registerPage.clickUserPasswordInput();
        registerPage.setUserPasswordInput(password);
        registerPage.clickUserPasswordConfirmationInput();
        registerPage.setUserPasswordConfirmationInput(passwordConfirm);
        registerPage.setUserFirstNameInput(firstName);
        registerPage.setUserLastNameInput(lastName);
        registerPage.setUserIrcNickInput(ircNick);
        registerPage.setSearchInput(searchValue);
        registerPage.clickSubmitFormInput();
        screenshot.doScreenshot(driver, "checkInputsAtOnce" + id);

        assertFalse(registerPage.isErrorLiDisplayedByPath(registerPage.getUserErrorPath()), "User error is displayed");
        assertFalse(registerPage.isErrorLiDisplayedByPath(registerPage.getEmailErrorPath()), "Email error is displayed");
        assertFalse(registerPage.isErrorLiDisplayedByPath(registerPage.getPasswordErrorPath()), "Password error is displayed");
        assertFalse(registerPage.isErrorLiDisplayedByPath(registerPage.getPasswordConfirmErrorPath()), "Password confirmation error is displayed");
        assertFalse(registerPage.isErrorLiDisplayedByPath(registerPage.getFirstNameErrorPath()), "Firstname error is displayed");
        assertFalse(registerPage.isErrorLiDisplayedByPath(registerPage.getLastNameErrorPath()), "Lastname error is displayed");
    }

    @AfterMethod
    public void afterMethod() {
        registerPage.clickRegisterLink();
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }

}

