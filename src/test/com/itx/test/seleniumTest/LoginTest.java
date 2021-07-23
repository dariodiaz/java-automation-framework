package com.itx.test.seleniumTest;


import com.itx.framework.base.BrowserType;
import com.itx.framework.base.DriverContext;
import com.itx.framework.base.FrameworkInitialize;

import com.itx.test.pages.HomePage;
import com.itx.test.pages.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class LoginTest extends FrameworkInitialize {

    @BeforeEach
    public void Initialize() {
        InitializeBrowser(BrowserType.Firefox);
    }

    @Test
    public void Login() throws InterruptedException {
        CurrentPage = GetInstance(HomePage.class);
        CurrentPage = CurrentPage.As(HomePage.class).clickLogin();
        Thread.sleep(2000);
        ((LoginPage) CurrentPage).Login("admin", "password");
    }

    @AfterEach
    public void tearDown() {
        DriverContext.Driver.quit();
    }
}
