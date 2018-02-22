package com.andersenlab.ponamorev.tinkoffbank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HousingInMoscowPage extends BasePage {
    @FindBy(xpath = "//*[text()='Оплатить ЖКУ в Москве']")
    private WebElement payHousingInMoscowTab;

    public boolean isPayHousingInMoscowTabEnabled() {
        return isPresent(payHousingInMoscowTab) && payHousingInMoscowTab.isEnabled();
    }

    public void clickPayHousingInMoscowTab() {
        payHousingInMoscowTab.click();
    }
}