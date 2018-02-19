package com.andersenlab.ponamorev.tinkoffbank;

import com.andersenlab.ponamorev.tinkoffbank.data.ExpectedCitiesData;
import com.andersenlab.ponamorev.tinkoffbank.data.HousingsData;
import com.andersenlab.ponamorev.tinkoffbank.steps.*;
import net.thucydides.core.annotations.Steps;
import org.testng.annotations.Test;

public class TinkoffBankChoosingHousingTest extends BaseTest {
    @Steps
    BaseSteps baseSteps;
    @Steps
    PaymentsSteps paymentsSteps;
    @Steps
    HousingSteps housingSteps;
    @Steps
    HousingInMoscowSteps housingInMoscowSteps;

    @Test
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