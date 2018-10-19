package com.s_pro.kidsfund.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends BasePage {
    private final By alreadyHaveAccountButton = By.cssSelector("a.sc-doWzTn.fhhbDq");


    public LandingPage(WebDriver driver){
        super(driver);
    }

    public void clickAlreadyHaveAccountButton(){
        driver.findElement(alreadyHaveAccountButton).click();
    }



}
