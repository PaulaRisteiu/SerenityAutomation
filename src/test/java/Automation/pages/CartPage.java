package Automation.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class CartPage extends PageObject {

    @FindBy(xpath ="//img[@src='/themes/sanovita/assets/img/cart.png']" )
    WebElementFacade imageCart;
    @FindBy(id = "cart-toogle")
    WebElementFacade cartToggle;

    @FindBy(xpath = "//a[@class='remove-from-cart' and @data-link-action='delete-from-cart']")
    WebElementFacade deleteFromCartButton;

    @FindBy(xpath = "//span[@class='no-items']")
    WebElementFacade emptyCartMessage;

    public boolean cartImageIsVisible(){
       return imageCart.isVisible();
    }

    public boolean isCartToggleVisible() {
        return cartToggle.isVisible();
    }
    public void clickCartToggle() {
        cartToggle.click();
    }

    public boolean isDeleteButtonVisible() {
        return deleteFromCartButton.isVisible();
    }

    public void clickDeleteFromCartButton() {
        deleteFromCartButton.click();
    }

    public boolean isCartEmpty() {
        return emptyCartMessage.isVisible();
    }

    public String getEmptyCartMessage() {
        return emptyCartMessage.getText();
    }

}
