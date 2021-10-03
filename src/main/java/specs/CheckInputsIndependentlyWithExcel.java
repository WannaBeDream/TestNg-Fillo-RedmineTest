package specs;

import helpers.DataExtractor;
import helpers.Screenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.RegisterPage;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;

public class CheckInputsIndependentlyWithExcel extends RegisterPage {
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



    @Test()
    public void CheckInputsIndependentlyWithExcel() {
        registerPage = new RegisterPage(driver);
        DataExtractor exel = new DataExtractor();
        screenshot = new Screenshot(driver);
        ArrayList<String> user = exel.getDataForSimpleCheck(1);
        exel.createResultStyleSheet();

        try {
            registerPage.typeAndSendInput(registerPage.userInput, user.get(0));
            exel.insertResult(registerPage.userLabel.getText(), registerPage.compareLabelAndInput(registerPage.userLabel));
            registerPage.checkForExistErrorMsg(registerPage.userLabel);
            screenshot.doScreenshot(driver, "userInput");
            registerPage.userInput.clear();
            registerPage.typeAndSendInput(registerPage.userEmailInput, user.get(1));
            exel.insertResult(registerPage.userEmailLabel.getText(), registerPage.compareLabelAndInput(registerPage.userEmailLabel));
            registerPage.checkForExistErrorMsg(registerPage.userEmailLabel);
            screenshot.doScreenshot(driver, "userEmailInput");
            registerPage.userEmailInput.clear();
            registerPage.typeAndSendInput(registerPage.userPasswordInput, user.get(2));
            exel.insertResult(registerPage.userPasswordLabel.getText(), registerPage.compareLabelAndInput(registerPage.userPasswordLabel));
            registerPage.checkForExistErrorMsg(registerPage.userPasswordLabel);
            screenshot.doScreenshot(driver, "userPasswordInput");
            registerPage.userPasswordInput.clear();
            registerPage.typeAndSendInput(registerPage.userPasswordConfirmationInput, user.get(3));
            exel.insertResult(registerPage.userPasswordConfirmationLabel.getText(), registerPage.compareLabelAndInput(registerPage.userPasswordConfirmationLabel));
            registerPage.checkForExistErrorMsg(registerPage.userPasswordConfirmationLabel);
            screenshot.doScreenshot(driver, "userPasswordConfirmationInput");
            registerPage.userPasswordConfirmationInput.clear();
            registerPage.typeAndSendInput(registerPage.userFirstNameInput, user.get(4));
            exel.insertResult(registerPage.userFirstNameLabel.getText(), registerPage.compareLabelAndInput(registerPage.userFirstNameLabel));
            registerPage.checkForExistErrorMsg(registerPage.userFirstNameLabel);
            screenshot.doScreenshot(driver, "userFirstNameInput");
            registerPage.userFirstNameInput.clear();
            registerPage.typeAndSendInput(registerPage.userLastNameInput, user.get(5));
            exel.insertResult(registerPage.userLastNameLabel.getText(), registerPage.compareLabelAndInput(registerPage.userLastNameLabel));
            registerPage.checkForExistErrorMsg(registerPage.userLastNameLabel);
            screenshot.doScreenshot(driver, "userLastNameInput");
            registerPage.userLastNameInput.clear();
            registerPage.typeAndSendInput(registerPage.userIrcNickInput, user.get(6));
            exel.insertResult(registerPage.userIrcNickLabel.getText(), registerPage.compareLabelAndInput(registerPage.userIrcNickLabel));
            registerPage.checkForExistErrorMsg(registerPage.userIrcNickLabel);
            screenshot.doScreenshot(driver, "userIrcNickInput");
            registerPage.userIrcNickInput.clear();
            registerPage.typeAndSendInput(registerPage.searchInput, user.get(7));
            exel.insertResult(registerPage.searchLink.getText(), String.valueOf(driver.getTitle().contains(user.get(7))) == "ЛОЖЬ" ? "failed" : "passed");
            screenshot.doScreenshot(driver, "searchInput");
            driver.navigate().back();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }



}

