package Automation.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@DefaultUrl("https://sanovita.ro/")
public class HomePage extends PageObject {
    @FindBy(xpath = "//span[@style='color: #ffffff;' and contains(text(), 'Descoperă cele mai apreciate produse!')]")
    private WebElementFacade homeText;

    public String getHomePageText() {
        return homeText.getText();
    }

    //Teste pentru cookie
    @FindBy(id="accept-all-gdpr")
    private WebElementFacade cookieButton;

    public void setCookieChoice() {
        cookieButton.waitUntilClickable().click();
    }

    @FindBy(xpath = "//a[@class='header-btn header-user-btn']")
    private WebElementFacade authenticationLink;

    @FindBy(xpath = "//a[@class='header-btn header-user-btn']/img")
    private WebElementFacade authenticationImage;

    public void testAuthenticationLink()  {
        // fac o setare ChromeOptions pentru a dezactiva notificările
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.sanovita.ro");

        authenticationLink.waitUntilVisible();
        authenticationLink.shouldBeVisible();
        authenticationImage.shouldBeVisible();
        authenticationLink.click();

        driver.quit();
    }
}
