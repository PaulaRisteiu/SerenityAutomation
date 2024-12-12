package Automation.steps.serenity;

import Automation.pages.LogoutPage;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.JavascriptExecutor;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class LogoutSteps {

    private LogoutPage logoutPage;

    @Step
    public void shouldBeOnMyAccount(String text) {
       assertTrue(logoutPage.myAccountText().contains(text));
    }

    @Step
    public void pressLogout() {
        logoutPage.clickLogout();
    }

}