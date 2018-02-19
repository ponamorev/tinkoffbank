package com.andersenlab.ponamorev.tinkoffbank.steps;

import com.andersenlab.ponamorev.tinkoffbank.pages.PayHousingInMoscowPage;
import net.thucydides.core.annotations.Step;

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
}