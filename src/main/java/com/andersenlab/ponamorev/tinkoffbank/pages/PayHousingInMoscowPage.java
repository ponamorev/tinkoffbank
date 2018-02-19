package com.andersenlab.ponamorev.tinkoffbank.pages;

import com.andersenlab.ponamorev.tinkoffbank.BaseTest;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

public class PayHousingInMoscowPage extends BasePage {
    @FindBy(name = "provider-payerCode")
    private WebElement payerCodeField;
    @FindBy(id = "period")
    private WebElement periodField;
    @FindBy(css = ".Input__wrapper_1A9vy:last-child *[type='text']")
    private WebElement sumField;

    public boolean isPayerCodeFieldEnabled() {
        return payerCodeField.isEnabled();
    }

    public void clearPayerCodeField() {
        if (!payerCodeField.getAttribute("value").equals(""))
            payerCodeField.clear();
    }

    public boolean isPeriodFieldEnabled() {
        return periodField.isEnabled();
    }

    public void clearPeriodField() {
        if (!periodField.getAttribute("value").equals(""))
            periodField.clear();
    }

    public boolean isSumFieldEnabled() {
        return sumField.isEnabled();
    }

    public void clearSumField() {
        if (!sumField.getAttribute("value").equals(""))
            sumField.clear();
    }

    public void enterPayerCode(String code) {
        payerCodeField.sendKeys(code);
    }

    public void enterPeriod(String period) {
        periodField.sendKeys(period);
    }

    public void enterSum(String sum) {
        sumField.sendKeys(sum);
    }

    public void refreshPage() {
        BaseTest.driver.navigate().refresh();
    }
}