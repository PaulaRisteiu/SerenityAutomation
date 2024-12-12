package Automation.steps.serenity;

import Automation.pages.AddToCartPage;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.JavascriptExecutor;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.junit.Assert.assertTrue;

public class AddToCartSteps {
    private AddToCartPage addToCartPage;

    public void scrollByOffset(int offset) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("window.scrollBy(0, arguments[0]);", offset);
    }

    @Step
    public void verifyAddToCartButtonIsVisible() {
        assertTrue("Butonul 'Adaugă în coș' nu este vizibil!", addToCartPage.isAddToCartButtonVisible());
    }

    @Step
    public void addToCartButtonIsEnabled() {
        assertTrue("Butonul 'Adaugă în coș' nu este activ!", addToCartPage.isAddToCartButtonEnabled());
    }

    @Step
    public void clickAddToCartButton() {
        addToCartPage.clickAddToCartButton();
    }
}
