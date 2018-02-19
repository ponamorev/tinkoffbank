package com.andersenlab.ponamorev.tinkoffbank;

import com.andersenlab.ponamorev.tinkoffbank.steps.PayHousingInMoscowSteps;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckingValuesTest extends BaseTest {
    PayHousingInMoscowSteps payHousingInMoscowSteps = new PayHousingInMoscowSteps();

    @DataProvider
    static Object[][] data() {
        return new Object[][]{
                {"1234567890", "122017", "15000"},
                {"12345ЗОоЬQ", "122017", "15000"},
                {"-123456789", "122017", "15000"},
                {"//]..12.43", "122017", "15000"},
                {"12345.6778", "122017", "15000"},
                {"1234567890", "002017", "15000"},
                {"1234567890", "132017", "15000"},
                {"1234567890", "13201700", "15000"},
                {"1234567890", "122k17", "15000"},
                {"1234567890", "Дек2017", "15000"},
                {"1234567890", "12/17", "15000"},
                {"1234567890", "122017", "15ooo"},
                {"1234567890", "122017", "l0000"},
                {"1234567890", "122017", "qwerty"},
                {"1234567890", "122017", "//12.o"}
        };
    }

    @Test(dataProvider = "data", groups = "main_group")
    public void checking_values_test(String code,
                                     String period,
                                     String sum) {
        payHousingInMoscowSteps.waitUntilPageIsLoaded();
        payHousingInMoscowSteps.payerCodeFieldShouldBeEnabled();
        payHousingInMoscowSteps.clearPayerCodeField();
        payHousingInMoscowSteps.enterPayerCode(code);

        payHousingInMoscowSteps.periodFieldShouldBeEnabled();
        payHousingInMoscowSteps.clearPeriodField();
        payHousingInMoscowSteps.enterPeriod(period);

        payHousingInMoscowSteps.sumFieldShouldBeEnabled();
        payHousingInMoscowSteps.clearSumField();
        payHousingInMoscowSteps.enterSum(sum);

        payHousingInMoscowSteps.refresh();
    }
}