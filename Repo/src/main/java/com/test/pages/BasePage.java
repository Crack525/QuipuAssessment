package com.test.pages;

import com.test.utils.ScrollUtils;
import com.test.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected final WebDriver driver;
    protected final WaitUtils waitUtils;
    protected final ScrollUtils scrollUtils;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
        this.scrollUtils = new ScrollUtils(driver);
        PageFactory.initElements(driver, this);
    }




    public Boolean isVisible(By elementBy) {
        return waitUtils.waitForElementVisible(elementBy).isDisplayed();
    }

    public String getText(By elementBy) {
        return waitUtils.waitForElementVisible(elementBy).getText();
    }

    public void set(By elementBy, String stringToSet) {
        waitUtils.waitForElementVisible(elementBy).sendKeys(stringToSet);
    }

    public void click(By elementBy) {

        waitUtils.waitForElementVisible(elementBy);
        // Needed to add this delay to avoid ElementClickInterceptedException
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        waitUtils.waitForElementClickable(elementBy).click();
    }

}
