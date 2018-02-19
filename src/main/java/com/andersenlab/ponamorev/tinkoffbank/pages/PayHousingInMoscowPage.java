package com.andersenlab.ponamorev.tinkoffbank.pages;

import com.andersenlab.ponamorev.tinkoffbank.BaseTest;
import com.andersenlab.ponamorev.tinkoffbank.data.AccordingErrorMessageByNumber;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PayHousingInMoscowPage extends BasePage {
    private String errorMessageXpath = "(//*[@data-qa-file='UIFormRowError'])[%s]";
    private String messageAboutMinValue = "Минимальная сумма перевода - 10 \u20BD";
    private String messageAboutMaxValue = "Максимальная сумма перевода - 15 000 \u20BD";
    private WebElement errorMessage;

    @FindBy(name = "provider-payerCode")
    private WebElement payerCodeField;
    @FindBy(id = "period")
    private WebElement periodField;
    @FindBy(css = ".Input__wrapper_1A9vy:last-child *[type='text']")
    private WebElement sumField;
    @FindBy(css = ".ui-button.ui-button_failure")
    private WebElement submitButton;

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
        new WebDriverWait(BaseTest.driver, 5).until(ExpectedConditions.visibilityOf(sumField));
        if (!sumField.getAttribute("value").equals(""))
            sumField.clear();
    }

    public void enterPayerCode(String code) {
        initElements();
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

    private WebElement getErrorMessageByField(AccordingErrorMessageByNumber number) {
        errorMessage = BaseTest.driver.findElement(By.xpath(String.format(
                errorMessageXpath, number.getNumber())));
        new WebDriverWait(BaseTest.driver, 5).until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage;
    }

    public boolean isErrorMessageCorrect(AccordingErrorMessageByNumber number) {
        return getErrorMessageByField(number).getText().equals(number.getInvalidValueMessage());
    }

    public boolean isErrorMessageAboutEmptyFieldCorrect(AccordingErrorMessageByNumber number) {
        return getErrorMessageByField(number).getText().equals(number.getEmptyFieldMessage());
    }

    public boolean isErrorMessageDisplayed(AccordingErrorMessageByNumber number) {
        return getErrorMessageByField(number).isDisplayed();
    }

    public boolean isErrorMessageAboutMinValueCorrect(AccordingErrorMessageByNumber number) {
        return getErrorMessageByField(number).getText().equals(messageAboutMinValue);
    }

    public boolean isErrorMessageAboutMaxValueCorrect(AccordingErrorMessageByNumber number) {
        return getErrorMessageByField(number).getText().equals(messageAboutMaxValue);
    }

    public void clickSubmit() {
        submitButton.click();
    }
}