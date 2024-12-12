package Automation.features.search;

import Automation.steps.serenity.HomeSteps;
import Automation.steps.serenity.LoginSteps;
import Automation.steps.serenity.LogoutSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/features/search/DataSearch.csv")
public class ParametirizedTests {

    @Managed(uniqueSession = true, driver="chrome")
    public WebDriver webDriver;
    @Steps
    HomeSteps homeSteps;
    @Steps
    LoginSteps loginSteps;

    String email, password;

    @Test
    public void loginLogout(){
        webDriver.get("https://sanovita.ro/");
        homeSteps.saveCookieChoice();
        homeSteps.shouldBeHomePage("Descoperă cele mai apreciate produse!");
        homeSteps.navigateToLoginPage();
        loginSteps.seeLoginPage("CONECTEAZA-TE LA CONTUL TAU");
        loginSteps.enterEmail(email);
        loginSteps.enterPassword(password);
        loginSteps.scrollAuthenticationButton(300);
        loginSteps.pressLogin();
    }
}
