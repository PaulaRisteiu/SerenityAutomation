package Automation.features.search;

import Automation.steps.serenity.*;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
@RunWith(SerenityRunner.class)
public class CartServerTest {

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
    @Steps
    CartSteps cartSteps;

    @Test
    public void deleteFromCart() {

        //login and logout
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

        //wait until popp-up dissapear
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //delete from cart
        cartSteps.verifyImageCart();
        cartSteps.cartButtonVisible();
        cartSteps.cartButtonVisible();
        cartSteps.clickCartButton();
        cartSteps.deleteButtonIsVisible();
        cartSteps.deleteProductFromCart();
        cartSteps.cartMessageVisible();
        cartSteps.emptyCartMessageText("Nu mai sunt produse in cosul tau");

    }
}
