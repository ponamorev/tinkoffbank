package com.andersenlab.ponamorev.tinkoffbank.pages;

import com.andersenlab.ponamorev.tinkoffbank.BaseTest;
import com.andersenlab.ponamorev.tinkoffbank.data.ExpectedCitiesData;
import com.andersenlab.ponamorev.tinkoffbank.data.HousingsData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HousingPage extends BasePage {
    private final String choosingCitySelector = "//*[text()='%s']/..";
    WebElement city;

    @FindBy(css = "*[role='button']")
    private WebElement cityName;
    @FindBy(css = ".ui-menu__item:first-child")
    private WebElement firstHousing;
    @FindBy(css = ".ui-link.ui-menu__link.ui-menu__link_logo .ui-link__text")
    private List<WebElement> listOfHousings;

    public boolean isCityNameSameAs(ExpectedCitiesData expectedCity) {
        return isPresent(cityName) && cityName.getText().equals(expectedCity.getOfCity());
    }

    public void clickChosenCity() {
        city.click();
    }

    public boolean isChosenCityEnabled(ExpectedCitiesData expectedCity) {
        city = BaseTest.driver.findElement(By.xpath(String.format(choosingCitySelector, expectedCity.getCity())));
        if (isPresent(city)) {
            new WebDriverWait(BaseTest.driver, 5).until(ExpectedConditions.elementToBeClickable(city));
            return city.isEnabled();
        }
        return false;
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
        if (isPresent(cityName)) {
            if (cityName.isEnabled())
                cityName.click();
        }
    }

    public boolean isHousingExist(HousingsData housing) {
        for (WebElement element : listOfHousings) {
            if (element.getText().equals(housing.getHousing()))
                return true;
        }
        return false;
    }
}