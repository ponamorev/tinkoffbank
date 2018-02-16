package com.andersenlab.ponamorev.tinkoffbank.steps;

import com.andersenlab.ponamorev.tinkoffbank.pages.PaymentsPage;
import net.thucydides.core.annotations.Step;

import static org.junit.Assert.assertTrue;

public class PaymentsSteps extends BaseSteps {

    PaymentsPage paymentsPage;

    @Step("Проверяется, что кнопка <ЖКУ> доступна")
    public void housingButtonShouldBeEnabled() {
        assertTrue("Кнопка <ЖКУ> не доступна",
                paymentsPage.isHousingEnabled());
    }

    @Step("Нажимается кнопка <ЖКУ>")
    public void clickHousingButton() {
        paymentsPage.clickHousing();
    }
}