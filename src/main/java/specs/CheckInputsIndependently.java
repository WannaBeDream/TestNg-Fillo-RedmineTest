package specs;

import helpers.Screenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.RegisterPage;

import java.io.File;
import java.time.Duration;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CheckInputsIndependently  {
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

    @Test
    public void checkUserInput() throws Exception {
        registerPage.setUserInput("Vasya123128");
        registerPage.clickSubmitFormInput();
        screenshot.doScreenshot(driver,"userInput");
        registerPage.compareLabelAndInput(registerPage.getUserLabelClassText());
        assertFalse(registerPage.isErrorLiDisplayedByPath(registerPage.getUserErrorPath()),"User error is displayed");
    }
    @Test
    public void checkUserEmailInput() throws Exception {
        registerPage.setUserEmailInput("Vasya123128@gmail.com");
        registerPage.clickSubmitFormInput();
        screenshot.doScreenshot(driver,"userEmailInput");
        registerPage.compareLabelAndInput(registerPage.getEmailLabelClassText());
        assertFalse(registerPage.isErrorLiDisplayedByPath(registerPage.getEmailErrorPath()),"Email error is displayed");
    }
    @Test
    public void checkUserPasswordInput() throws Exception {
        registerPage.setUserPasswordInput("wdwe3232");
        registerPage.clickSubmitFormInput();
        screenshot.doScreenshot(driver,"userPasswordInput");
        registerPage.compareLabelAndInput(registerPage.getUserPasswordLabelClassText());
        assertFalse(registerPage.isErrorLiDisplayedByPath(registerPage.getPasswordErrorPath()),"Password error is displayed");
    }
    @Test
    public void checkUserPasswordConfirmationInput() throws Exception {
        registerPage.setUserPasswordConfirmationInput("wdwe3232");
        registerPage.clickSubmitFormInput();
        screenshot.doScreenshot(driver,"userPasswordConfirmationInput");
        registerPage.compareLabelAndInput(registerPage.getUserPasswordConfirmationLabelClassText());
        assertFalse(registerPage.isErrorLiDisplayedByPath(registerPage.getPasswordConfirmErrorPath()),"Password confirmation error is displayed");
    }
    @Test
    public void checkUserFirstNameInput() throws Exception {
        registerPage.setUserFirstNameInput("wsdcsdfd");
        registerPage.clickSubmitFormInput();
        screenshot.doScreenshot(driver,"userFirstNameInput");
        registerPage.compareLabelAndInput(registerPage.getFirstNameLabelClassText());
        assertFalse(registerPage.isErrorLiDisplayedByPath(registerPage.getFirstNameErrorPath()),"Firstname error is displayed");
    }
    @Test
    public void checkUserLastNameInput() throws Exception {
        registerPage.setUserLastNameInput("wsdfdsf");
        registerPage.clickSubmitFormInput();
        screenshot.doScreenshot(driver,"userLastNameInput");
        registerPage.compareLabelAndInput(registerPage.getLastNameLabelClassText());
        assertFalse(registerPage.isErrorLiDisplayedByPath(registerPage.getLastNameErrorPath()),"Lastname error is displayed");;
    }
    @Test(dependsOnMethods={"checkUserPasswordInput"}, alwaysRun = true)
    public void checkSearchInput() throws Exception {
        registerPage.setSearchInput(registerPage.getSearchValueForCheck());
        registerPage.clickSearchLink();
        screenshot.doScreenshot(driver,"searchInput");
        assertTrue(driver.getCurrentUrl().contains(registerPage.getSearchValueForCheck()),"Current url doesn't contain searched value");
    }

    @AfterMethod
    public void afterMethod() {
        registerPage.clickRegisterLink();
    }


    @AfterClass
    public void afterTest() {
        driver.quit();
    }

}

