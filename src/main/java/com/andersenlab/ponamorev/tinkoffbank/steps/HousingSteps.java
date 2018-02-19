package com.andersenlab.ponamorev.tinkoffbank.steps;

import com.andersenlab.ponamorev.tinkoffbank.data.ExpectedCitiesData;
import com.andersenlab.ponamorev.tinkoffbank.data.HousingsData;
import com.andersenlab.ponamorev.tinkoffbank.pages.HousingPage;
import net.thucydides.core.annotations.Step;

import static org.junit.Assert.assertTrue;

public class HousingSteps extends BaseSteps {

    HousingPage housingPage;

    @Step("Название города должно быть <{0}>")
    public void cityNameShouldBeSameAs(ExpectedCitiesData expectedCity) {
        assertTrue("Название города не совпадает с <{0}>",
                housingPage.isCityNameSameAs(expectedCity));
    }

    @Step("Проверяется город")
    public void cityChecking(ExpectedCitiesData expectedCity) {
        if (housingPage.isCityNameSameAs(expectedCity))
            cityShouldBeEnabled(expectedCity);
        else {
            clickCityName();
            cityShouldBeEnabled(expectedCity);
            clickChosenCity();
            cityNameShouldBeSameAs(expectedCity);
        }
    }

    @Step("Нажимается выбранный город")
    private void clickChosenCity() {
        housingPage.clickChosenCity();
    }

    @Step("Проверяется, что город <{0}> доступен")
    private void cityShouldBeEnabled(ExpectedCitiesData expectedCity) {
        assertTrue("Город <{0}> не доступен",
                housingPage.isChosenCityEnabled(expectedCity));
    }

    @Step("Проверяется, что имя первой организации в списке <{0}>")
    public void firstHousingShouldBeSameAs(HousingsData housing) {
        assertTrue("Имя первой организации не <{0}>",
                housingPage.isFirstHousingSameAs(housing));
    }

    @Step("Получить название первой организации в списке")
    public String getFirstHousingName() {
        return housingPage.getFirstHousingName();
    }

    @Step("Нажимается первая организация в списке")
    public void clickFirstHousing() {
        housingPage.clickFirstHousing();
    }

    @Step("Нажимается название города для открытия страницы выбора города")
    private void clickCityName() {
        housingPage.clickCityName();
    }
}