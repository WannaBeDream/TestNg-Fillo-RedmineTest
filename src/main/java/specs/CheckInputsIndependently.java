package specs;

import helpers.Screenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.RegisterPage;

import java.io.File;
import java.time.Duration;

public class CheckInputsIndependently  {
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

    @Test
    public void checkUserInput() throws Exception {
        registerPage = new RegisterPage(driver);
        screenshot = new Screenshot(driver);

        registerPage.typeAndSendInput(registerPage.userInput,"w");
        registerPage.compareLabelAndInput(registerPage.userLabel);
        registerPage.checkForExistErrorMsg(registerPage.userLabel);
        screenshot.doScreenshot(driver,"userInput");
        registerPage.softassert.assertAll();
        registerPage.userInput.clear();
    }
    @Test
    public void checkUserEmailInput() throws Exception {
        registerPage = new RegisterPage(driver);
        screenshot = new Screenshot(driver);

        registerPage.typeAndSendInput(registerPage.userEmailInput,"w");
        registerPage.compareLabelAndInput(registerPage.userEmailLabel);
        registerPage.checkForExistErrorMsg(registerPage.userEmailLabel);
        screenshot.doScreenshot(driver,"userEmailInput");
        registerPage.softassert.assertAll();
        registerPage.userEmailInput.clear();
    }
    @Test
    public void checkUserPasswordInput() throws Exception {
        registerPage = new RegisterPage(driver);
        screenshot = new Screenshot(driver);

        registerPage.typeAndSendInput(registerPage.userPasswordInput,"w");
        registerPage.compareLabelAndInput(registerPage.userPasswordLabel);
        registerPage.checkForExistErrorMsg(registerPage.userPasswordLabel);
        screenshot.doScreenshot(driver,"userPasswordInput");
        registerPage.softassert.assertAll();
        registerPage.userPasswordInput.clear();
    }
    @Test
    public void checkUserPasswordConfirmationInput() throws Exception {
        registerPage = new RegisterPage(driver);
        screenshot = new Screenshot(driver);

        registerPage.typeAndSendInput(registerPage.userPasswordConfirmationInput,"w");
        registerPage.compareLabelAndInput(registerPage.userPasswordConfirmationLabel);
        registerPage.checkForExistErrorMsg(registerPage.userPasswordConfirmationLabel);
        screenshot.doScreenshot(driver,"userPasswordConfirmationLabel");
        registerPage.softassert.assertAll();
        registerPage.userPasswordConfirmationInput.clear();
    }
    @Test
    public void checkUserFirstNameInput() throws Exception {
        registerPage = new RegisterPage(driver);
        screenshot = new Screenshot(driver);

        registerPage.typeAndSendInput(registerPage.userFirstNameInput,"w");
        registerPage.compareLabelAndInput(registerPage.userFirstNameLabel);
        registerPage.checkForExistErrorMsg(registerPage.userFirstNameLabel);
        screenshot.doScreenshot(driver,"userFirstNameInput");
        registerPage.softassert.assertAll();
        registerPage.userFirstNameInput.clear();
    }
    @Test
    public void checkUserLastNameInput() throws Exception {
        registerPage = new RegisterPage(driver);
        screenshot = new Screenshot(driver);

        registerPage.typeAndSendInput(registerPage.userLastNameInput,"w");
        registerPage.compareLabelAndInput(registerPage.userLastNameLabel);
        registerPage.checkForExistErrorMsg(registerPage.userLastNameLabel);
        screenshot.doScreenshot(driver,"userLastNameLabel");
        registerPage.softassert.assertAll();
        registerPage.userLastNameInput.clear();
    }
    @Test
    public void checkSearchInput() throws Exception {
        registerPage = new RegisterPage(driver);
        screenshot = new Screenshot(driver);

        registerPage.typeAndSendInput(registerPage.searchInput,registerPage.searchValueForCheck);
        Assert.assertTrue(driver.getCurrentUrl().contains(registerPage.searchValueForCheck));
        screenshot.doScreenshot(driver,"searchInput");
        registerPage.softassert.assertAll();
        driver.navigate().back();
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }

}

