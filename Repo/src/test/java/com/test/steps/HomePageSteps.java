package com.test.steps;

import com.test.config.WebDriverConfig;
import com.test.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class HomePageSteps {

    HomePage homePage = new HomePage(WebDriverConfig.getDriver());

    @Given("^on the Home page navigate to (.*)")
    public void home_navigateTo(String url){
        homePage.navigate(url);
    }

    @And("^on the Home page Sign In button is clicked")
    public void home_page_click_action() {
        homePage.clickElement();
    }
}
