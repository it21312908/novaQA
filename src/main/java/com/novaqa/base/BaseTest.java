//package com.novaqa.base;
//
//import com.novaqa.driver.DriverFactory;
//import org.openqa.selenium.WebDriver;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//
//public class BaseTest {
//
//    protected WebDriver driver;
//
//    @BeforeMethod
//    public void setUp() {
//        driver = DriverFactory.createDriver();
//    }
//
//    @AfterMethod
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//}

package com.novaqa.base;

import com.novaqa.driver.DriverFactory;
import com.novaqa.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = DriverFactory.createDriver();

        driver.get(ConfigReader.getApplicationUrl());
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}