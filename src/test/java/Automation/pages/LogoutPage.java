package Automation.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

@DefaultUrl("https://sanovita.ro/")
public class LogoutPage extends PageObject {

    @FindBy(xpath = "//header[@class='page-header']//h1[@class='h1 page-title']/span")
    private WebElementFacade myAccountHeaderText;

    public String myAccountText() {
        return myAccountHeaderText.getText();
    }

    @FindBy(xpath = "//a[@href='//sanovita.ro/?mylogout=']")
    private WebElementFacade logoutButton;

    public void clickLogout() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 12);
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));

        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", logoutButton);
        closeBlockingElementsIfPresent();
        try {
            logoutButton.click();
        } catch (Exception e) {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", logoutButton);
        }
    }
    public void closeBlockingElementsIfPresent() {
        try {
            // inchid un pop-up dacă există
            WebElement closeButton = getDriver().findElement(By.xpath("//button[@class='close-popup']"));
            if (closeButton.isDisplayed()) {
                closeButton.click();
            }
        } catch (Exception ignored) {
            // Ignor erorile dacă elementul nu există
        }
    }
}