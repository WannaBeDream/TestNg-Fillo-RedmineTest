package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class RegisterPage {
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
    @FindBy(xpath = "//a[@class='register']")
    public WebElement registerLink;
    @FindBy(xpath = "//a[@href=\"/search\"]")
    public WebElement searchLink;
    public String errorExplanation = "errorExplanation";
    public String flashNotice = "flash_notice";
    public HttpURLConnection huc;
    public WebDriver driver;
    public final String registerUrl = "https://www.redmine.org/account/register";
    public int respCode = 200;
    public String url;
    public String liText;
    public List<WebElement> links;
    public List<WebElement> listLi;
    public String listLiSelector = "#errorExplanation ul li";


    public RegisterPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public RegisterPage() {
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
            System.out.println("label " + label.getText().replaceAll("[*]", "") + " without error");
            return "passed";
        } else {
            System.out.println("label " + label.getText().replaceAll("[*]", "") + " with error");
            return "failed";
        }
    }

    public void checkForExistErrorMsg(WebElement targetLabel) throws InterruptedException {

        if (driver.findElements(By.id(errorExplanation)).size() != 0) {
            this.listLi = driver.findElements(By.cssSelector(listLiSelector));
            Iterator<WebElement> it = this.listLi.iterator();

            while (it.hasNext()) {
                this.liText = it.next().getText();
                if (this.liText.startsWith(targetLabel.getText().replaceAll("[*]", ""))) {
                    System.out.println("Error message validation is worked with " + targetLabel.getText().substring(0, targetLabel.getText().length() - 1));
                    continue;
                }

            }
        } else {
            System.out.println("Error message hasn't exist");
        }
        Thread.sleep(500);
    }


    public void checkAllLinksByHttpCode() throws Exception {
        this.links = (List<WebElement>) driver.findElements(By.tagName("a"));
        Iterator<WebElement> it = this.links.iterator();

        while (it.hasNext()) {
            this.url = it.next().getAttribute("href");
            System.out.println(this.url);

            if (this.url == null || this.url.isEmpty()) {
                System.out.println("URL is either not configured for anchor tag or it is empty");
                continue;
            }

            if (!this.url.startsWith(this.registerUrl)) {
                System.out.println("URL belongs to another domain, skipping it.");
                continue;
            }


            this.huc = (HttpURLConnection) (new URL(this.url).openConnection());
            this.huc.setRequestMethod("HEAD");
            this.huc.connect();
            this.respCode = this.huc.getResponseCode();

            if (this.respCode >= 400) {
                System.out.println(this.url + " is a broken link");
                throw new Exception("Test failed because some link is broken");
            } else {
                System.out.println(this.url + " is a valid link");
            }
        }
    }


}
