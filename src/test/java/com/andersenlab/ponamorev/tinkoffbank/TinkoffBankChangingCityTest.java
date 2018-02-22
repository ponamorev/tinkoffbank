package com.andersenlab.ponamorev.tinkoffbank;

import com.andersenlab.ponamorev.tinkoffbank.data.ExpectedCitiesData;
import com.andersenlab.ponamorev.tinkoffbank.data.HousingsData;
import com.andersenlab.ponamorev.tinkoffbank.steps.HousingInMoscowSteps;
import com.andersenlab.ponamorev.tinkoffbank.steps.HousingSteps;
import com.andersenlab.ponamorev.tinkoffbank.steps.PayHousingInMoscowSteps;
import com.andersenlab.ponamorev.tinkoffbank.steps.PaymentsSteps;
import org.testng.annotations.Test;

public class TinkoffBankChangingCityTest {
    PaymentsSteps paymentsSteps = new PaymentsSteps();
    HousingInMoscowSteps housingInMoscowSteps = new HousingInMoscowSteps();
    PayHousingInMoscowSteps payHousingInMoscowSteps = new PayHousingInMoscowSteps();
    HousingSteps housingSteps = new HousingSteps();


    @Test(groups = "main_group")
    public void tinkoff_bank_change_city_test() {
        payHousingInMoscowSteps.waitUntilPageIsLoaded();
        payHousingInMoscowSteps.paymentsButtonShouldBeEnabled();
        payHousingInMoscowSteps.clickPaymentsButton();

        paymentsSteps.waitUntilPageIsLoaded();
        paymentsSteps.searchInputFieldShouldBeEnabled();
        paymentsSteps.enterSearchString(HousingsData.HOUSING_MOSCOW.getHousing());
        paymentsSteps.firstElementFromListShouldBeEnabled();
        paymentsSteps.organisationNameShouldBeSameAs(HousingsData.HOUSING_MOSCOW.getHousing());
        paymentsSteps.clickFirstElementFormList();

        housingInMoscowSteps.waitUntilPageIsLoaded();
        housingInMoscowSteps.payHousingInMoscowTabShouldBeEnabled();
        housingInMoscowSteps.clickPayHousingInMoscow();

        payHousingInMoscowSteps.waitUntilPageIsLoaded();
        payHousingInMoscowSteps.currentPageShouldBeSameAsSaved();
        payHousingInMoscowSteps.paymentsButtonShouldBeEnabled();
        payHousingInMoscowSteps.clickPaymentsButton();

        paymentsSteps.waitUntilPageIsLoaded();
        paymentsSteps.housingButtonShouldBeEnabled();
        paymentsSteps.clickHousingButton();

        housingSteps.waitUntilPageIsLoaded();
        housingSteps.cityChecking(ExpectedCitiesData.SAINT_PETERBURG);
        housingSteps.checkingOrganisationExisting(HousingsData.HOUSING_MOSCOW);
    }
}