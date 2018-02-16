package com.andersenlab.ponamorev.tinkoffbank;

import net.thucydides.core.annotations.Managed;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    private static WebDriver webDriver;

    public static WebDriver getDriver() {
        if (webDriver == null) {
            webDriver = new ChromeDriver();
        }
        return webDriver;
    }

    @BeforeClass
    public static void setUp() {
        if (webDriver == null) {
            webDriver = new ChromeDriver();
            webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            webDriver.manage().window().maximize();
            webDriver.get("https://www.tinkoff.ru");
        }
    }

    @AfterClass
    public static void tearDown() {
        if (webDriver != null)
            webDriver.quit();
    }
}