package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    private static final By SIGN_IN_BUTTON_XPATH = By.xpath("//a[contains(@class, 'login') and contains(text(), 'Sign in')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void navigate(String url) {
        driver.get(url);
    }

    public void clickElement(){
        click(SIGN_IN_BUTTON_XPATH);
    }
}
