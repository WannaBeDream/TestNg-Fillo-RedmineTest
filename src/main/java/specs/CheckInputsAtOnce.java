package specs;

import helpers.DataExtractor;
import helpers.Screenshot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.RegisterPage;

import java.io.File;
import java.time.Duration;

public class CheckInputsAtOnce extends RegisterPage {
    String driverPath = new File("browser/chromedriver.exe").getAbsolutePath();
    WebDriver driver;
    RegisterPage registerPage;
    Screenshot screenshot;

    @BeforeTest
    public void setup() {

        System.setProperty("webdriver.chrome.driver", driverPath);

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        driver.get(super.registerUrl);
        driver.manage().window().maximize();
    }


    @Test(dataProvider = "userData", dataProviderClass = DataExtractor.class) // TODO
    public void checkInputsAtOnce(String id,String login, String email, String password, String passwordConfirm, String firstName, String lastName, String ircNick, String searchValue) {
        registerPage = new RegisterPage(driver);
        screenshot = new Screenshot(driver);

        try {
            registerPage.typeDataToInput(registerPage.userInput, login);
            registerPage.typeDataToInput(registerPage.userEmailInput, email);
            registerPage.userPasswordInput.click();
            registerPage.typeDataToInput(registerPage.userPasswordInput, password);
            registerPage.userPasswordConfirmationInput.click();
            registerPage.typeDataToInput(registerPage.userPasswordConfirmationInput, passwordConfirm);
            registerPage.typeDataToInput(registerPage.userFirstNameInput, firstName);
            registerPage.typeDataToInput(registerPage.userLastNameInput, lastName);
            registerPage.typeDataToInput(registerPage.userIrcNickInput, ircNick);
            registerPage.typeDataToInput(registerPage.searchInput, searchValue);
            registerPage.submitFormInput.click();

            // check inputs (compare error message with label text)
            if (driver.findElements(By.id(registerPage.errorExplanation)).size() != 0) {
                registerPage.checkForExistErrorMsg(registerPage.userLabel);
                registerPage.checkForExistErrorMsg(registerPage.userEmailLabel);
                registerPage.checkForExistErrorMsg(registerPage.userPasswordLabel);
                registerPage.checkForExistErrorMsg(registerPage.userPasswordConfirmationLabel);
                registerPage.checkForExistErrorMsg(registerPage.userFirstNameLabel);
                registerPage.checkForExistErrorMsg(registerPage.userLastNameLabel);
                registerPage.checkForExistErrorMsg(registerPage.userIrcNickLabel);
            } else if (driver.findElements(By.id(registerPage.flashNotice)).size() != 0) {
                System.out.println("New user " + login + " was created");
            }
            screenshot.doScreenshot(driver, "checkInputsAtOnce" + id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            registerPage.registerLink.click();
        }

    }




}

