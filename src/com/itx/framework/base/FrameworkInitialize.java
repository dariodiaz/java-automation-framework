package com.itx.framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FrameworkInitialize extends Base {

    public void InitializeBrowser(BrowserType browserType) {

        WebDriver driver = null;
        switch (browserType) {
            case Chrome: {
                driver = new ChromeDriver();
                break;
            }
            case Firefox: {
                System.setProperty("webdriver.gecko.driver", "/home/dario/Code/Automation/itx-automation-framework-with-selenium/UdemyCourse_Design/UdemyCourse/src/test/geckodriver");
                driver = new FirefoxDriver();
                break;
            }
            case IE: {
                break;
            }
        }

        // Set the Driver
        DriverContext.setDriver(driver);
        // Set the Browser
        DriverContext.Browser = new Browser(driver);
    }
}
