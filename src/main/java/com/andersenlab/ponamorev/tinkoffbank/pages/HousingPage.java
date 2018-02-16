package com.andersenlab.ponamorev.tinkoffbank.pages;

import com.andersenlab.ponamorev.tinkoffbank.BaseTest;
import com.andersenlab.ponamorev.tinkoffbank.data.ExpectedCitiesData;
import com.andersenlab.ponamorev.tinkoffbank.data.HousingsData;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HousingPage extends BasePage {
    private final String choosingCitySelector = "//*[contains(@class, 'UiRegions__uiRegions__layout')]//*[text()='%s']";
    WebElement city;

    @FindBy(css = ".Link__link_3805p")
    private WebElement cityName;
    @FindBy(css = ".ui-menu__item:first-child")
    private WebElement firstHousing;

    public boolean isCityNameSameAs(ExpectedCitiesData expectedCity) {
        return cityName.getText().equals(expectedCity.getOfCity());
    }

    public void clickChosenCity() {
        city.click();
    }

    public boolean isChosenCityEnabled(ExpectedCitiesData expectedCity) {
        city = BaseTest.getDriver().findElement(By.xpath(String.format(choosingCitySelector, expectedCity.getCity())));
        initElements();
        return city.isEnabled();
    }

    public boolean isFirstHousingSameAs(HousingsData housing) {
        return housing.getHousing().equals(firstHousing.getText());
    }

    public String getFirstHousingName() {
        return firstHousing.getText();
    }

    public void clickFirstHousing() {
        firstHousing.click();
    }

    public void clickCityName() {
        cityName.click();
    }
}