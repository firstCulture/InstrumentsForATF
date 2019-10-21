package pacages.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

@DefaultUrl("https://www.elefant.md/homepage-mikrosite-cms-home")
public class SignUpPage extends PageObject {

    public static String invalideEmail = "Un utilizator cu adresa de e-mail există deja. Vă rugăm să verificați informațiile cu exactitate sau introduceți o altă adresă de e-mail.";

    private String sexRadioButton = "//div[contains(@class, 'radio radio-inline')]/label[normalize-space()='%s']/input";
    private By
            firstName = By.cssSelector("input#PostCheckoutRegisterForm_FirstName");
    private By lastName = By.cssSelector("input#PostCheckoutRegisterForm_LastName");
    private By email = By.cssSelector("input#PostCheckoutRegisterForm_Login");
    private By createPassword = By.cssSelector("input#PostCheckoutRegisterForm_Password");
    private By confirmPassword = By.cssSelector("input#PostCheckoutRegisterForm_RetypedPassword");
    private By allComunicationPreferences = By.cssSelector("a#selectAll");
    private String separateComunicationPreference = "//div[contains(@class, 'form-group')]/div[contains(@class, 'checkbox shift-right')]/label[text()='%s']/input";
    private By checkBox = By.cssSelector("input#PostCheckoutRegisterForm_TermsAndConditions");
    private By createAccount = By.xpath("//button[contains(@class, 'btn btn-primary btn-block')]");
    private By allErrorLabel = By.xpath("//small[contains(@class, 'help-block')]");
    private String errorLabelByText = "//small[contains(@class, 'help-block') and text()='%s']";
    private By goCreateAccount = By.xpath("//a[contains(@class, 'btn btn-default btn-block')]");

    private By connectButton = By.xpath("//span[contains(@class, 'login-prompt')]");
    private By NextConnectButton = By.xpath("//a[contains(@class, 'my-account-login btn btn-primary btn-block')]");
    private By login = By.xpath("//input[@id='ShopLoginForm_Login']");
    private By LoginPassword = By.xpath("//input[@id='ShopLoginForm_Password']");
    private By connectToAccount = By.xpath("//button[contains(@class, 'btn btn-primary btn-block')]");
    private String inalideEmailError = "//div[contains(@class, 'alert alert-danger')]/div";

    public SignUpPage clickConnectButton() {
       find(connectButton).click();
        return this;
    }

    public SignUpPage clickOnConnectToAccount() {
        find(NextConnectButton).click();
        return this;
    }

    public SignUpPage clickOnCreateNewAccount() {
        find(goCreateAccount).click();
        return this;
    }

    public SignUpPage choseSex(String sex) {
        String xPath = String.format(sexRadioButton, sex);
        find(By.xpath(xPath)).click();
        return this;
    }

    public SignUpPage typeFirstName(String name) {
        find(firstName).sendKeys(name);
        return this;
    }

    public SignUpPage typeLastName(String name) {
        find(lastName).sendKeys(name);
        return this;
    }

    public SignUpPage typeEmail(String mail) {
        find(email).sendKeys(mail);
        return this;
    }

    public SignUpPage typePassword(String password) {
        find(createPassword).sendKeys(password);
        return this;
    }

    public SignUpPage typeConfirmPassword(String confirmPass) {
        find(confirmPassword)
                .waitUntilVisible()
                .sendKeys(confirmPass);
        return this;
    }

    public SignUpPage selectAllComunicationPreferences() {
        find(allComunicationPreferences).click();
        return this;
    }

    public SignUpPage selectSeparateComunicationPreferences(String comunicationPreference) {
        find(By.xpath(String.format(separateComunicationPreference, comunicationPreference))).click();
        return this;
    }

    public SignUpPage clickOnCheckBox() {
        find(checkBox)
                .waitUntilVisible()
                .click();
        return this;
    }

    public SignUpPage creatAccount() {
        find(createAccount)
                .waitUntilVisible()
                .click();
        return this;
    }

    public List<String> AllErrorMessages() {
        final List<WebElement> allErrors = new ArrayList<WebElement>(findAll(allErrorLabel));
        List<String> errorMessages = new ArrayList<String>();

        for(WebElement element : allErrors) {
            errorMessages.add(element.getText());
        }

        return errorMessages;
    }

    public SignUpPage findErrorMessageByText(String message) {
        find(By.xpath(String.format(errorLabelByText, message))).getText();
        return this;
    }

    public boolean isErrorVisible(String message) {
        return find(By.xpath(String.format(errorLabelByText, message))).isDisplayed();
    }

    public String invalideEmailError() {
        return  find(By.xpath(inalideEmailError)).getText();
    }

}
