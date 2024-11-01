package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage {

    private static final By EMAIL_TEXTBOX_XPATH = By.xpath("//input[@id='email']");
    private static final By PASSWORD_TEXTBOX_XPATH = By.xpath("//input[@id='passwd']");
    private static final By SUBMIT_BUTTON_XPATH = By.xpath("//button[@id='SubmitLogin']");
    private static final By WELCOME_INFO_XPATH = By.xpath("//p[@class='info-account']");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickElement(){
        click(SUBMIT_BUTTON_XPATH);
    }

    public boolean checkElementVisibility(){
        return isVisible(WELCOME_INFO_XPATH);
    }

    public void setElementValue(String elementName, String value){

        switch (elementName){
            case "Email":
                set(EMAIL_TEXTBOX_XPATH, value);
                break;
            case "Password":
                set(PASSWORD_TEXTBOX_XPATH, value);
                break;
        }

    }

}
