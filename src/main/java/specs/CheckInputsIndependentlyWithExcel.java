package specs;

import helpers.DataExtractor;
import helpers.Screenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
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
    ArrayList<String> user;

    @BeforeClass
    public void setup() {

        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        registerPage = new RegisterPage(driver);
        driver.get(registerPage.getRegisterUrl());
        driver.manage().window().maximize();
        screenshot = new Screenshot(driver);
        exel = new DataExtractor();
        exel.createResultStyleSheet();
        user = exel.getDataForSimpleCheck(1);
    }

    @Test
    public void checkUserInput() throws Exception {

        registerPage.setUserInput(user.get(0));
        registerPage.clickSubmitFormInput();
        screenshot.doScreenshot(driver,"userInput"+"Excel");
        exel.insertResult(registerPage.getUserLabelText(), registerPage.compareLabelAndInput(registerPage.getUserLabel()));
        Assert.assertFalse(registerPage.isErrorLiExistByPath(registerPage.getUserErrorPath()),"User error is displayed");
    }

    @Test
    public void checkUserEmailInput() throws Exception {
        registerPage.setUserEmailInput(user.get(1));
        registerPage.clickSubmitFormInput();
        screenshot.doScreenshot(driver,"userEmailInput"+"Excel");
        exel.insertResult(registerPage.getEmailLabelText(), registerPage.compareLabelAndInput(registerPage.getUserEmailLabel()));
        Assert.assertFalse(registerPage.isErrorLiExistByPath(registerPage.getEmailErrorPath()),"Email error is displayed");
    }

    @Test
    public void checkUserPasswordInput() throws Exception {
        registerPage.setUserPasswordInput(user.get(2));
        registerPage.clickSubmitFormInput();
        screenshot.doScreenshot(driver,"userPasswordInput"+"Excel");
        exel.insertResult(registerPage.getUserPasswordLabelText(), registerPage.compareLabelAndInput(registerPage.getUserPasswordLabel()));
        Assert.assertFalse(registerPage.isErrorLiExistByPath(registerPage.getPasswordErrorPath()),"Password error is displayed");
    }

    @Test
    public void checkUserPasswordConfirmationInput() throws Exception {
        registerPage.setUserPasswordConfirmationInput(user.get(3));
        registerPage.clickSubmitFormInput();
        screenshot.doScreenshot(driver,"userPasswordConfirmationInput"+"Excel");
        exel.insertResult(registerPage.getUserPasswordConfirmationLabelText(), registerPage.compareLabelAndInput(registerPage.getUserPasswordConfirmationLabel()));
        Assert.assertFalse(registerPage.isErrorLiExistByPath(registerPage.getPasswordConfirmErrorPath()),"Password confirmation error is displayed");
    }

    @Test
    public void checkUserFirstNameInput() throws Exception {
        registerPage.setUserFirstNameInput(user.get(4));
        registerPage.clickSubmitFormInput();
        screenshot.doScreenshot(driver,"userFirstNameInput"+"Excel");
        exel.insertResult(registerPage.getFirstNameLabelText(), registerPage.compareLabelAndInput(registerPage.getUserFirstNameLabel()));
        Assert.assertFalse(registerPage.isErrorLiExistByPath(registerPage.getFirstNameErrorPath()),"Firstname error is displayed");
    }

    @Test
    public void checkUserLastNameInput() throws Exception {
        registerPage.setUserLastNameInput(user.get(5));
        registerPage.clickSubmitFormInput();
        screenshot.doScreenshot(driver,"userLastNameLabel"+"Excel");
        exel.insertResult(registerPage.getLastNameLabelText(), registerPage.compareLabelAndInput(registerPage.getUserLastNameLabel()));
        Assert.assertFalse(registerPage.isErrorLiExistByPath(registerPage.getLastNameErrorPath()),"Lastname error is displayed");;
    }
    @Test
    public void checkIrcNickInput() throws Exception {


        registerPage.setUserIrcNickInput(user.get(6));
        registerPage.clickSubmitFormInput();
        screenshot.doScreenshot(driver, "userIrcNickLabel" + "Excel");
        exel.insertResult(registerPage.getIrcNickLabelText(), registerPage.compareLabelAndInput(registerPage.getUserIrcNickLabel()));
    }

    @Test
    public void checkSearchInput() throws Exception {

        registerPage.setSearchInput(user.get(7));
        registerPage.clickSearchLink();
        screenshot.doScreenshot(driver,"searchInput" + "Excel");
        Assert.assertTrue(driver.getCurrentUrl().contains(user.get(7)),"Current url doesn't contain searched value");
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
