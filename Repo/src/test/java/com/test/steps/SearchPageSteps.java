package com.test.steps;

import com.test.config.WebDriverConfig;
import com.test.pages.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class SearchPageSteps {

    SearchPage searchPage = new SearchPage(WebDriverConfig.getDriver());


    @Given("^on the Search page (.*) is searched")
    public void search_page_element_search_action(String value) {
        searchPage.search(value);
    }

    @Then("^on the Search page SearchHeader title should contain (.*)")
    public void search_page_element_should_be(String expectedValue) {
        Assert.assertTrue("Element does not contain expected text", searchPage.elementContainText(expectedValue));
    }

    @And("^on the Search page (.*) is clicked")
    public void search_page_click_action(String buttonName) {
        searchPage.clickElement(buttonName);
    }

    @And("^on the Search page dropdown (.*) is selected")
    public void search_page_select_action(String size) {
        searchPage.selectElement(size);
    }

    @And("^on the Search page SuccessMessage is visible")
    public void search_page_check_visible_action() {

        searchPage.checkVisibility();
    }


    @Then("the user scrolls {int} times")
    public void theUserScrollsTimes(int scrollCount) {
        searchPage.scrollPage(scrollCount);
    }


}
