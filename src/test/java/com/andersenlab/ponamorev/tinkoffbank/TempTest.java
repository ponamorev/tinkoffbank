package com.andersenlab.ponamorev.tinkoffbank;

import com.andersenlab.ponamorev.tinkoffbank.steps.BaseSteps;
import com.andersenlab.ponamorev.tinkoffbank.steps.HousingInMoscowSteps;
import com.andersenlab.ponamorev.tinkoffbank.steps.HousingSteps;
import com.andersenlab.ponamorev.tinkoffbank.steps.PaymentsSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class TempTest extends BaseTest {
    @Steps
    BaseSteps baseSteps;
    @Steps
    PaymentsSteps paymentsSteps;
    @Steps
    HousingSteps housingSteps;
    @Steps
    HousingInMoscowSteps housingInMoscowSteps;

    @Test
    public void temp_test() {

    }
}