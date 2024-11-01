package com.test.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebDriverConfig {

    private static final Logger logger = LoggerFactory.getLogger(WebDriverConfig.class);
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static synchronized void initializeDriver() {
        try {
            if (driver == null) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments(
                        "--no-sandbox",
                        "--disable-dev-shm-usage",
                        "--remote-allow-origins=*"
                );
                driver = new ChromeDriver(options);
                driver.manage().window().maximize();
                logger.info("WebDriver initialized successfully");
            }
        } catch (Exception e) {
            logger.error("Error initializing WebDriver", e);
        }
    }

    public static void quitDriver() {
        try {
            if (driver!= null) {
                driver.quit();
                driver = null;
                logger.info("WebDriver quit successfully");
            }
        } catch (Exception e) {
            logger.error("Error quitting WebDriver", e);
        }
    }
}