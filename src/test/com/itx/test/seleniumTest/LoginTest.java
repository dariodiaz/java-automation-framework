package com.itx.test.seleniumTest;


import com.itx.framework.base.BrowserType;
import com.itx.framework.base.DriverContext;
import com.itx.framework.base.FrameworkInitialize;

import com.itx.framework.utilities.DatabaseUtil;
import com.itx.framework.utilities.ExcelUtil;
import com.itx.framework.utilities.LogUtil;
import com.itx.test.pages.HomePage;
import com.itx.test.pages.LoginPage;
import jxl.read.biff.BiffException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.Connection;


public class LoginTest extends FrameworkInitialize {

    @BeforeEach
    public void Initialize() throws BiffException, IOException {

        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=mastertest;user=sa;password=abc123";
        Connection connection = DatabaseUtil.Open(connectionUrl);
        DatabaseUtil.ExecuteQuery("SELECT * FROM Employees", connection);

        LogUtil logUtil = new LogUtil();
        logUtil.CreateLogFile();
        logUtil.Write("Framework Initialize");

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
