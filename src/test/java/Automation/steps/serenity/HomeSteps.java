package Automation.steps.serenity;

import Automation.pages.HomePage;
import net.thucydides.core.annotations.Step;

import static junit.framework.TestCase.assertTrue;

public class HomeSteps {
    private HomePage homePage;
    @Step
    public void saveCookieChoice() {
        homePage.setCookieChoice();
    }

    @Step
    public void navigateToLoginPage(){
        homePage.testAuthenticationLink();
    }

    @Step
    public void shouldBeHomePage(String text) {
        assertTrue(homePage.getHomePageText().contains(text));
    }

}
