package com.andersenlab.ponamorev.tinkoffbank.pages;

import com.andersenlab.ponamorev.tinkoffbank.BaseTest;
import com.andersenlab.ponamorev.tinkoffbank.data.ExpectedCitiesData;
import com.andersenlab.ponamorev.tinkoffbank.data.HousingsData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HousingPage extends BasePage {
    private final String choosingCitySelector = "//*[text()='%s']/..";
    WebElement city;

    @FindBy(css = "*[role='button']")
    private WebElement cityName;
    @FindBy(css = ".ui-menu__item:first-child")
    private WebElement firstHousing;

    public HousingPage() {
        super(BaseTest.driver, HousingPage.class);
    }

    public boolean isCityNameSameAs(ExpectedCitiesData expectedCity) {
        new WebDriverWait(BaseTest.driver, 5).until(ExpectedConditions.visibilityOf(cityName));
        return cityName.getText().equals(expectedCity.getOfCity());
    }

    public void clickChosenCity() {
        city.click();
    }

    public boolean isChosenCityEnabled(ExpectedCitiesData expectedCity) {
        city = BaseTest.driver.findElement(By.xpath(String.format(choosingCitySelector, expectedCity.getCity())));
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
        new WebDriverWait(BaseTest.driver, 5).until(ExpectedConditions.visibilityOf(cityName));
        cityName.click();
    }
}