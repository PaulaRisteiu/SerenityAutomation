package Automation.features.search;

import Automation.steps.serenity.*;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class AddToCartServer {

    @Managed
    WebDriver webDriver;
    @Steps
    HomeSteps homeSteps;
    @Steps
    LoginSteps loginSteps;
    @Steps
    LogoutSteps logoutSteps;
    @Steps
    SearchSteps searchSteps;
    @Steps
    AddToCartSteps addToCartSteps;
    @Test
    public void testAddToCart() {
        webDriver.get("https://sanovita.ro/");
        homeSteps.saveCookieChoice();
        homeSteps.shouldBeHomePage("Descoperă cele mai apreciate produse!");
//        homeSteps.navigateToLoginPage();
//        loginSteps.seeLoginPage("CONECTEAZA-TE LA CONTUL TAU");
//        loginSteps.enterEmail("paula.risteiu@yahoo.com");
//        loginSteps.enterPassword("cumparaturi");
//        loginSteps.scrollAuthenticationButton(300);
//        loginSteps.pressLogin();
//        homeSteps.shouldBeHomePage("Descoperă cele mai apreciate produse!");
//        logoutSteps.shouldBeOnMyAccount("CONTUL TAU");
        searchSteps.verifySearchFieldPlaceholder("Cauta produse, programe de dieta, articole, retete");
        searchSteps.enterSearchText("musli");
        searchSteps.verifySearchFieldText("musli");
        searchSteps.pressEnterInSearchField();

        //add to cart
        addToCartSteps.scrollByOffset(400);
        searchSteps.verifySearchResultsAreVisible();
        addToCartSteps.verifyAddToCartButtonIsVisible();
        addToCartSteps.addToCartButtonIsEnabled();
        addToCartSteps.clickAddToCartButton();
    }
}
