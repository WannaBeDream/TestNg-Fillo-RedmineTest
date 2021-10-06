package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class RegisterPage {
    @FindBy(xpath = "//a[@class=\"home\"]")
    public WebElement homeLink;
    @FindBy(xpath = "//a[@class=\"projects\"]")
    public WebElement projectsLink;
    @FindBy(xpath = "//a[@class=\"help\"]")
    public WebElement helpLink;
    @FindBy(xpath = "//a[@class=\"login\"]")
    public WebElement loginLink;
    @FindBy(xpath = "//a[@href='http://www.redmine.org/']")
    public WebElement redmineLink;
    @FindBy(id = "user_login")
    public WebElement userInput;
    @FindBy(id = "user_firstname")
    public WebElement userFirstNameInput;
    @FindBy(id = "user_lastname")
    public WebElement userLastNameInput;
    @FindBy(id = "user_mail")
    public WebElement userEmailInput;
    @FindBy(id = "user_password")
    public WebElement userPasswordInput;
    @FindBy(id = "user_password_confirmation")
    public WebElement userPasswordConfirmationInput;
    @FindBy(id = "user_custom_field_values_3")
    public WebElement userIrcNickInput;
    @FindBy(xpath = "//label[@for=\"user_login\"]")
    public WebElement userLabel;
    @FindBy(xpath = "//label[@for=\"user_password\"]")
    public WebElement userPasswordLabel;
    @FindBy(xpath = "//label[@for=\"user_password_confirmation\"]")
    public WebElement userPasswordConfirmationLabel;
    @FindBy(xpath = "//label[@for=\"user_firstname\"]")
    public WebElement userFirstNameLabel;
    @FindBy(xpath = "//label[@for=\"user_lastname\"]")
    public WebElement userLastNameLabel;
    @FindBy(xpath = "//label[@for=\"user_mail\"]")
    public WebElement userEmailLabel;
    @FindBy(xpath = "//label[@for=\"user_custom_field_values_3\"]/span")
    public WebElement userIrcNickLabel;
    @FindBy(xpath = "//input[@type=\"submit\"]")
    public WebElement submitFormInput;
    @FindBy(id = "q")
    public WebElement searchInput;
    @FindBy(xpath = "//input[@id='search-input']")
    public WebElement searchInputAfterQuery;
    @FindBy(xpath = "//a[@class='register']")
    public WebElement registerLink;
    @FindBy(xpath = "//a[@href=\"/search\"]")
    public WebElement searchLink; // +
    @FindBy(id = "errorExplanation")
    public WebElement errorExplanation;
    @FindBy(id = "flash_notice")
    public String flashNotice;  // +
    @FindBy(xpath = "//*[@id='errorExplanation']/ul/li")
    public List<WebElement> listLiSelector;
    public WebDriver driver;
    public final String registerUrl = "https://www.redmine.org/account/register";
    public final String baseUrl = "https://www.redmine.org";
    public String liText;
    public String searchValueForCheck = "React";
    public SoftAssert softassert;

    public RegisterPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
        softassert = new SoftAssert();
    }


    public void typeAndSendInput(WebElement targetInput, String text) throws Exception {
        targetInput.sendKeys(text, Keys.ENTER);

        Thread.sleep(500);
    }

    public void typeDataToInput(WebElement targetInput, String text) throws Exception {
        targetInput.sendKeys(text);

        Thread.sleep(500);
    }

    public String compareLabelAndInput(WebElement label) {
        if (label.getAttribute("class") == "") {
            return "passed";
        } else {
            softassert.assertEquals(label.getAttribute("class"),"");
            return "failed";
        }
    }

    public void checkForExistErrorMsg(WebElement targetLabel) throws InterruptedException {
        if (listLiSelector.size() != 0) {
            Iterator<WebElement> it = this.listLiSelector.iterator();

            while (it.hasNext()) {
                this.liText = it.next().getText().replaceAll("[*]", "");
                if (this.liText.startsWith(targetLabel.getText().replaceAll("[*]", "")) || this.liText.contains("Пароль не совпадает с подтверждением")) {
                    softassert.assertEquals(this.liText, "");
                    continue;
                }
            }
        }
        Thread.sleep(500);
    }



    public void compareCurrentUrlWithBaseUrl(){
        softassert.assertTrue(driver.getCurrentUrl().startsWith(baseUrl));
    }
    public void checkForBreakPage() {
        softassert.assertTrue(checkInternetConnection(driver.getCurrentUrl()));
    }

    public void clickHomeLink () {
        homeLink.click();
    }
    public void clickProjectsLink () {
        projectsLink.click();
    }
    public void clickHelpLink () {
        helpLink.click();
    }
    public void clickLoginLink () {
        loginLink.click();
    }
    public void clickRegisterLink () {
        registerLink.click();
    }
    public void clickRedmineLink () {
        redmineLink.click();
    }


    private static boolean checkInternetConnection(String url) {
        Boolean result = false;
        HttpURLConnection con = null;
        try {
            con = (HttpURLConnection) new URL(url).openConnection();
            con.setRequestMethod("HEAD");
            result = (con.getResponseCode() == HttpURLConnection.HTTP_OK);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
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
    public String getSearchInputAfterQueryText() {
        return searchInputAfterQuery.getText();
    }
    public String getSearchInputValue() {
        return searchInput.getAttribute("value");
    }
    public String getErrorExplanationText() {
        return  errorExplanation.getText();
    }
    public void clickSubmitFormInput() {
        submitFormInput.click();
    }
    public  void clickUserPasswordConfirmationInput() {
        userPasswordConfirmationInput.click();
    }
    public  void clickUserPasswordInput() {
        userPasswordInput.click();
    }

}
