package steps;

import net.thucydides.core.annotations.Step;
import pages.SignUpPage;

public class SignUpStepDefs {

    SignUpPage signUpPage;

    @Step("User types email [0]")
    public void typeEmail (String mail) {
        signUpPage.typeEmail(mail);
    }

    @Step("User types first name [0]")
    public void typeFirstName (String name) {
        signUpPage.typeFirstName(name);
    }

    @Step("User types last name [0]")
    public void typeLastName (String name) {
        signUpPage.typeLastName(name);
    }

    @Step("User types password [0]")
    public void typePassword (String password) {
        signUpPage.typePassword(password);
    }

    @Step("User types confirm password [0]")
    public void typeConfirmPassword (String password) {
        signUpPage.typeConfirmPassword(password);
    }

    @Step("User chose the sex [0]")
    public void choseTheSex(String sex) {
        signUpPage.choseSex(sex);
    }

    @Step("User chose comunication way [0]")
    public void choseComunicationWay (String comunication) {
        signUpPage.selectSeparateComunicationPreferences(comunication);
    }

    @Step("User chose all comunication ways")
    public void choseAllComunicationWays () {
        signUpPage.selectAllComunicationPreferences();
    }

    @Step("User set check box")
    public void setCheckBox () {
        signUpPage.clickOnCheckBox();
    }

    @Step("User click on create account")
    public void createAccount () {
        signUpPage.creatAccount();
    }

    @Step("User click on connect button")
    public void clickConnectButton() {
        signUpPage.clickConnectButton();
    }

    @Step("User click on create new account")
    public void clickOnCreateNewAccount() {
        signUpPage.clickOnCreateNewAccount();
    }

}
