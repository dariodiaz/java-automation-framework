package com.itx.framework.base;

import org.openqa.selenium.WebDriver;

public class Browser {

    private WebDriver _driver;
    public BrowserType Type;

    public void GoToUrl(String url) {
        _driver.get(url);
    }

    public void Maximize() {
        _driver.manage().window().maximize();
    }

}

