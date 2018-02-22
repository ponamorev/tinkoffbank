package com.andersenlab.ponamorev.tinkoffbank;

import com.andersenlab.ponamorev.tinkoffbank.data.AccordingErrorMessageByNumber;
import com.andersenlab.ponamorev.tinkoffbank.steps.PayHousingInMoscowSteps;
import org.testng.annotations.*;

public class CheckingValuesTest extends BaseTest {
    private final String validPayerCode = "1234567890";
    private final String validPeriod = "122017";
    private final String validSum = "5000";
    private final String defaultUrl = "https://www.tinkoff.ru/zhku-moskva/oplata/?tab=pay";

    PayHousingInMoscowSteps payHousingInMoscowSteps = new PayHousingInMoscowSteps();

    @DataProvider
    public Object[] dataForPayerCodeField() {
        return new String[] {
                "123456",
                "qwertyasu1",
                "123354asqa",
                "//*..}]1$-",
                "!@#1%^&*()",
                "<>?,/'\";:3",
                "+\\=[{|1237"
        };
    }

    @DataProvider
    public Object[] dataForPeriodField() {
        return new String[] {
                "120",
                "//12...",
                "qwe12",
                "{}8*",
                "132017",
                "002017",
                "1-528",
                "12528",
                "/\\1'\"",
                ",<.>7",
                "-=+23"
        };
    }

    @DataProvider
    public Object[] dataForSumField() {
        return new String[] {
                "//qwera",
                "**(",
                "----",
                "(/+)",
                "-15",
                "-qwe4569",
                "-65*78",
                "(-5)*10"
        };
    }

    @DataProvider
    public Object[] dataForSumFieldWithMinValue() {
        return new String[] {
                "0",
                "5",
                "9"
        };
    }

    @DataProvider
    public Object[] dataForSumFieldWithMaxValue() {
        return new String[] {
                "15001",
                "150000",
                "1000000",
                "50000000"
        };
    }

    @BeforeMethod
    public void waitPageLoading() {
        if (!BaseTest.driver.getCurrentUrl().equals(defaultUrl))
            payHousingInMoscowSteps.openBasePage();
        payHousingInMoscowSteps.waitUntilPageIsLoaded();
    }

    @Test(dataProvider = "dataForPayerCodeField", groups = "main_group")
    public void checking_payer_code_field_test(String code) {
        payHousingInMoscowSteps.payerCodeFieldShouldBeEnabled();
        payHousingInMoscowSteps.clearPayerCodeField();
        payHousingInMoscowSteps.enterPayerCode(code);

        payHousingInMoscowSteps.clickSubmitButton();
        payHousingInMoscowSteps.errorMessageShouldBeDisplayed(AccordingErrorMessageByNumber.PAYER_CODE);
        payHousingInMoscowSteps.errorMessageAboutInvalidDataShouldBeCorrect(AccordingErrorMessageByNumber.PAYER_CODE);
        payHousingInMoscowSteps.errorMessageShouldBeDisplayed(AccordingErrorMessageByNumber.PERIOD);
        payHousingInMoscowSteps.errorMessageAboutEmptyFieldShouldBeCorrect(AccordingErrorMessageByNumber.PERIOD);
        payHousingInMoscowSteps.errorMessageShouldBeDisplayed(AccordingErrorMessageByNumber.SUM);
        payHousingInMoscowSteps.errorMessageAboutEmptyFieldShouldBeCorrect(AccordingErrorMessageByNumber.SUM);
    }

    @Test(dataProvider = "dataForPeriodField", groups = "main_group")
    public void checking_period_field_test(String period) {
        payHousingInMoscowSteps.periodFieldShouldBeEnabled();
        payHousingInMoscowSteps.clearPeriodField();
        payHousingInMoscowSteps.enterPeriod(period);

        payHousingInMoscowSteps.clickSubmitButton();
        payHousingInMoscowSteps.errorMessageShouldBeDisplayed(AccordingErrorMessageByNumber.PERIOD);
        payHousingInMoscowSteps.errorMessageAboutInvalidDataShouldBeCorrect(AccordingErrorMessageByNumber.PERIOD);
        payHousingInMoscowSteps.errorMessageShouldBeDisplayed(AccordingErrorMessageByNumber.PAYER_CODE);
        payHousingInMoscowSteps.errorMessageAboutEmptyFieldShouldBeCorrect(AccordingErrorMessageByNumber.PAYER_CODE);
        payHousingInMoscowSteps.errorMessageShouldBeDisplayed(AccordingErrorMessageByNumber.SUM);
        payHousingInMoscowSteps.errorMessageAboutEmptyFieldShouldBeCorrect(AccordingErrorMessageByNumber.SUM);
    }

    @Test(dataProvider = "dataForSumField", groups = "main_group")
    public void checking_sum_field_test(String sum) {
        payHousingInMoscowSteps.sumFieldShouldBeEnabled();
        payHousingInMoscowSteps.clearSumField();
        payHousingInMoscowSteps.enterSum(sum);

        payHousingInMoscowSteps.clickSubmitButton();
        payHousingInMoscowSteps.errorMessageShouldBeDisplayed(AccordingErrorMessageByNumber.SUM);
        payHousingInMoscowSteps.errorMessageAboutInvalidDataShouldBeCorrect(AccordingErrorMessageByNumber.SUM);
        payHousingInMoscowSteps.errorMessageShouldBeDisplayed(AccordingErrorMessageByNumber.PERIOD);
        payHousingInMoscowSteps.errorMessageAboutEmptyFieldShouldBeCorrect(AccordingErrorMessageByNumber.PERIOD);
        payHousingInMoscowSteps.errorMessageShouldBeDisplayed(AccordingErrorMessageByNumber.PAYER_CODE);
        payHousingInMoscowSteps.errorMessageAboutEmptyFieldShouldBeCorrect(AccordingErrorMessageByNumber.PAYER_CODE);
    }

    @Test(dataProvider = "dataForSumFieldWithMinValue", groups = "main_group")
    public void checking_sum_field_with_min_value_test(String sum) {
        payHousingInMoscowSteps.payerCodeFieldShouldBeEnabled();
        payHousingInMoscowSteps.clearPayerCodeField();
        payHousingInMoscowSteps.enterPayerCode(validPayerCode);

        payHousingInMoscowSteps.periodFieldShouldBeEnabled();
        payHousingInMoscowSteps.clearPeriodField();
        payHousingInMoscowSteps.enterPeriod(validPeriod);

        payHousingInMoscowSteps.sumFieldShouldBeEnabled();
        payHousingInMoscowSteps.clearSumField();
        payHousingInMoscowSteps.enterSum(sum);

        payHousingInMoscowSteps.clickSubmitButton();
        payHousingInMoscowSteps.errorMessageShouldBeDisplayed(AccordingErrorMessageByNumber.SUM);
        payHousingInMoscowSteps.errorMessageAboutMinValueShouldBeCorrect();
    }

    @Test(dataProvider = "dataForSumFieldWithMaxValue", groups = "main_group")
    public void checking_sum_field_with_max_value_test(String sum) {
        payHousingInMoscowSteps.payerCodeFieldShouldBeEnabled();
        payHousingInMoscowSteps.clearPayerCodeField();
        payHousingInMoscowSteps.enterPayerCode(validPayerCode);

        payHousingInMoscowSteps.periodFieldShouldBeEnabled();
        payHousingInMoscowSteps.clearPeriodField();
        payHousingInMoscowSteps.enterPeriod(validPeriod);

        payHousingInMoscowSteps.sumFieldShouldBeEnabled();
        payHousingInMoscowSteps.clearSumField();
        payHousingInMoscowSteps.enterSum(sum);

        payHousingInMoscowSteps.clickSubmitButton();
        payHousingInMoscowSteps.errorMessageShouldBeDisplayed(AccordingErrorMessageByNumber.SUM);
        payHousingInMoscowSteps.errorMessageAboutMaxValueShouldBeCorrect();
    }

    @Test(groups = "main_group")
    public void checking_valid_values_test() {
        payHousingInMoscowSteps.payerCodeFieldShouldBeEnabled();
        payHousingInMoscowSteps.clearPayerCodeField();
        payHousingInMoscowSteps.enterPayerCode(validPayerCode);

        payHousingInMoscowSteps.periodFieldShouldBeEnabled();
        payHousingInMoscowSteps.clearPeriodField();
        payHousingInMoscowSteps.enterPeriod(validPeriod);

        payHousingInMoscowSteps.sumFieldShouldBeEnabled();
        payHousingInMoscowSteps.clearSumField();
        payHousingInMoscowSteps.enterSum(validSum);

        payHousingInMoscowSteps.clickSubmitButton();
        payHousingInMoscowSteps.errorMessageShouldNotBeDisplayed(AccordingErrorMessageByNumber.PAYER_CODE);
        payHousingInMoscowSteps.errorMessageShouldNotBeDisplayed(AccordingErrorMessageByNumber.PERIOD);
        payHousingInMoscowSteps.errorMessageShouldNotBeDisplayed(AccordingErrorMessageByNumber.SUM);
    }

    @Test(groups = "main_group")
    public void checking_empty_values_test() {
        payHousingInMoscowSteps.payerCodeFieldShouldBeEnabled();
        payHousingInMoscowSteps.periodFieldShouldBeEnabled();
        payHousingInMoscowSteps.sumFieldShouldBeEnabled();
        payHousingInMoscowSteps.clearPayerCodeField();
        payHousingInMoscowSteps.clearPeriodField();
        payHousingInMoscowSteps.clearSumField();
        payHousingInMoscowSteps.clickSubmitButton();

        payHousingInMoscowSteps.errorMessageShouldBeDisplayed(AccordingErrorMessageByNumber.PAYER_CODE);
        payHousingInMoscowSteps.errorMessageAboutEmptyFieldShouldBeCorrect(AccordingErrorMessageByNumber.PAYER_CODE);
        payHousingInMoscowSteps.errorMessageShouldBeDisplayed(AccordingErrorMessageByNumber.PERIOD);
        payHousingInMoscowSteps.errorMessageAboutEmptyFieldShouldBeCorrect(AccordingErrorMessageByNumber.PERIOD);
        payHousingInMoscowSteps.errorMessageShouldBeDisplayed(AccordingErrorMessageByNumber.SUM);
        payHousingInMoscowSteps.errorMessageAboutEmptyFieldShouldBeCorrect(AccordingErrorMessageByNumber.SUM);
    }

    @AfterMethod
    public void refreshPage() {
        payHousingInMoscowSteps.refresh();
    }
}