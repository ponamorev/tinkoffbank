package com.andersenlab.ponamorev.tinkoffbank.steps;

import com.andersenlab.ponamorev.tinkoffbank.data.ExpectedCitiesData;
import com.andersenlab.ponamorev.tinkoffbank.data.HousingsData;
import com.andersenlab.ponamorev.tinkoffbank.pages.HousingPage;
import io.qameta.allure.Step;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class HousingSteps extends BaseSteps {

    HousingPage housingPage = new HousingPage();

    @Step("Название города должно быть <{expectedCity.getOfCity}>")
    private void cityNameShouldBeSameAs(ExpectedCitiesData expectedCity) {
        assertTrue(housingPage.isCityNameSameAs(expectedCity),
                "Название города не совпадает с <{expectedCity.getOfCity}>");
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

    @Step("Проверяется, что город <{expectedCity.getCity}> доступен")
    private void cityShouldBeEnabled(ExpectedCitiesData expectedCity) {
        assertTrue(housingPage.isChosenCityEnabled(expectedCity),
                "Город <{expectedCity.getCity}> не доступен");
    }

    @Step("Проверяется, что имя первой организации в списке <{housing}>")
    public void firstHousingShouldBeSameAs(HousingsData housing) {
        assertTrue(housingPage.isFirstHousingSameAs(housing),
                "Имя первой организации не <{housing}>");
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

    @Override
    @Step("Ожидается, пока страница не загрузится")
    public void waitUntilPageIsLoaded() {
        housingPage.waitUntilPageIsLoaded(housingPage);
    }

    @Step("Проверяется, присутствует ли организация в списке")
    public void checkingOrganisationExisting(HousingsData housing) {
        boolean result = housingPage.isHousingExist(housing);
        if (result)
            assertTrue(true, "Организация присутствует в списке");
        else assertFalse(false, "Орагнизация не присутствует в списке");
    }
}