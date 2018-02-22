package com.andersenlab.ponamorev.tinkoffbank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentsPage extends BasePage {
    @FindBy(css = ".ui-menu__item:nth-child(2)")
    private WebElement housing;
    @FindBy(css = ".Input__field_2XFoD")
    private WebElement searchInput;
    @FindBy(css = ".SearchSuggest__entry_highlighted_1SPg3 .Text__text_sizeDesktop_17_1mlTq")
    private WebElement firstElementFromDropDownList;

    public boolean isHousingEnabled() {
        return isPresent(housing) && housing.isEnabled();
    }

    public void clickHousing() {
        housing.click();
    }

    public boolean isSearchInputFieldEnabled() {
        return isPresent(searchInput) && searchInput.isEnabled();
    }

    public void enterSearchString(String searchString) {
        searchInput.sendKeys(searchString);
    }

    public boolean isFirstElementFromListEnabled() {
        return isPresent(firstElementFromDropDownList) && firstElementFromDropDownList.isEnabled();
    }

    public String getTextFirstElementFromList() {
        return firstElementFromDropDownList.getText();
    }

    public void clickFirstElementFormList() {
        firstElementFromDropDownList.click();
    }
}