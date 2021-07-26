package com.itx.test.pages;

import com.itx.framework.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EmployeeListPage extends BasePage {

    public EmployeeListPage() {
    }

    @FindBy(how = How.CSS, using = "[class*='btn-primary']")
    public WebElement btnCreate;
}
