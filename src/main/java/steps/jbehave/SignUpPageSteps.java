package steps.jbehave;


import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import steps.serenity.SignUpStepDefs;

public class SignUpPageSteps {

    @Steps
    SignUpStepDefs signUpStepDefs;

    @Given("user opens signup page")
    public void givenUserOpensSignupPage() {
        signUpStepDefs.openSignUpPage();
    }

    @When("user clicks on connect button")
    public void clicksOnConnectButton() {
        signUpStepDefs.clickConnectButton();
    }

    @When("user clicks on new account button")
    public void clicksOnNewAccountButton() {
        signUpStepDefs.clickOnCreateNewAccount();
    }

    @When("user type \"$firstName\" first name")
    public void typeFisrtName(String firstName) {
        signUpStepDefs.typeFirstName(firstName);
    }

    @When("user type \"$lastName\" last name")
    public void typeLastName(String lastName) {
        signUpStepDefs.typeLastName(lastName);
    }

    @When("user type \"$mail\" email")
    public void typeMail(String mail) {
        signUpStepDefs.typeEmail(mail);
    }

    @When("user type \"$password\" password")
    public void typePassword(String password) {
        signUpStepDefs.typePassword(password);
    }

    @When("user type \"$confirmPassword\" confim password")
    public void typeConfirmPassword(String confirmPassword) {
        signUpStepDefs.typeConfirmPassword(confirmPassword);
    }

    @When("user scroll down \"$count\" times")
    public void scrollDown(int count) {
        signUpStepDefs.scrollDown(count);
    }

    @When("user scroll up \"$count\" times")
    public void scrollUp(int count) {
        signUpStepDefs.scrollUp(count);
    }

    @When("user set \"$communicationWay\" communication way")
    public void setCommunicationWay(String communicationWay) {
        signUpStepDefs.choseCommunicationWay(communicationWay);
    }

    @When("user set all communication ways")
    public void setAllCommunicationWays() {
        signUpStepDefs.choseAllCommunicationWays();
    }

    @When("user set the check box")
    public void setCheckBox() {
        signUpStepDefs.setCheckBox();
    }

    @When("user should wait \"$count\" seconds")
    public void setWait(int count) throws InterruptedException {
        signUpStepDefs.shouldWait(count);
    }

    @Then("user should see the error \"$error\"")
    public void shoutSeeTheError(String error) {
        signUpStepDefs.shouldSeeTheError(error);
    }

}
