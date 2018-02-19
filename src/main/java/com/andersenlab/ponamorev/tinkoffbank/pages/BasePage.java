package com.andersenlab.ponamorev.tinkoffbank.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DefaultUrl("https://www.tinkoff.ru")
public class BasePage extends PageObject {
    protected static final Logger logger = LoggerFactory.getLogger(BasePage.class);

    @FindBy(css = "*[href='/payments/'] *[data-qa-file='MenuItem']")
    private WebElement paymentsButton;

    public void waitUntilPageIsLoaded() {
        ExpectedCondition<Boolean> pageReadyStateIsCompleted =
                (webdriver -> ((JavascriptExecutor) webdriver).executeScript("return document.readyState").equals("complete"));
        try {
            new WebDriverWait(getDriver(), 5).until(pageReadyStateIsCompleted);
        } catch (Exception e) {
            logger.error(String.format("Страница \"%s\" не загрузилась", getDriver().getTitle()));
        }
        initElements();
    }

    public boolean isPaymentsButtonEnabled() {
        return paymentsButton.isEnabled();
    }

    public void clickPaymentsButton() {
        paymentsButton.click();
    }

    private void initElements() {
        PageFactory.initElements(getDriver(), this);
    }
}