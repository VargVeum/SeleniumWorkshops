package com.s_pro.kidsfund.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;

public class ParentHomePage extends BasePage {
    private final By menuHeaderIcon = By.cssSelector("button.sc-yZwTr.YOkDb");
    private final By logoutButton = By.cssSelector("p.sc-kEmuub.jGYqIe");
    private final By yesButton = By.cssSelector("i.icon-icon_check.sc-frDJqD.gZgBMw");
    private final By chooseChild = By.cssSelector("p.sc-cLmFfZ.droXmj");

    public ParentHomePage(WebDriver driver) {
        super(driver);
    }

    public void chooseChildAcc(){
        waitForVisibility(chooseChild);
        driver.findElements(chooseChild).get(0).click();
    }



    public void verifyParentNameIsDisplayed(){
        String actualString = driver.findElement(verifyParentName()).getText();
        assertTrue(actualString.contains("Martin Iger"));
    }

    private By verifyParentName() {
        waitForVisibility(By.cssSelector("p.sc-jPPmml.XIEh"));
        return By.cssSelector("p.sc-jPPmml.XIEh");
    }

    // Elements for logout functional

    public void clickMenuButton(){
        waitForClickable(menuHeaderIcon);
        driver.findElement(menuHeaderIcon).click();
    }

    public void clickLogoutButton(){
        waitForClickable(logoutButton);
        driver.findElements(logoutButton).get(1).click();
    }

    private By verifyLogoutTitle(){
        waitForVisibility(By.cssSelector(".sc-bnXvFD.ghdEVK"));
        return By.cssSelector(".sc-bnXvFD.ghdEVK");
    }

    public void verifyLogoutTitleIsDisplayed(){
        String actualString = driver.findElement(verifyLogoutTitle()).getText();
        assertTrue(actualString.contains("Are you sure you want to logout from your account?"));
    }

    public void clickYesButton(){
        waitForClickable(yesButton);
        driver.findElement(yesButton).click();
    }











}

