package Automation.steps.serenity;

import Automation.pages.SearchPage;
import net.thucydides.core.annotations.Step;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SearchSteps {

    private SearchPage searchPage;

    @Step
    public void verifySearchFieldPlaceholder(String expectedPlaceholder) {
        assertEquals("Placeholder-ul nu este corect!", expectedPlaceholder, searchPage.getSearchFieldPlaceholder());
    }
    @Step
    public void enterSearchText(String searchInput) {
        searchPage.testSearchText(searchInput);
    }

    @Step
    public void verifySearchFieldText(String expectedText) {
        assertEquals("Textul din câmpul de căutare nu este corect!", expectedText, searchPage.getSearchFieldValue());
    }
    @Step
    public void pressEnterInSearchField() {
        searchPage.pressEnterInSearchField();
    }

    @Step
    public void verifySearchResultsAreVisible() {
        assertTrue("Textul 'Rezultatele cautarii' nu a fost găsit pe pagină!", searchPage.isSearchResultsTextVisible());
    }
}
