package com.andersenlab.ponamorev.tinkoffbank.pages;

import com.andersenlab.ponamorev.tinkoffbank.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage {
    static final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);
    String defaultUrl = "https://www.tinkoff.ru";

    @FindBy(css = "#mainMenu *[data-qa-file='MenuItem'] *[href='/payments/']")
    private WebElement paymentsButton;

    private void initPageElements(WebDriver driver, BasePage page) {
        PageFactory.initElements(driver, page);
    }

    public void waitUntilPageIsLoaded(BasePage page) {
        ExpectedCondition<Boolean> pageReadyStateIsCompleted =
                (webdriver -> ((JavascriptExecutor) webdriver).executeScript("return document.readyState").equals("complete"));
        try {
            new WebDriverWait(BaseTest.driver, 5).until(pageReadyStateIsCompleted);
        } catch (Exception e) {
            LOGGER.error(String.format("Страница \"%s\" не загрузилась", BaseTest.driver.getTitle()));
        }
        initPageElements(BaseTest.driver, page);
    }

    public boolean isPaymentsButtonEnabled() {
        return paymentsButton.isEnabled();
    }

    public void clickPaymentsButton() {
        paymentsButton.click();
    }

    public void open() {
        BaseTest.driver.get(defaultUrl);
    }

    boolean isPresent(WebElement element) {
        try {
            for (int i = 0; i < 5; i++) {
                new WebDriverWait(BaseTest.driver, 1).until(
                        ExpectedConditions.visibilityOf(element));
                if (element.isDisplayed()) {
                    return true;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}