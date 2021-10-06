package specs;

import helpers.DataExtractor;
import helpers.Screenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.RegisterPage;

import java.io.File;
import java.time.Duration;

public class CheckInputsAtOnce {
    String driverPath = new File("browser/chromedriver.exe").getAbsolutePath();
    WebDriver driver;
    RegisterPage registerPage;
    Screenshot screenshot;

    @BeforeTest
    public void setup() {

        System.setProperty("webdriver.chrome.driver", driverPath);

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        registerPage = new RegisterPage(driver);
        driver.get(registerPage.registerUrl);
        driver.manage().window().maximize();
    }


    @Test(dataProvider = "userData", dataProviderClass = DataExtractor.class) // TODO
    public void checkInputsAtOnce(String id,String login, String email, String password, String passwordConfirm, String firstName, String lastName, String ircNick, String searchValue) throws Exception {
        registerPage = new RegisterPage(driver);
        screenshot = new Screenshot(driver);


            registerPage.typeDataToInput(registerPage.userInput, login);
            registerPage.typeDataToInput(registerPage.userEmailInput, email);
            registerPage.clickUserPasswordInput();
            registerPage.typeDataToInput(registerPage.userPasswordInput, password);
            registerPage.clickUserPasswordConfirmationInput();
            registerPage.typeDataToInput(registerPage.userPasswordConfirmationInput, passwordConfirm);
            registerPage.typeDataToInput(registerPage.userFirstNameInput, firstName);
            registerPage.typeDataToInput(registerPage.userLastNameInput, lastName);
            registerPage.typeDataToInput(registerPage.userIrcNickInput, ircNick);
            registerPage.typeDataToInput(registerPage.searchInput, searchValue);
            registerPage.clickSubmitFormInput();

            // check inputs (compare error message with label text)
            if (registerPage.getErrorExplanationText() != "") {
                registerPage.checkForExistErrorMsg(registerPage.userLabel);
                registerPage.checkForExistErrorMsg(registerPage.userEmailLabel);
                registerPage.checkForExistErrorMsg(registerPage.userPasswordLabel);
                registerPage.checkForExistErrorMsg(registerPage.userPasswordConfirmationLabel);
                registerPage.checkForExistErrorMsg(registerPage.userFirstNameLabel);
                registerPage.checkForExistErrorMsg(registerPage.userLastNameLabel);
                registerPage.checkForExistErrorMsg(registerPage.userIrcNickLabel);
            }
            screenshot.doScreenshot(driver, "checkInputsAtOnce" + id);
            registerPage.softassert.assertAll();


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

