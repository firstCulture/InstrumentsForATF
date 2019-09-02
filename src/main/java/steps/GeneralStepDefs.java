package steps;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.SignUpPage;

public class GeneralStepDefs {
    WebDriver driver;
    SignUpPage signUpPage;

    public void scrollDown( ) {
        JavascriptExecutor js = (JavascriptExecutor) signUpPage;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void scrollDownNTimes(final int times) {
        JavascriptExecutor js = (JavascriptExecutor) signUpPage;

        for (int i = 0; i < times; i++) {
            js.executeScript("window.scrollTo(0, 500);");
        }
    }

    public void waitForVisibilityOf(final WebElement elemnt, final int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOf(elemnt));
    }
}
