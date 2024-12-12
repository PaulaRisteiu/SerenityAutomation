package Automation.features.search;

import Automation.steps.serenity.HomeSteps;
import Automation.steps.serenity.LoginSteps;
import Automation.steps.serenity.LogoutSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class LoginLogoutServer {

    @Managed
    WebDriver webDriver;
    @Steps
    HomeSteps homeSteps;
    @Steps
    LoginSteps loginSteps;
    @Steps
    LogoutSteps logoutSteps;


    @Test
    public void loginLogout(){
        webDriver.get("https://sanovita.ro/");
        homeSteps.saveCookieChoice();
        homeSteps.shouldBeHomePage("Descoperă cele mai apreciate produse!");
        homeSteps.navigateToLoginPage();
        loginSteps.seeLoginPage("CONECTEAZA-TE LA CONTUL TAU");
        loginSteps.enterEmail("paula.risteiu@yahoo.com");
        loginSteps.enterPassword("cumparaturi");
        loginSteps.scrollAuthenticationButton(300);
        loginSteps.pressLogin();
        homeSteps.shouldBeHomePage("Descoperă cele mai apreciate produse!");
        logoutSteps.shouldBeOnMyAccount("CONTUL TAU");
        logoutSteps.pressLogout();
        loginSteps.seeLoginPage("CONECTEAZA-TE LA CONTUL TAU");
    }
}
