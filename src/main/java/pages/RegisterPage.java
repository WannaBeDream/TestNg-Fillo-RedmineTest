package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class RegisterPage {
    @FindBy(xpath = "//a[@class=\"home\"]")
    private WebElement homeLink;
    @FindBy(id = "user_firstname")
    private WebElement userFirstNameInput;
    @FindBy(id = "user_lastname")
    private WebElement userLastNameInput;
    @FindBy(id = "user_mail")
    private WebElement userEmailInput;
    @FindBy(id = "user_password")
    private WebElement userPasswordInput;
    @FindBy(id = "user_password_confirmation")
    private WebElement userPasswordConfirmationInput;
    @FindBy(id = "user_custom_field_values_3")
    private WebElement userIrcNickInput;
    @FindBy(xpath = "//label[@for=\"user_login\"]")
    private WebElement userLabel;
    @FindBy(xpath = "//label[@for=\"user_password\"]")
    private WebElement userPasswordLabel;
    @FindBy(xpath = "//label[@for=\"user_password_confirmation\"]")
    private WebElement userPasswordConfirmationLabel;
    @FindBy(xpath = "//label[@for=\"user_firstname\"]")
    private WebElement userFirstNameLabel;
    @FindBy(xpath = "//label[@for=\"user_lastname\"]")
    private WebElement userLastNameLabel;
    @FindBy(xpath = "//label[@for=\"user_mail\"]")
    private WebElement userEmailLabel;
    @FindBy(xpath = "//label[@for=\"user_custom_field_values_3\"]/span")
    private WebElement userIrcNickLabel;
    @FindBy(xpath = "//input[@type=\"submit\"]")
    private WebElement submitFormInput;
    @FindBy(id = "q")
    private WebElement searchInput;
    @FindBy(xpath = "//input[@id='search-input']")
    private WebElement searchInputAfterQuery;
    @FindBy(xpath = "//a[@class='register']")
    private WebElement registerLink;
    @FindBy(xpath = "//a[@href=\"/search\"]")
    private WebElement searchLink; // +
    @FindBy(id = "errorExplanation")
    private WebElement errorExplanation;
    @FindBy(id = "flash_notice")
    private String flashNotice;  // +
    @FindBy(xpath = "//*[@id='errorExplanation']/ul/li")
    private List<WebElement> listLiSelector;
    @FindBy(xpath = "//a[@class=\"projects\"]")
    private WebElement projectsLink;
    @FindBy(xpath = "//a[@class=\"help\"]")
    private WebElement helpLink;
    @FindBy(xpath = "//a[@class=\"login\"]")
    private WebElement loginLink;
    @FindBy(xpath = "//a[@href='http://www.redmine.org/']")
    private WebElement redmineLink;
    @FindBy(id = "user_login")
    private WebElement userInput;
    private final String userErrorPath = "//*[@id='errorExplanation']//li[contains(text(),'????????????????????????')]";
    private final String emailErrorPath = "//*[@id='errorExplanation']//li[contains(text(),'Email')]";
    private final String passwordErrorPath = "//*[@id='errorExplanation']//li[contains(text(),'????????????')]";
    private final String passwordConfirmErrorPath = "//*[@id='errorExplanation']//li[contains(text(),'??????????????????????????')]";
    private final String firstNameErrorPath = "//*[@id='errorExplanation']//li[contains(text(),'??????')]";
    private final String lastNameErrorPath = "//*[@id='errorExplanation']//li[contains(text(),'??????????????')]";
    private WebDriver driver;
    private final String registerUrl = "https://www.redmine.org/account/register";
    private final String baseUrl = "https://www.redmine.org";
    private final String searchValueForCheck = "React";

    public String getUserErrorPath() {
        return userErrorPath;
    }

    public String getEmailErrorPath() {
        return emailErrorPath;
    }

    public String getPasswordErrorPath() {
        return passwordErrorPath;
    }

    public String getPasswordConfirmErrorPath() {
        return passwordConfirmErrorPath;
    }

    public String getFirstNameErrorPath() {
        return firstNameErrorPath;
    }

    public String getLastNameErrorPath() {
        return lastNameErrorPath;
    }

    public WebElement getUserLabel() {
        return userLabel;
    }

    public WebElement getUserPasswordLabel() {
        return userPasswordLabel;
    }

    public WebElement getUserPasswordConfirmationLabel() {
        return userPasswordConfirmationLabel;
    }

    public WebElement getUserFirstNameLabel() {
        return userFirstNameLabel;
    }

    public WebElement getUserLastNameLabel() {
        return userLastNameLabel;
    }

    public WebElement getUserEmailLabel() {
        return userEmailLabel;
    }

    public WebElement getUserIrcNickLabel() {
        return userIrcNickLabel;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public String getRegisterUrl() {
        return registerUrl;
    }

    public String getSearchValueForCheck() {
        return searchValueForCheck;
    }

    public void setUserFirstNameInput(String value) {
        userFirstNameInput.sendKeys(value);
    }

    public void setUserLastNameInput(String value) {
        userLastNameInput.sendKeys(value);
    }

    public void setUserEmailInput(String value) {
        userEmailInput.sendKeys(value);
    }

    public void setUserPasswordInput(String value) {
        userPasswordInput.sendKeys(value);
    }

    public void setUserPasswordConfirmationInput(String value) {
        userPasswordConfirmationInput.sendKeys(value);
    }

    public void setUserIrcNickInput(String value) {
        userIrcNickInput.sendKeys(value);
    }

    public void setSearchInput(String value) {
        searchInput.sendKeys(value);
    }

    public void setUserInput(String value) {
        userInput.sendKeys(value);
    }

    public void clickSubmitFormInput() {
        submitFormInput.click();
    }

    public void clickSearchLink() {
        searchLink.click();
    }

    public void clickUserPasswordConfirmationInput() {
        userPasswordConfirmationInput.click();
    }

    public void clickUserPasswordInput() {
        userPasswordInput.click();
    }

    public String getUserLabelText() {
        return userLabel.getText();
    }

    public String getUserPasswordLabelText() {
        return userPasswordLabel.getText();
    }

    public String getUserPasswordConfirmationLabelText() {
        return userPasswordConfirmationLabel.getText();
    }

    public String getFirstNameLabelText() {
        return userFirstNameLabel.getText();
    }

    public String getLastNameLabelText() {
        return userLastNameLabel.getText();
    }

    public String getEmailLabelText() {
        return userEmailLabel.getText();
    }

    public String getIrcNickLabelText() {
        return userIrcNickLabel.getText();
    }

    public String getUserLabelClassText() {
        return getUserLabel().getAttribute("class");
    }

    public String getUserPasswordLabelClassText() {
        return getUserPasswordLabel().getAttribute("class");
    }

    public String getUserPasswordConfirmationLabelClassText() {
        return getUserPasswordConfirmationLabel().getAttribute("class");
    }

    public String getFirstNameLabelClassText() {
        return getUserFirstNameLabel().getAttribute("class");
    }

    public String getLastNameLabelClassText() {
        return getUserLastNameLabel().getAttribute("class");
    }

    public String getEmailLabelClassText() {
        return getUserEmailLabel().getAttribute("class");
    }

    public String getIrcNickLabelClassText() {
        return getUserIrcNickLabel().getAttribute("class");
    }

    public void clickHomeLink() {
        homeLink.click();
    }

    public void clickProjectsLink() {
        projectsLink.click();
    }

    public void clickHelpLink() {
        helpLink.click();
    }

    public void clickLoginLink() {
        loginLink.click();
    }

    public void clickRegisterLink() {
        registerLink.click();
    }

    public void clickRedmineLink() {
        redmineLink.click();
    }


    public boolean isErrorLiDisplayedByPath(String path) {
        if (driver.findElements(By.xpath(path)).size() != 0) {
            return driver.findElement(By.xpath(path)).isDisplayed();
        }
        return false;
    }

    public RegisterPage(WebDriver driver) {
        this.setDriver(driver);
        PageFactory.initElements(driver, this);
    }


    public String compareLabelAndInput(String classValue) {
        if (classValue == "") {
            return "passed"; // true?
        } else {
            assertTrue(classValue.contains(""), "Label doesn't contain empty value, means error exist");
            return "failed"; // false?
        }
    }

    public void compareCurrentUrlWithBaseUrl() {
        assertTrue(driver.getCurrentUrl().startsWith(baseUrl));
    }
}
