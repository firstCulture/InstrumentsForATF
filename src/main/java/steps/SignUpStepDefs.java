package steps;

import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;
import pacages.pages.SignUpPage;

public class SignUpStepDefs {

    SignUpPage signUpPage;

    @Step
    public void openSignUpPage() {
        signUpPage.open();
    }

    @Step("User types email [0]")
    public void typeEmail(String mail) {
        signUpPage.typeEmail(mail);
    }

    @Step
    public void typeFirstName(String name) {
        signUpPage.typeFirstName(name);
    }

    @Step
    public void typeLastName(String name) {
        signUpPage.typeLastName(name);
    }

    @Step
    public void typePassword(String password) {
        signUpPage.typePassword(password);
    }

    @Step
    public void typeConfirmPassword(String password) {
        signUpPage.typeConfirmPassword(password);
    }

    @Step
    public void choseTheSex(String sex) {
        signUpPage.choseSex(sex);
    }

    @Step
    public void choseComunicationWay(String comunication) {
        signUpPage.evaluateJavascript("window.scrollTo(0, 500);");
        signUpPage.selectSeparateComunicationPreferences(comunication);
    }

    @Step
    public void scrollDown(int times) {

        for(int i = 0; i <= times; i++) {
            signUpPage.evaluateJavascript("window.scrollTo(0, 500);");
        }
    }

    @Step
    public void scrollUp(int times) {

        for(int i = 0; i <= times; i++) {
            signUpPage.evaluateJavascript("window.scrollTo(0, -500);");
        }
    }

    @Step
    public void choseAllComunicationWays() {
        signUpPage.selectAllComunicationPreferences();
    }

    @Step
    public void setCheckBox() {
        signUpPage.clickOnCheckBox();
    }

    @Step
    public void createAccount() {
        signUpPage.creatAccount();
    }

    @Step
    public void clickConnectButton() {
        signUpPage.clickConnectButton();
    }

    @Step
    public void clickOnCreateNewAccount() {
        signUpPage.clickOnCreateNewAccount();
    }

    @Step
    public String getInvalidMailError() {
        return signUpPage.invalideEmailError();
    }


    @Step
    public void shouldSeeTheError(final String message) {
        Assertions.assertThat(signUpPage.isErrorVisible(message))
                .as("The error: '" + message + "' should be visible")
                .isTrue();
    }

    @Step
    public void shouldNotSeeTheError(final String message) {
        Assertions.assertThat(signUpPage.isErrorVisible(message))
                .as("The error: '" + message + "' should not be visible")
                .isFalse();
    }

//    @Step
//    public void shouldSeeTheErrorsCount(final int count) {
//        Assertions.assertThat(signUpPage.AllErrorMessages())
//                .as("The errors count is: '" + count + "'")
//                .hasSize(count);
//    }

    @Step
    public void valuesShouldBeEqual(final String actual, final String expected) {
        Assertions.assertThat(actual)
                .as("The actual result: '" + actual + "' should be equal with expected result: '" + expected + "'")
                .isEqualTo(expected);
    }

    @Step
    public void shouldWait(final int milliseconds) throws InterruptedException {
        Thread.sleep(milliseconds);
    }
}
