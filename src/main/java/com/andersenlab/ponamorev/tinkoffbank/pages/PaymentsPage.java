package com.andersenlab.ponamorev.tinkoffbank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentsPage extends BasePage {
    @FindBy(css = ".ui-menu__item:nth-child(2)")
    private WebElement housing;

    public boolean isHousingEnabled() {
        return housing.isEnabled();
    }

    public void clickHousing() {
        housing.click();
    }
}