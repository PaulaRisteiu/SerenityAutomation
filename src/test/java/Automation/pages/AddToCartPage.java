package Automation.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class AddToCartPage extends PageObject {
    @FindBy(xpath = "//button[contains(@class, 'add-to-cart') and @data-button-action='add-to-cart']")
    WebElementFacade addToCartButton;

    public boolean isAddToCartButtonVisible() {
        return addToCartButton.isVisible();
    }

    public boolean isAddToCartButtonEnabled() {
        return addToCartButton.isEnabled();
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }
}
