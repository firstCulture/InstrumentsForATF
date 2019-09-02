import kotlin.collections.AbstractList;
import org.aspectj.lang.annotation.After;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import pages.SignUpPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SignUpTest {

    private SignUpPage page;
    private  WebDriver driver;

    @Before
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\Testing&Programming\\Java\\chromedriver.exe");
    }

    @Test
    public void createAccount() throws InterruptedException {
        page = new SignUpPage(driver);
        page.openPage()
                .clickConnectButton()
                .goCreateAccount()
                .choseSex("Dna")
                .typeFirstName("Alex")
                .typeLastName("Ciobanu")
                .typeEmail("caldare_alex@mail.ru")
                .typePassword("123tarakan")
                .typeConfirmPassword("123tarakan")
                .selectSeparateComunicationPreferences("SMS")
                .selectSeparateComunicationPreferences("E-mail personalizat")
                .clickOnCheckBox()
                .creatAccount();
        Thread.sleep(2000);

        assertEquals(page.invalideEmailError(), SignUpPage.invalideEmail);
    }

    @Test
    public void validateEmptyFirstName() throws InterruptedException {
        page = new SignUpPage(driver);
        page.openPage()
                .clickConnectButton()
                .goCreateAccount()
                .choseSex("Dna")
                .typeLastName("Ciobanu")
                .typeEmail("caldare_alex@mail.ru")
                .typePassword("123tarakan")
                .typeConfirmPassword("123tarakan")
                .selectSeparateComunicationPreferences("SMS")
                .selectSeparateComunicationPreferences("E-mail personalizat")
                .clickOnCheckBox()
                .creatAccount();
        Thread.sleep(2000);

        assertTrue(page.isErrorVisible("Vă rugăm să introduceți un prenume"));
    }

}
