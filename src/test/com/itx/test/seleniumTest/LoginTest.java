package com.itx.test.seleniumTest;


import com.itx.framework.base.BrowserType;
import com.itx.framework.base.DriverContext;
import com.itx.framework.base.FrameworkInitialize;

import com.itx.framework.utilities.ExcelUtil;
import com.itx.test.pages.HomePage;
import com.itx.test.pages.LoginPage;
import jxl.read.biff.BiffException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;


public class LoginTest extends FrameworkInitialize {

    @BeforeEach
    public void Initialize() throws BiffException, IOException {
        InitializeBrowser(BrowserType.Firefox);
        DriverContext.Browser.GoToUrl("http://eaapp.somee.com/");
        ExcelUtil util = new ExcelUtil("data.xls","login");
    }

    @Test
    public void Login() throws InterruptedException {
        CurrentPage = GetInstance(HomePage.class);
        CurrentPage = CurrentPage.As(HomePage.class).clickLogin();
        Thread.sleep(2000);

        // DDT from Excel
        CurrentPage.As(LoginPage.class).Login(ExcelUtil.ReadCell("UserName", 1),
                ExcelUtil.ReadCell("Password", 1));
    }

    @AfterEach
    public void tearDown() {
        DriverContext.Driver.quit();
    }
}
