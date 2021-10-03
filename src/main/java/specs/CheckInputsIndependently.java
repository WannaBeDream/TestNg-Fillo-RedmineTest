package specs;

import helpers.Screenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.RegisterPage;

import java.io.File;
import java.time.Duration;

public class CheckInputsIndependently extends RegisterPage {
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



    @Test
    public void CheckInputsIndependently()  {
        try {
            registerPage = new RegisterPage(driver);
            screenshot = new Screenshot(driver);

            registerPage.typeAndSendInput(registerPage.userInput,"blabla");
            registerPage.compareLabelAndInput(registerPage.userLabel);
            registerPage.checkForExistErrorMsg(registerPage.userLabel);
            screenshot.doScreenshot(driver,"userInput");
            registerPage.userInput.clear();
            registerPage.typeAndSendInput(registerPage.userEmailInput,"das12dss@gmail.com");
            registerPage.compareLabelAndInput(registerPage.userEmailLabel);
            registerPage.checkForExistErrorMsg(registerPage.userEmailLabel);
            screenshot.doScreenshot(driver,"userEmailInput");
            registerPage.userEmailInput.clear();
            registerPage.typeAndSendInput(registerPage.userPasswordInput,"qwerty228");
            registerPage.compareLabelAndInput(registerPage.userPasswordLabel);
            registerPage.checkForExistErrorMsg(registerPage.userPasswordLabel);
            screenshot.doScreenshot(driver,"userPasswordInput");
            registerPage.userPasswordInput.clear();
            registerPage.typeAndSendInput(registerPage.userPasswordConfirmationInput,"qwerty228");
            registerPage.compareLabelAndInput(registerPage.userPasswordConfirmationLabel);
            registerPage.checkForExistErrorMsg(registerPage.userPasswordConfirmationLabel);
            screenshot.doScreenshot(driver,"userPasswordConfirmationInput");
            registerPage.userPasswordConfirmationInput.clear();
            registerPage.typeAndSendInput(registerPage.userFirstNameInput,"Json");
            registerPage.compareLabelAndInput(registerPage.userFirstNameLabel);
            registerPage.checkForExistErrorMsg(registerPage.userFirstNameLabel);
            screenshot.doScreenshot(driver,"userFirstNameInput");
            registerPage.userFirstNameInput.clear();
            registerPage.typeAndSendInput(registerPage.userLastNameInput,"Statham");
            registerPage.compareLabelAndInput(registerPage.userLastNameLabel);
            registerPage.checkForExistErrorMsg(registerPage.userLastNameLabel);
            screenshot.doScreenshot(driver,"userLastNameInput");
            registerPage.userLastNameInput.clear();
            registerPage.typeAndSendInput(registerPage.userIrcNickInput,"Gai Richi");
            registerPage.compareLabelAndInput(registerPage.userIrcNickLabel);
            registerPage.checkForExistErrorMsg(registerPage.userIrcNickLabel);
            screenshot.doScreenshot(driver,"userIrcNickInput");
            registerPage.userIrcNickInput.clear();
            registerPage.typeAndSendInput(registerPage.searchInput,"blablabla");
            driver.getTitle().contains("blablabla");
            screenshot.doScreenshot(driver,"searchInput");
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

