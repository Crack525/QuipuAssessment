package com.test.steps;

import com.test.config.WebDriverConfig;
import com.test.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginPageSteps {

    LoginPage loginPage = new LoginPage(WebDriverConfig.getDriver());


    @When("^on the Login page (.*) is set for the (.*) value")
    public void login_page_set_action(String value, String elementName) {
        loginPage.setElementValue(elementName,value);
    }

    @And("^on the Login page Submit button is clicked")
    public void login_page_click_action() {
        loginPage.clickElement();
    }

    @Then("^on the Dashboard page Welcome message is visible")
    public void page_element_check_visibility() {
        Assert.assertTrue("Element is not visible",loginPage.checkElementVisibility());
    }

}