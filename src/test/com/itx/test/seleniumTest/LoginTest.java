package com.itx.test.seleniumTest;

import com.itx.test.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTest {

    private WebDriver _driver = null;

    @BeforeEach
    public void Initialize() {
        System.setProperty("webdriver.gecko.driver", "/home/dario/Code/Automation/itx-automation-framework-with-selenium/UdemyCourse_Design/UdemyCourse/src/test/geckodriver");
        _driver = new FirefoxDriver();
        _driver.navigate().to("http://executeautomation.com/demosite/Login.html");
    }

    @Test
    public void Login() {
        LoginPage page = new LoginPage(_driver);
        page.Login("admin", "admin");
    }
}
