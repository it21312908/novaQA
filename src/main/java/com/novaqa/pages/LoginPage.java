package com.novaqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginBtn = By.id("login-button");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public HomePage login(String user, String pass) {

        type(username, user);
        type(password, pass);
        click(loginBtn);

        return new HomePage(driver);
    }

}
