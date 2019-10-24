package tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pacages.pages.SignUpPage;
import pacages.pages.util.GeneralStepDefs;
import steps.serenity.SignUpStepDefs;

@RunWith(SerenityRunner.class)
public class WhenSignUpTest {

    @Steps
    SignUpStepDefs steps;
    GeneralStepDefs generalStepDefs;

    @Managed
    WebDriver driver;

    @Test
    @Title("User type existing email")
    public void typeExistingEmail() throws InterruptedException {
        steps.openSignUpPage();
        steps.clickConnectButton();
        steps.clickOnCreateNewAccount();
//        steps.choseTheSex("Dl.");
        steps.typeFirstName("Alex");
        steps.typeLastName("Ciobanu");
        steps.typeEmail("caldare_alex@mail.ru");
        steps.typePassword("123tarakan");
        steps.typeConfirmPassword("123tarakan");
        steps.scrollDown(1);
        steps.choseComunicationWay("SMS");
        steps.choseComunicationWay("E-mail personalizat");
        steps.setCheckBox();
        steps.createAccount();
        steps.shouldWait(2000);

        steps.valuesShouldBeEqual(steps.getInvalidMailError(), SignUpPage.invalideEmail);
    }

    @Test
    @Pending
    public void validateEmptyFirstName() throws InterruptedException {
        steps.openSignUpPage();
        steps.clickConnectButton();
        steps.clickOnCreateNewAccount();
//        steps.choseTheSex("Dna");
        steps.typeLastName("Ciobanu");
        steps.typeEmail("caldare_test@mail.ru");
        steps.scrollDown(1);
        steps.choseComunicationWay("SMS");
        steps.choseComunicationWay("E-mail personalizat");
        steps.setCheckBox();
        steps.createAccount();
        steps.shouldWait(2000);
        steps.scrollUp(1);

        steps.shouldSeeTheError("Vă rugăm să introduceți un prenume");
    }

    @Test
    @Title("")
    public void validateEmptyPassword() throws InterruptedException {
        steps.openSignUpPage();
        steps.clickConnectButton();
        steps.clickOnCreateNewAccount();
//        steps.choseTheSex("Dna");
        steps.typeLastName("Ciobanu");
        steps.typeEmail("caldare_test@mail.ru");
        steps.typePassword("123tarakan");
        steps.typeConfirmPassword("123tarakan");
        steps.scrollDown(1);
        steps.choseComunicationWay("SMS");
        steps.choseComunicationWay("E-mail personalizat");
        steps.setCheckBox();
        steps.createAccount();
        steps.shouldWait(2000);

        steps.shouldSeeTheError("Vă rugăm să introduceți o parolă validă.");
        steps.shouldSeeTheError("Vă rugăm să introduceți o parolă valabilă Confirmați.");

    }

}
