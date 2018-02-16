package com.andersenlab.ponamorev.tinkoffbank;

import net.thucydides.core.annotations.Managed;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    @Managed
    public static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
    }

    @AfterClass
    public static void tearDown() {
        if (driver != null)
            driver.quit();
    }
}