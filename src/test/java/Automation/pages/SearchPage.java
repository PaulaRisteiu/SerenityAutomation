package Automation.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class SearchPage extends PageObject {

    @FindBy(xpath = "//input[@name='s' and @placeholder='Cauta produse, programe de dieta, articole, retete']")
    WebElementFacade searchText;

    public void testSearchText(String searchInput) {
      searchText.shouldBeVisible();
      searchText.shouldBeEnabled();
      searchText.clear();
      searchText.type(searchInput);

    }

    public String getSearchFieldPlaceholder() {
        return searchText.getAttribute("placeholder");
    }

    public String getSearchFieldValue() {
        return searchText.getValue();
    }

    public void pressEnterInSearchField() {
        searchText.sendKeys(Keys.RETURN); // Sau Keys.ENTER
    }

    @FindBy(xpath = "//span[text()='Rezultatele cautarii']")
    WebElementFacade resultsText;
    public boolean isSearchResultsTextVisible() {
        return resultsText.isVisible();
    }
}
