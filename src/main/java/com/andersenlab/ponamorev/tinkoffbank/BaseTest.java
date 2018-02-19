package com.andersenlab.ponamorev.tinkoffbank;

import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    @Managed(driver = "chrome")
    public static WebDriver driver;

    @BeforeSuite
    public void setUp() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}