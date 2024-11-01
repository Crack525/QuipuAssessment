package com.test.hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.test.config.WebDriverConfig;

public class TestHooks {
    private static final Logger logger = LoggerFactory.getLogger(TestHooks.class);

    @Before
    public void setup() {
        WebDriverConfig.initializeDriver();
        logger.info("WebDriver initialized successfully");
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        if (WebDriverConfig.getDriver() instanceof TakesScreenshot) {
            byte[] screenshot = ((TakesScreenshot) WebDriverConfig.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        WebDriverConfig.quitDriver();
        logger.info("WebDriver closed successfully");
    }
}