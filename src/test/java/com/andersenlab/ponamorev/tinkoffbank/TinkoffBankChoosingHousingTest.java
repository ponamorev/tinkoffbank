package com.andersenlab.ponamorev.tinkoffbank;

import com.andersenlab.ponamorev.tinkoffbank.data.ExpectedCitiesData;
import com.andersenlab.ponamorev.tinkoffbank.data.HousingsData;
import com.andersenlab.ponamorev.tinkoffbank.steps.BaseSteps;
import com.andersenlab.ponamorev.tinkoffbank.steps.HousingInMoscowSteps;
import com.andersenlab.ponamorev.tinkoffbank.steps.HousingSteps;
import com.andersenlab.ponamorev.tinkoffbank.steps.PaymentsSteps;
import org.testng.annotations.Test;

public class TinkoffBankChoosingHousingTest extends BaseTest {
    BaseSteps baseSteps = new BaseSteps();
    PaymentsSteps paymentsSteps = new PaymentsSteps();
    HousingSteps housingSteps = new HousingSteps();
    HousingInMoscowSteps housingInMoscowSteps = new HousingInMoscowSteps();

    @Test(groups = "main_group")
    public void tinkoff_bank_choosing_housing_test() {
        baseSteps.openBasePage();
        baseSteps.waitUntilPageIsLoaded();
        baseSteps.paymentsButtonShouldBeEnabled();
        baseSteps.clickPaymentsButton();

        paymentsSteps.waitUntilPageIsLoaded();
        paymentsSteps.housingButtonShouldBeEnabled();
        paymentsSteps.clickHousingButton();

        housingSteps.waitUntilPageIsLoaded();
        housingSteps.cityChecking(ExpectedCitiesData.MOSCOW);
        housingSteps.firstHousingShouldBeSameAs(HousingsData.HOUSING_MOSCOW);
        String housingName = housingSteps.getFirstHousingName();
        housingSteps.clickFirstHousing();

        housingInMoscowSteps.waitUntilPageIsLoaded();
        housingInMoscowSteps.clickPayHousingInMoscow();
    }
}