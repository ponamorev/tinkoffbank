package com.andersenlab.ponamorev.tinkoffbank;

import com.andersenlab.ponamorev.tinkoffbank.data.ExpectedCitiesData;
import com.andersenlab.ponamorev.tinkoffbank.data.HousingsData;
import com.andersenlab.ponamorev.tinkoffbank.pages.BasePage;
import com.andersenlab.ponamorev.tinkoffbank.pages.HousingInMoscowPage;
import com.andersenlab.ponamorev.tinkoffbank.pages.HousingPage;
import com.andersenlab.ponamorev.tinkoffbank.pages.PaymentsPage;
import org.junit.Test;

public class TempTest extends BaseTest {
    BasePage basePage = new BasePage();
    PaymentsPage paymentsPage = new PaymentsPage();
    HousingPage housingPage = new HousingPage();
    HousingInMoscowPage housingInMoscowPage = new HousingInMoscowPage();

    @Test
    public void temp_test() {
        basePage.waitUntilPageIsLoaded();
        if (basePage.isPaymentsButtonEnabled()) {
            basePage.clickPaymentsButton();
            paymentsPage.waitUntilPageIsLoaded();
            if (paymentsPage.isHousingEnabled()) {
                paymentsPage.clickHousing();
                housingPage.waitUntilPageIsLoaded();
                if (!housingPage.isCityNameSameAs(ExpectedCitiesData.MOSCOW)) {
                    housingPage.clickCityName();
                    housingPage.choseCity(ExpectedCitiesData.MOSCOW);
                    if (housingPage.isChosenCityEnabled())
                        housingPage.clickCity();
                    else return;
                    if (housingPage.isFirstHousingSameAs(HousingsData.HOUSING_MOSCOW)) {
                        System.out.println(housingPage.getFirstHousingName());
                        housingPage.clickFirstHousing();
                    } else System.out.println("ЖКУ не совпадает");
                }
            }
        }
    }
}