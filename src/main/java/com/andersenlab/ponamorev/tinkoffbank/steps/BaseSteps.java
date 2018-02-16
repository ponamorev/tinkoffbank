package com.andersenlab.ponamorev.tinkoffbank.steps;

import com.andersenlab.ponamorev.tinkoffbank.pages.BasePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.junit.Assert.assertTrue;

public class BaseSteps extends ScenarioSteps {

    BasePage basePage;

    @Step("Открывается стартовая страница")
    public void openBasePage() {
        basePage.open();
    }

    @Step("Ожидается, пока страница не загрузится")
    public void waitUntilPageIsLoaded() {
        basePage.waitUntilPageIsLoaded();
    }

    @Step("Проверяется, что кнопка <Платежи> доступна")
    public void paymentsButtonShouldBeEnabled() {
        assertTrue("Кнопка <Платежи> не доступна",
                basePage.isPaymentsButtonEnabled());
    }

    @Step("Нажимается кнопка <Платежи>")
    public void clickPaymentsButton() {
        basePage.clickPaymentsButton();
    }
}