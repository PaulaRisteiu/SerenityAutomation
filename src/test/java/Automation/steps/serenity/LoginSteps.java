package Automation.steps.serenity;

import Automation.pages.LoginPage;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.JavascriptExecutor;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.junit.Assert.assertTrue;

public class LoginSteps {

    private LoginPage loginPage;

    @Step
    public void seeLoginPage(String text) {
        assertTrue(loginPage.getLoginText().contains(text));
    }

    @Step
    public void enterEmail(String email) {
        loginPage.testEmailInput(email);
    }

    @Step
    public void enterPassword(String password) {
        loginPage.testPasswordInput(password);
    }

    public void scrollAuthenticationButton(int offset) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("window.scrollBy(0, arguments[0]);", offset);
    }

    @Step
    public void pressLogin() {
        loginPage.testloginButton();
    }

}
