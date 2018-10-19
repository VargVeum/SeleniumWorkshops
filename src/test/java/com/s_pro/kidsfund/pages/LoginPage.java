package com.s_pro.kidsfund.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By emailInput = By.cssSelector("input#loginEmail");
    private final By passwordInput = By.cssSelector("input#loginPassword");
    private final By loginButton = By.cssSelector("button.sc-cCbXAZ.ghsFRm");

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void fillLogin(String login){
        waitForVisibility(emailInput);
        driver.findElement(emailInput).sendKeys(login);
    }

    public void fillPassword(String password){
        waitForVisibility(passwordInput);
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton(){
        waitForClickable(loginButton);
        driver.findElement(loginButton).click();
    }


}
