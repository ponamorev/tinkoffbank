package com.andersenlab.ponamorev.tinkoffbank.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

public class HousingInMoscowPage extends BasePage {
    @FindBy(xpath = "//*[text()='Оплатить ЖКУ в Москве']")
    private WebElement payHousingInMoscowTab;

    public boolean isPayHousingInMoscowTabEnabled() {
        return payHousingInMoscowTab.isEnabled();
    }

    public void clickPayHousingInMoscowTab() {
        payHousingInMoscowTab.click();
    }
}