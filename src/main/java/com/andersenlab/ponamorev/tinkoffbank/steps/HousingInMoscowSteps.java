package com.andersenlab.ponamorev.tinkoffbank.steps;

import com.andersenlab.ponamorev.tinkoffbank.pages.HousingInMoscowPage;
import net.thucydides.core.annotations.Step;

public class HousingInMoscowSteps extends BaseSteps {

    HousingInMoscowPage housingInMoscowPage;

    @Step("Нажимается вкладка <Оплатить ЖКУ в Москве>")
    public void clickPayHousingInMoscow() {
        housingInMoscowPage.clickPayHousingInMoscowTab();
    }
}