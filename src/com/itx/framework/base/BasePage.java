package com.itx.framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage extends Base {

    public BasePage() {
        PageFactory.initElements(DriverContext.Driver, this);
    }
}
