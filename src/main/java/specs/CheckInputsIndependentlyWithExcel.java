package specs;

import helpers.DataExtractor;
import helpers.Screenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.RegisterPage;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;

public class CheckInputsIndependentlyWithExcel {
    String driverPath = new File("browser/chromedriver.exe").getAbsolutePath();
    WebDriver driver;
    RegisterPage registerPage;
    Screenshot screenshot;
    DataExtractor exel;

    @BeforeTest
    public void setup() {

        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        registerPage = new RegisterPage(driver);
        driver.get(registerPage.registerUrl);
        driver.manage().window().maximize();

        exel = new DataExtractor();
        exel.createResultStyleSheet();
    }

    @Test
    public void checkUserInput() throws Exception {
        registerPage = new RegisterPage(driver);
        exel = new DataExtractor();
        screenshot = new Screenshot(driver);
        ArrayList<String> user = exel.getDataForSimpleCheck(1);

        registerPage.typeAndSendInput(registerPage.userInput, user.get(0));
        exel.insertResult(registerPage.getUserLabelText(), registerPage.compareLabelAndInput(registerPage.userLabel));
        registerPage.checkForExistErrorMsg(registerPage.userLabel);
        screenshot.doScreenshot(driver, "userInput" + "Excel");
        registerPage.userInput.clear();
        registerPage.softassert.assertAll();
    }

    @Test
    public void checkUserEmailInput() throws Exception {
        registerPage = new RegisterPage(driver);
        screenshot = new Screenshot(driver);
        exel = new DataExtractor();
        ArrayList<String> user = exel.getDataForSimpleCheck(1);


        registerPage.typeAndSendInput(registerPage.userEmailInput, user.get(1));
        exel.insertResult(registerPage.getEmailLabelText(), registerPage.compareLabelAndInput(registerPage.userEmailLabel));
        registerPage.checkForExistErrorMsg(registerPage.userEmailLabel);
        screenshot.doScreenshot(driver, "userEmailInput" + "Excel");
        registerPage.userEmailInput.clear();
        registerPage.softassert.assertAll();
    }

    @Test
    public void checkUserPasswordInput() throws Exception {
        registerPage = new RegisterPage(driver);
        screenshot = new Screenshot(driver);
        exel = new DataExtractor();
        ArrayList<String> user = exel.getDataForSimpleCheck(1);

        registerPage.typeAndSendInput(registerPage.userPasswordInput, user.get(2));
        exel.insertResult(registerPage.getUserPasswordLabelText(), registerPage.compareLabelAndInput(registerPage.userPasswordLabel));
        registerPage.checkForExistErrorMsg(registerPage.userPasswordLabel);
        screenshot.doScreenshot(driver, "userPasswordInput" + "Excel");
        registerPage.userPasswordInput.clear();
        registerPage.softassert.assertAll();
    }

    @Test
    public void checkUserPasswordConfirmationInput() throws Exception {
        registerPage = new RegisterPage(driver);
        screenshot = new Screenshot(driver);
        exel = new DataExtractor();
        ArrayList<String> user = exel.getDataForSimpleCheck(1);

        registerPage.typeAndSendInput(registerPage.userPasswordConfirmationInput, user.get(3));
        exel.insertResult(registerPage.getUserPasswordConfirmationLabelText(), registerPage.compareLabelAndInput(registerPage.userPasswordConfirmationLabel));
        registerPage.checkForExistErrorMsg(registerPage.userPasswordConfirmationLabel);
        screenshot.doScreenshot(driver, "userPasswordConfirmationLabel" + "Excel");
        registerPage.userPasswordConfirmationInput.clear();
        registerPage.softassert.assertAll();
    }

    @Test
    public void checkUserFirstNameInput() throws Exception {
        registerPage = new RegisterPage(driver);
        screenshot = new Screenshot(driver);
        exel = new DataExtractor();
        ArrayList<String> user = exel.getDataForSimpleCheck(1);

        registerPage.typeAndSendInput(registerPage.userFirstNameInput, user.get(4));
        exel.insertResult(registerPage.getFirstNameLabelText(), registerPage.compareLabelAndInput(registerPage.userFirstNameLabel));
        registerPage.checkForExistErrorMsg(registerPage.userFirstNameLabel);
        screenshot.doScreenshot(driver, "userFirstNameInput" + "Excel");
        registerPage.userFirstNameInput.clear();
        registerPage.softassert.assertAll();
    }

    @Test
    public void checkUserLastNameInput() throws Exception {
        registerPage = new RegisterPage(driver);
        screenshot = new Screenshot(driver);
        exel = new DataExtractor();
        ArrayList<String> user = exel.getDataForSimpleCheck(1);

        registerPage.typeAndSendInput(registerPage.userLastNameInput, user.get(5));
        exel.insertResult(registerPage.getLastNameLabelText(), registerPage.compareLabelAndInput(registerPage.userLastNameLabel));
        registerPage.checkForExistErrorMsg(registerPage.userLastNameLabel);
        screenshot.doScreenshot(driver, "userLastNameLabel" + "Excel");
        registerPage.userLastNameInput.clear();
        registerPage.softassert.assertAll();
    }
    @Test
    public void checkIrcNickInput() throws Exception {
        registerPage = new RegisterPage(driver);
        screenshot = new Screenshot(driver);
        exel = new DataExtractor();
        ArrayList<String> user = exel.getDataForSimpleCheck(1);

        registerPage.typeAndSendInput(registerPage.userIrcNickInput, user.get(6));
        exel.insertResult(registerPage.getIrcNickLabelText(), registerPage.compareLabelAndInput(registerPage.userIrcNickLabel));
        registerPage.checkForExistErrorMsg(registerPage.userIrcNickLabel);
        screenshot.doScreenshot(driver, "userIrcNickLabel" + "Excel");
        registerPage.userIrcNickInput.clear();
        registerPage.softassert.assertAll();
    }

    @Test
    public void checkSearchInput() throws Exception {
        registerPage = new RegisterPage(driver);
        screenshot = new Screenshot(driver);
        exel = new DataExtractor();
        ArrayList<String> user = exel.getDataForSimpleCheck(1);

        registerPage.typeAndSendInput(registerPage.searchInput, user.get(7));
        exel.insertResult(registerPage.getSearchInputValue(), String.valueOf(registerPage.getSearchInputAfterQueryText().contains(user.get(7))) == "ЛОЖЬ" ? "failed" : "passed");
        registerPage.softassert.assertTrue(driver.getCurrentUrl().contains(user.get(7)));
        screenshot.doScreenshot(driver, "searchInput" + "Excel");
        driver.navigate().back();
        registerPage.softassert.assertAll();
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }

}
