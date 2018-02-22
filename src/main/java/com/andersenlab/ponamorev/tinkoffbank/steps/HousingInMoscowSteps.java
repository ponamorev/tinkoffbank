package com.andersenlab.ponamorev.tinkoffbank.steps;

import com.andersenlab.ponamorev.tinkoffbank.pages.HousingInMoscowPage;
import io.qameta.allure.Step;

import static org.testng.Assert.assertTrue;

public class HousingInMoscowSteps extends BaseSteps {

    HousingInMoscowPage housingInMoscowPage = new HousingInMoscowPage();

    @Step("Нажимается вкладка <Оплатить ЖКУ в Москве>")
    public void clickPayHousingInMoscow() {
        housingInMoscowPage.clickPayHousingInMoscowTab();
    }

    @Override
    @Step("Ожидается, пока страница не загрузится")
    public void waitUntilPageIsLoaded() {
        housingInMoscowPage.waitUntilPageIsLoaded(housingInMoscowPage);
    }

    @Step("Проверяется, что вкладка <Оплатить ЖКУ в Москве> доступна")
    public void payHousingInMoscowTabShouldBeEnabled() {
        assertTrue(housingInMoscowPage.isPayHousingInMoscowTabEnabled(),
                "Вкладка <Оплатить ЖКУ в Москве> не доступна");
    }
}