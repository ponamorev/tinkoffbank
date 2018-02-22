package com.andersenlab.ponamorev.tinkoffbank;

import com.andersenlab.ponamorev.tinkoffbank.data.ExpectedCitiesData;
import com.andersenlab.ponamorev.tinkoffbank.data.HousingsData;
import com.andersenlab.ponamorev.tinkoffbank.pages.PayHousingInMoscowPage;
import com.andersenlab.ponamorev.tinkoffbank.steps.*;
import org.testng.annotations.Test;

public class TinkoffBankChoosingHousingTest extends BaseTest {
    static String housingName;
    static PayHousingInMoscowPage savingPage;

    BaseSteps baseSteps = new BaseSteps();
    PaymentsSteps paymentsSteps = new PaymentsSteps();
    HousingSteps housingSteps = new HousingSteps();
    HousingInMoscowSteps housingInMoscowSteps = new HousingInMoscowSteps();
    PayHousingInMoscowSteps payHousingInMoscowSteps = new PayHousingInMoscowSteps();

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
        housingName = housingSteps.getFirstHousingName();
        housingSteps.clickFirstHousing();

        housingInMoscowSteps.waitUntilPageIsLoaded();
        housingInMoscowSteps.clickPayHousingInMoscow();

        payHousingInMoscowSteps.waitUntilPageIsLoaded();
        savingPage = payHousingInMoscowSteps.getPayHousingInMoscowPage();
    }
}