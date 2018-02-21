package com.andersenlab.ponamorev.tinkoffbank.pages;

import com.andersenlab.ponamorev.tinkoffbank.BaseTest;
import com.andersenlab.ponamorev.tinkoffbank.data.AccordingErrorMessageByNumber;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PayHousingInMoscowPage extends BasePage {
    /*private String errorMessageCss = "%s *[data-qa-file='UIFormRowError']";*/
    private String messageAboutMinValue = "Минимальная сумма перевода - 10 \u20BD";
    private String messageAboutMaxValue = "Максимальная сумма перевода - 15 000 \u20BD";
    /*private WebElement errorMessage;*/

    @FindBy(name = "provider-payerCode")
    private WebElement payerCodeField;
    @FindBy(id = "period")
    private WebElement periodField;
    @FindBy(css = ".Input__wrapper_1A9vy:last-child *[type='text']")
    private WebElement sumField;
    @FindBy(css = ".ui-button.ui-button_failure")
    private WebElement submitButton;
    @FindBy(css = ".ui-form__row_text.ui-form__row_default-error-view-visible *[data-qa-file='UIFormRowError']")
    private WebElement payerCodeErrorMessage;
    @FindBy(css = ".ui-form__row_date *[data-qa-file='UIFormRowError']")
    private WebElement periodErrorMessage;
    @FindBy(css = ".ui-form__row_combination *[data-qa-file='UIFormRowError']")
    private WebElement sumErrorMessage;

    public boolean isPayerCodeFieldEnabled() {
        return payerCodeField.isEnabled();
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
        if (!sumField.getAttribute("value").equals(""))
            sumField.clear();
    }

    public void enterPayerCode(String code) {
        PageFactory.initElements(BaseTest.driver, PayHousingInMoscowPage.class);
        new WebDriverWait(BaseTest.driver, 5).until(ExpectedConditions.visibilityOf(payerCodeField));
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
        return getErrorMessageByField(message).isDisplayed();
    }

    public boolean isErrorMessageAboutMinValueCorrect() {
        PageFactory.initElements(BaseTest.driver, PayHousingInMoscowPage.class);
        return sumErrorMessage.getText().equals(messageAboutMinValue);
    }

    public boolean isErrorMessageAboutMaxValueCorrect() {
        PageFactory.initElements(BaseTest.driver, PayHousingInMoscowPage.class);
        /*new WebDriverWait(BaseTest.driver, 5).until(ExpectedConditions.visibilityOf())*/
        return sumErrorMessage.getText().equals(messageAboutMaxValue);
    }

    public void clickSubmit() {
        new WebDriverWait(BaseTest.driver, 5).until(ExpectedConditions.visibilityOf(submitButton));
        submitButton.click();
    }
}