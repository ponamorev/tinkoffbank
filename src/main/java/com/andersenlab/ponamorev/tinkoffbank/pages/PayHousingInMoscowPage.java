package com.andersenlab.ponamorev.tinkoffbank.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

public class PayHousingInMoscowPage {
    @FindBy(name = "provider-payerCode")
    private WebElement payerCodeField;
    @FindBy(id = "period")
    private WebElement periodField;
    @FindBy(css = ".Input__wrapper_1A9vy:last-child")
    private WebElement sumField;

    public boolean isPayerCodeFieldEnabled() {
        return payerCodeField.isEnabled();
    }

    public void clearPayerCodeField() {
        payerCodeField.clear();
    }

    public void clickPayerCodeField() {
        payerCodeField.click();
    }

    public boolean isPeriodFieldEnabled() {
        return periodField.isEnabled();
    }

    public void clearPeriodField() {
        periodField.clear();
    }

    public void clickPeriodField() {
        periodField.click();
    }

    public boolean isSumFieldEnabled() {
        return sumField.isEnabled();
    }

    public void clearSumField() {
        sumField.clear();
    }

    public void clickSumField() {
        sumField.click();
    }
}