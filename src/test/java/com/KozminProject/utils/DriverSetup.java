package com.KozminProject.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


import java.time.Duration;

public class DriverSetup {

    protected static WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp(){

        try {
            driver = WebDriverManager.chromedriver().create();
            driver.manage().window().maximize();
        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Driver initialization failed", e);
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        if (driver != null){
            try {// zawarcie warunku if null zapobiega występowaniu wyjątku NullPointerException jeśli driver nie został zainicjalizowany lub został już zniszczony
                driver.quit();
            } catch (Exception e){
                e.printStackTrace();
                throw new RuntimeException("Driver quit failed", e);
            }
        }
    }
}
