package com.s_pro.kidsfund.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.File;

public class ChildHomePage extends BasePage {

    private final By addWishButton = By.cssSelector("p.sc-kgAjT.cuzzPp");
    private final By wishTitleInput = By.cssSelector("input#title");
    private final By wishDescriptionInput = By.cssSelector("textarea.sc-kfGgVZ.ldHhPH");
    private final By wishCost = By.cssSelector("input#cost");
    private final By submitButton = By.cssSelector("button.sc-exAgwC.emMNGt");
    private final By uploadWishPhoto = By.cssSelector("img#wishUppy.avatarTrigger");


    public ChildHomePage(WebDriver driver) {
        super(driver);
    }

    public void clickAddWishButton(){
        waitForVisibility(addWishButton);
        driver.findElements(addWishButton).get(1).click();
    }

    public void fillWishTitle(){
        driver.findElement(wishTitleInput).sendKeys("AutoWish");

    }

    public void fillWishDescription(){
        driver.findElement(wishDescriptionInput).sendKeys("Create via IntelliJ");
    }

    public void fillWishCost(){
        driver.findElement(wishCost).sendKeys("53");
    }

    public void clickSubmitButton(){
        driver.findElement(submitButton).click();
    }

    public void uploadPhoto(){
        waitForClickable(uploadWishPhoto);
        driver.findElement(uploadWishPhoto).click();
        File file = new File("img/toy1.jpg");

    }









}
