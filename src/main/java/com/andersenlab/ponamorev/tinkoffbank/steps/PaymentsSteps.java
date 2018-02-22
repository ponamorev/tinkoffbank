package com.andersenlab.ponamorev.tinkoffbank.steps;

import com.andersenlab.ponamorev.tinkoffbank.pages.PaymentsPage;
import io.qameta.allure.Step;

import static org.testng.Assert.assertEquals;
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

    @Step("Проверяется, что поле для поиска доступно")
    public void searchInputFieldShouldBeEnabled() {
        assertTrue(paymentsPage.isSearchInputFieldEnabled(),
                "Поле для поиска не доступно");
    }

    @Step("Вводится название организации")
    public void enterSearchString(String searchString) {
        paymentsPage.enterSearchString(searchString);
    }

    @Step("Проверяется, что первый элемент в выпадающем списке доступен")
    public void firstElementFromListShouldBeEnabled() {
        assertTrue(paymentsPage.isFirstElementFromListEnabled(),
                "Первый элемент в выпадающем списке не доступен");
    }

    @Step("Сравнивается название организации в первом элементе списка с <{0}>")
    public void organisationNameShouldBeSameAs(String name) {
        assertEquals(name, paymentsPage.getTextFirstElementFromList(),
                "Название организации из первого элемента не совпадает с <{0}>");
    }

    @Step("Нажимается первый элемент из выпадающего списка")
    public void clickFirstElementFormList() {
        paymentsPage.clickFirstElementFormList();
    }
}