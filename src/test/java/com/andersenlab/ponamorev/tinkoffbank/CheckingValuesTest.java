package com.andersenlab.ponamorev.tinkoffbank;

import com.andersenlab.ponamorev.tinkoffbank.steps.PayHousingInMoscowSteps;
import net.thucydides.core.annotations.Steps;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class CheckingValuesTest extends BaseTest {
    @Steps
    PayHousingInMoscowSteps payHousingInMoscowSteps;

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

    @Test(dataProvider = "data")
    public void checking_values_test(String code,
                                     String period,
                                     String sum) {

    }
}