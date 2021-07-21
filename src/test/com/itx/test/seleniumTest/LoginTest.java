package com.itx.test.seleniumTest;


import com.itx.framework.base.Base;
import com.itx.framework.base.DriverContext;
import com.itx.test.pages.HomePage;
import com.itx.test.pages.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.firefox.FirefoxDriver;


public class LoginTest extends Base {

    @BeforeEach
    public void Initialize() {
        System.setProperty("webdriver.gecko.driver", "/home/dario/Code/Automation/itx-automation-framework-with-selenium/UdemyCourse_Design/UdemyCourse/src/test/geckodriver");
        DriverContext.Driver = new FirefoxDriver();
        DriverContext.Driver.navigate().to("http://eaapp.somee.com/");
    }

    @Test
    public void Login() throws InterruptedException {
        // HomePage homePage = new HomePage();
        CurrentPage = homePage.clickLogin();
        Thread.sleep(2000);
        ((LoginPage) CurrentPage).Login("admin", "password");
    }

    @AfterEach
    public void tearDown() {
        DriverContext.Driver.quit();
    }
}
