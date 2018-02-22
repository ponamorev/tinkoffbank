package com.andersenlab.ponamorev.tinkoffbank;

import com.andersenlab.ponamorev.tinkoffbank.pages.PayHousingInMoscowPage;
import com.andersenlab.ponamorev.tinkoffbank.steps.PayHousingInMoscowSteps;
import com.andersenlab.ponamorev.tinkoffbank.steps.PaymentsSteps;
import org.testng.annotations.Test;

public class TinkoffBankChangingCityTest {
    PayHousingInMoscowPage currentPage;

    PayHousingInMoscowSteps payHousingInMoscowSteps = new PayHousingInMoscowSteps();
    PaymentsSteps paymentsSteps = new PaymentsSteps();

    @Test(groups = "main_group")
    public void tinkoff_bank_change_city_test() {

    }
}