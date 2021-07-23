package com.itx.framework.base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FrameworkInitialize extends Base {

    public void InitializeBrowser(BrowserType browserType) {
        switch (browserType) {
            case Chrome: {
                DriverContext.Driver = new ChromeDriver();
                break;
            }
            case Firefox: {
                System.setProperty("webdriver.gecko.driver", "/home/dario/Code/Automation/itx-automation-framework-with-selenium/UdemyCourse_Design/UdemyCourse/src/test/geckodriver");
                DriverContext.Driver = new FirefoxDriver();
                break;
            }
            case IE: {
                break;
            }
        }
    }
}
