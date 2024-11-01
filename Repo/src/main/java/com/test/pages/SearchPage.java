package com.test.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;



public class SearchPage extends BasePage {

    private static final By SEARCH_TEXTBOX_XPATH = By.xpath("//input[@id='search_query_top']");
    private static final By SEARCH_BUTTON_XPATH = By.xpath("//button[@name='submit_search']");
    private static final By SEARCH_HEADER_XPATH = By.xpath("//h1[@class='page-heading  product-listing']//span[@class='lighter']");
    private static final By PRODUCT_BUTTON_XPATH = By.xpath("//a[@class='product_img_link' and @title='Printed Summer Dress']");



    public SearchPage(WebDriver driver) {
        super(driver);
    }


    public void search(String value){

        set(SEARCH_TEXTBOX_XPATH, value);
        waitUtils.waitForElementClickable(SEARCH_BUTTON_XPATH).click();
    }


    public boolean elementContainText(String expected){
        return getText(SEARCH_HEADER_XPATH).contains(expected);
    }


    public void clickElement(String buttonName){
        switch (buttonName) {
            case "FirstProduct":
                click(PRODUCT_BUTTON_XPATH);
                break;
            case "AddToCart":
                //click("xpath for cart button");
                break;
            default:
                break;
        }

    }


    public void checkVisibility(){
        waitUtils.waitForElementVisible(SEARCH_HEADER_XPATH);
    }


    public void selectElement(String size){
        advancedSizeSelection(size);
    }

    public void advancedSizeSelection(String size) {
        String overlaySelectorCSS = "div.selector[id='uniform-group_1'] span";

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // **Attempt 1: Wait for Element Presence**
            try {
                WebElement overlay = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(overlaySelectorCSS)));
                overlay.click();
            } catch (Exception e) {
                System.out.println("Presence-based click failed: " + e.getMessage());
            }

            // **Attempt 2: Wait for Element Visibility & Click**
            try {
                WebElement overlayVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(overlaySelectorCSS)));
                overlayVisible.click();
            } catch (Exception e) {
                System.out.println("Visibility-based click failed: " + e.getMessage());
            }

            // **Alternative Selector (if above fails)**
            String alternativeSelector = "#uniform-group_1 > span"; // Simplified selector
            try {
                WebElement overlayAlternative = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(alternativeSelector)));
                overlayAlternative.click();
            } catch (Exception e) {
                System.out.println("Alternative selector click failed: " + e.getMessage());
            }

            // Proceed with selecting from the dropdown (if clicking worked)
            try {
                Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("group_1"))));
                select.selectByVisibleText("M"); // Adjust the selection as needed
            } catch (Exception e) {
                System.out.println("Error handling dropdown selection: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error handling size selection: " + e.getMessage());
        }
    }

    public void scrollPage(int times) {
        scrollUtils.scrollByViewport(times);
    }

}
