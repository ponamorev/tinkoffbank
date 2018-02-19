package com.andersenlab.ponamorev.tinkoffbank.steps;

import com.andersenlab.ponamorev.tinkoffbank.pages.HousingInMoscowPage;
import io.qameta.allure.Step;

public class HousingInMoscowSteps extends BaseSteps {

    HousingInMoscowPage housingInMoscowPage = new HousingInMoscowPage();

    @Step("Нажимается вкладка <Оплатить ЖКУ в Москве>")
    public void clickPayHousingInMoscow() {
        housingInMoscowPage.clickPayHousingInMoscowTab();
    }
}