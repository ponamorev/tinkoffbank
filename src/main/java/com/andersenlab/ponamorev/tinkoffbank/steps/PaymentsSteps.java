package com.andersenlab.ponamorev.tinkoffbank.steps;

import com.andersenlab.ponamorev.tinkoffbank.pages.PaymentsPage;
import io.qameta.allure.Step;

import static org.testng.Assert.assertTrue;

public class PaymentsSteps extends BaseSteps {

    PaymentsPage paymentsPage = new PaymentsPage();

    @Step("Проверяется, что кнопка <ЖКУ> доступна")
    public void housingButtonShouldBeEnabled() {
        assertTrue(paymentsPage.isHousingEnabled(),
                "Кнопка <ЖКУ> не доступна");
    }

    @Step("Нажимается кнопка <ЖКУ>")
    public void clickHousingButton() {
        paymentsPage.clickHousing();
    }

    @Override
    @Step("Ожидается, пока страница не загрузится")
    public void waitUntilPageIsLoaded() {
        paymentsPage.waitUntilPageIsLoaded(paymentsPage);
    }
}