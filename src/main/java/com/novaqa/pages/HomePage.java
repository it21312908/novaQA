package com.novaqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private By appLogo = By.className("app_logo");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isHomePageLoaded() {
        return getText(appLogo).equals("Swag Labs");
    }
}
