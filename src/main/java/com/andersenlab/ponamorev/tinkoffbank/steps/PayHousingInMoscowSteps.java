package com.andersenlab.ponamorev.tinkoffbank.steps;

import com.andersenlab.ponamorev.tinkoffbank.data.AccordingErrorMessageByNumber;
import com.andersenlab.ponamorev.tinkoffbank.pages.PayHousingInMoscowPage;
import io.qameta.allure.Step;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class PayHousingInMoscowSteps extends BaseSteps {

    PayHousingInMoscowPage payHousingInMoscowPage = new PayHousingInMoscowPage();

    @Step("Проверяется, что поле для ввода кода плательщика доступно")
    public void payerCodeFieldShouldBeEnabled() {
        assertTrue(payHousingInMoscowPage.isPayerCodeFieldEnabled(),
                "Поле для ввода кода плательщика недоступно");
    }

    @Step("Очищается поле для ввода кода плательщика")
    public void clearPayerCodeField() {
        payHousingInMoscowPage.clearPayerCodeField();
    }

    @Step("Нажимается на поле для ввода кода плательщика")
    public void clickPayerCodeField() {
        payHousingInMoscowPage.clickPayerCodeField();
    }

    @Step("Проверяется, что поле для ввода периода оплаты доступно")
    public void periodFieldShouldBeEnabled() {
        assertTrue(payHousingInMoscowPage.isPeriodFieldEnabled(),
                "Поле для ввода периода оплаты недоступно");
    }

    @Step("Очищается поле для ввода кода плательщика")
    public void clearPeriodField() {
        payHousingInMoscowPage.clearPeriodField();
    }

    @Step("Проверяется, что поле для ввода суммы платежа доступно")
    public void sumFieldShouldBeEnabled() {
        assertTrue(payHousingInMoscowPage.isSumFieldEnabled(),
                "Поле для ввода суммы платежа недоступно");
    }

    @Step("Очищается поле для ввода суммы платежа")
    public void clearSumField() {
        payHousingInMoscowPage.clearSumField();
    }

    @Step("Вводится код плательщика")
    public void enterPayerCode(String code) {
        payHousingInMoscowPage.enterPayerCode(code);
    }

    @Step("Вводится период платежа")
    public void enterPeriod(String period) {
        payHousingInMoscowPage.enterPeriod(period);
    }

    @Step("Вводится сумма платежа")
    public void enterSum(String sum) {
        payHousingInMoscowPage.enterSum(sum);
    }

    @Step("Обновление страницы")
    public void refresh() {
        payHousingInMoscowPage.refreshPage();
    }

    @Step("Нажимается кнопка <Оплатить ЖКУ в Москве>")
    public void clickSubmitButton() {
        payHousingInMoscowPage.clickSubmit();
    }

    @Step("Проверяется, что под полем <{0}> отображается сообщение об ошибке")
    public void errorMessageShouldBeDisplayed(AccordingErrorMessageByNumber message) {
        assertTrue(payHousingInMoscowPage.isErrorMessageDisplayed(message),
                "Сообщение об ошибке под полем <{0}> не отображается");
    }

    @Step("Проверяется, что под полем <{0}> не отображается сообщение об ошибке")
    public void errorMessageShouldNotBeDisplayed(AccordingErrorMessageByNumber message) {
        assertFalse(payHousingInMoscowPage.isErrorMessageDisplayed(message),
                "Сообщение об ошибке под полем <{0}> отображается");
    }

    @Step("Проверяется, что под полем <{0}> отображается сообщение о некорректном вводе данных")
    public void errorMessageAboutInvalidDataShouldBeCorrect(AccordingErrorMessageByNumber message) {
        assertTrue(payHousingInMoscowPage.isErrorMessageCorrect(message),
                "Сообщение о некорректном вводе данных под полем <{0}> не отображается");
    }

    @Step("Проверяется, что под полем <{0}> отображается сообщение о пустом обязательном поле")
    public void errorMessageAboutEmptyFieldShouldBeCorrect(AccordingErrorMessageByNumber message) {
        assertTrue(payHousingInMoscowPage.isErrorMessageAboutEmptyFieldCorrect(message),
                "Сообщение о пустом обязательном поле под полем <{0}> не отображается");
    }

    @Step("Проверяется, что под полем <Сумма платежа> отображается сообщение о минимальной сумме перевода")
    public void errorMessageAboutMinValueShouldBeCorrect() {
        waitUntilPageIsLoaded();
        assertTrue(payHousingInMoscowPage.isErrorMessageAboutMinValueCorrect(),
                "Сообщение о минимальной сумме перевода не отображается");
    }

    @Step("Проверяется, что под полем <Сумма платежа> отображается сообщение о максимальной сумме перевода")
    public void errorMessageAboutMaxValueShouldBeCorrect() {
        waitUntilPageIsLoaded();
        assertTrue(payHousingInMoscowPage.isErrorMessageAboutMaxValueCorrect(),
                "Сообщение о максимальной сумме перевода не отображается");
    }

    @Override
    @Step("Ожидается, пока страница не загрузится")
    public void waitUntilPageIsLoaded() {
        payHousingInMoscowPage.waitUntilPageIsLoaded(payHousingInMoscowPage);
    }

    @Override
    @Step("Открывается начальная страница для выполнения валидации и верификации обязательных полей")
    public void openBasePage() {
        payHousingInMoscowPage.open();
    }

    @Step("Нажимается кнопка <Платежи>")
    public void clickPaymentsButton() {
        payHousingInMoscowPage.clickPaymentsButton();
    }

    @Step("Проверяется, что кнопка <Платежи> доступна")
    public void paymentsButtonShouldBeEnabled() {
        assertTrue(payHousingInMoscowPage.isPaymentsButtonEnabled(),
                "Кнопка <Платежи> не доступна");
    }

    public PayHousingInMoscowPage getPayHousingInMoscowPage() {
        return payHousingInMoscowPage;
    }
}