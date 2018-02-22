package com.andersenlab.ponamorev.tinkoffbank.pages;

import com.andersenlab.ponamorev.tinkoffbank.BaseTest;
import com.andersenlab.ponamorev.tinkoffbank.data.AccordingErrorMessageByNumber;
import com.andersenlab.ponamorev.tinkoffbank.data.SavedObject;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;

public class PayHousingInMoscowPage extends BasePage implements Serializable {
    private String messageAboutMinValue = "Минимальная сумма перевода — 10 \u20BD";
    private String messageAboutMaxValue = "Максимальная сумма перевода — 15 000 \u20BD";
    private final String defaultUrl = "https://www.tinkoff.ru/zhku-moskva/oplata/?tab=pay";

    @FindBy(name = "provider-payerCode")
    private WebElement payerCodeField;
    @FindBy(id = "period")
    private WebElement periodField;
    @FindBy(css = "*[class='Input__value_2Kx90'] *[type='text']")
    private WebElement sumField;
    @FindBy(css = ".ui-button.ui-button_failure")
    private WebElement submitButton;
    @FindBy(css = ".ui-form__row_text.ui-form__row_default-error-view-visible *[data-qa-file='UIFormRowError']")
    private WebElement payerCodeErrorMessage;
    @FindBy(css = ".ui-form__row_date *[data-qa-file='UIFormRowError']")
    private WebElement periodErrorMessage;
    @FindBy(css = ".ui-form__row_combination *[data-qa-file='UIFormRowError']")
    private WebElement sumErrorMessage;
    @FindBy(css = "#mainMenu .HeaderMenuItem__item_2v2UK *[href='/payments/']")
    private WebElement paymentsButton;

    public boolean isPayerCodeFieldEnabled() {
        if (isPresent(payerCodeField)){
            new WebDriverWait(BaseTest.driver, 5).until(ExpectedConditions.elementToBeClickable(payerCodeField));
            return payerCodeField.isEnabled();
        }
        return false;
    }

    public void clearPayerCodeField() {
        if (!payerCodeField.getAttribute("value").equals(""))
            payerCodeField.clear();
    }

    public void clickPayerCodeField() {
        payerCodeField.click();
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
        if (isPresent(sumField) && !sumField.getAttribute("value").equals(""))
            sumField.clear();
    }

    public void enterPayerCode(String code) {
        if (isPresent(payerCodeField))
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

    private WebElement getErrorMessageByField(AccordingErrorMessageByNumber message) {
        switch (message.toString()) {
            case "Код плательщика ЖКУ в Москве":
                return payerCodeErrorMessage;
            case "Период оплаты":
                return periodErrorMessage;
            case "Сумма платежа":
                return sumErrorMessage;
        }
        return null;
    }

    public boolean isErrorMessageCorrect(AccordingErrorMessageByNumber message) {
        return getErrorMessageByField(message).getText().equals(message.getInvalidValueMessage());
    }

    public boolean isErrorMessageAboutEmptyFieldCorrect(AccordingErrorMessageByNumber message) {
        return getErrorMessageByField(message).getText().equals(message.getEmptyFieldMessage());
    }

    public boolean isErrorMessageDisplayed(AccordingErrorMessageByNumber message) {
        return isPresent(getErrorMessageByField(message)) && getErrorMessageByField(message).isDisplayed();
    }

    public boolean isErrorMessageNotDisplayed(AccordingErrorMessageByNumber message) {
        try {
            return !getErrorMessageByField(message).isDisplayed();
        } catch (NoSuchElementException e) {
            LOGGER.error("There is nothing message here.");
            return true;
        }
    }

    public boolean isErrorMessageAboutMinValueCorrect() {
        return isPresent(sumErrorMessage) && sumErrorMessage.getText().equals(messageAboutMinValue);
    }

    public boolean isErrorMessageAboutMaxValueCorrect() {
        if (isPresent(sumErrorMessage)) {
            PageFactory.initElements(BaseTest.driver, this);
            return sumErrorMessage.getText().equals(messageAboutMaxValue);
        }
        return false;
    }

    public void clickSubmit() {
        if (isPresent(submitButton))
            submitButton.click();
    }

    @Override
    public void open() {
        BaseTest.driver.get(defaultUrl);
    }

    @Override
    public boolean isPaymentsButtonEnabled() {
        return paymentsButton.isEnabled();
    }

    @Override
    public void clickPaymentsButton() {
        paymentsButton.click();
    }

    public void savePageInstance() {
        SavedObject.setHeader(BaseTest.driver.getCurrentUrl());
    }

    public String getSavedPageInstance() {
        if (isPresent(paymentsButton))
            return SavedObject.getHeader();
        return "";
    }
}