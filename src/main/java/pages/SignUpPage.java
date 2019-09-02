package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import steps.GeneralStepDefs;

import java.util.ArrayList;
import java.util.List;

public class SignUpPage {

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private final WebDriver driver;

    GeneralStepDefs generalStepDefs;

    public static String invalideEmail = "Un utilizator cu adresa de e-mail există deja. Vă rugăm să verificați informațiile cu exactitate sau introduceți o altă adresă de e-mail.";

    private String sexRadioButton = "//div[contains(@class, 'radio radio-inline')]/label[normalize-space()='%s']/input";
    private By firstName = By.cssSelector("input#PostCheckoutRegisterForm_FirstName");
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


    public SignUpPage openPage() {
        System.setProperty("webdriver.chrome.driver", "D:\\Testing&Programming\\Java\\chromedriver.exe");
        WebDriver driver  = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.elefant.md");
        return this;
    }

    public SignUpPage goCreateAccount() {
        goCreateAccount.findElement(driver).click();
        return this;
    }

    public SignUpPage clickConnectButton() {
        driver.findElement(connectButton).click();
        return this;
    }

    public SignUpPage clickOnCreateNewAccount() {
        driver.findElement(NextConnectButton).click();
        return this;
    }

    public SignUpPage choseSex(String sex) {
        driver.findElement(By.xpath(String.format(sexRadioButton, sex))).click();
        return this;
    }

    public SignUpPage typeFirstName(String name) {
        driver.findElement(firstName).sendKeys(name);
        return this;
    }

    public SignUpPage typeLastName(String name) {
        driver.findElement(lastName).sendKeys(name);
        return this;
    }

    public SignUpPage typeEmail(String mail) {
        driver.findElement(email).sendKeys(mail);
        return this;
    }

    public SignUpPage typePassword(String password) {
        driver.findElement(createPassword).sendKeys(password);
        return this;
    }

    public SignUpPage typeConfirmPassword(String confirmPass) {
        generalStepDefs.waitForVisibilityOf((WebElement) confirmPassword, 5);
        driver.findElement(confirmPassword).sendKeys(confirmPass);
        return this;
    }

    public SignUpPage selectAllComunicationPreferences() {
        driver.findElement(allComunicationPreferences).click();
        return this;
    }

    public SignUpPage selectSeparateComunicationPreferences(String comunicationPreference) {
        driver.findElement(By.xpath(String.format(separateComunicationPreference, comunicationPreference))).click();
        return this;
    }

    public SignUpPage clickOnCheckBox() {
        generalStepDefs.waitForVisibilityOf((WebElement) checkBox, 5);
        driver.findElement(checkBox).click();
        return this;
    }

    public void creatAccount() {
        generalStepDefs.waitForVisibilityOf((WebElement) createAccount, 5);
        driver.findElement(createAccount).click();
    }

    public List<String> AllErrorMessages() {
        final List<WebElement> allErrors = new ArrayList<WebElement>(driver.findElements(allErrorLabel));
        List<String> errorMessages = new ArrayList<>();
        allErrors.forEach(element -> errorMessages.add(element.getText()));

        return errorMessages;
    }

    public SignUpPage findErrorMessageByText(String message) {
        driver.findElement(By.xpath(String.format(errorLabelByText, message))).getText();
        return this;
    }

    public boolean isErrorVisible(String message) {
        return driver.findElement(By.xpath(String.format(errorLabelByText, message))).isDisplayed();
    }

    public SignUpPage invalideEmailError() {
        driver.findElement(By.xpath(inalideEmailError)).getText();
        return this;
    }

}
