package Automation.steps.serenity;

import Automation.pages.CartPage;
import net.thucydides.core.annotations.Step;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CartSteps {
    private CartPage cartPage;
    @Step
    public void verifyImageCart(){
        assertTrue("Imaginea coșului nu este vizibilă!", cartPage.cartImageIsVisible());
    }

    @Step
    public void cartButtonVisible() {
        assertTrue("Butonul coșului nu este vizibil!", cartPage.isCartToggleVisible());
    }

    @Step
    public void clickCartButton() {
        cartPage.clickCartToggle();
    }
    @Step
    public void deleteButtonIsVisible() {
        assertTrue("Butonul de ștergere a produsului nu este vizibil!", cartPage.isDeleteButtonVisible());
    }

    @Step
    public void deleteProductFromCart() {
        cartPage.clickDeleteFromCartButton();
    }

    @Step
    public void cartMessageVisible() {
        assertTrue("Mesajul coșului gol nu este vizibil!", cartPage.isCartEmpty());
    }

    @Step
    public void emptyCartMessageText(String expectedText) {
        assertEquals("Textul mesajului coșului gol nu este corect!", expectedText, cartPage.getEmptyCartMessage());
    }
}
