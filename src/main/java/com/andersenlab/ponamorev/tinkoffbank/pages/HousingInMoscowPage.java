package com.andersenlab.ponamorev.tinkoffbank.pages;

import com.andersenlab.ponamorev.tinkoffbank.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HousingInMoscowPage extends BasePage {
    @FindBy(xpath = "//*[text()='Оплатить ЖКУ в Москве']")
    private WebElement payHousingInMoscowTab;

    public HousingInMoscowPage() {
        super(BaseTest.driver, HousingInMoscowPage.class);
    }

    public void clickPayHousingInMoscowTab() {
        payHousingInMoscowTab.click();
    }
}