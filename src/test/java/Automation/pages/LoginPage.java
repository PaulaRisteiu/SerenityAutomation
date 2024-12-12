package Automation.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class LoginPage extends PageObject {

    @FindBy(xpath ="//input[@type='email' and @name='email']")
    private WebElementFacade emailInput;

    public void testEmailInput(String email_text) {
        emailInput.shouldBeVisible();
        emailInput.shouldBeEnabled();
        emailInput.clear();
        emailInput.type(email_text);
    }

    @FindBy(xpath = "//input[@type='password' and @name='password']")
    private WebElementFacade passwordInput;
    public void testPasswordInput(String testPassword){
        passwordInput.type(testPassword);
        String enteredPassword = passwordInput.getValue(); //preia parola introdusa si o compara
        assert enteredPassword.equals(testPassword); //daca nu am aceleasi parole introduse o sa am o eroare de asertiune
    }

    @FindBy(xpath = "//button[@id='submit-login']")
    private WebElementFacade loginButton;

    public void testloginButton() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 9); //seteaza perioada de asteptare pt login button
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)); //element visibil si gata de click
        loginButton.click();
    }
    @FindBy(xpath = "//header[@class='page-header']/h1[@class='h1 page-title']/span")
    private WebElementFacade loginTitleText;

    public String getLoginText () {
        return loginTitleText.getText(); }
}

