package com.s_pro.kidsfund.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.File;

public class ChildHomePage extends BasePage {

    private final By addWishButton = By.xpath("//*[contains(text(), 'Add Wish')]");
    private final By wishTitleInput = By.cssSelector("input#title");
    private final By wishDescriptionInput = By.cssSelector("textarea.sc-kfGgVZ.ldHhPH");
    private final By wishCost = By.cssSelector("input#cost");
    private final By submitButton = By.cssSelector("button.sc-exAgwC.emMNGt");
    private final By uploadWishPhoto = By.cssSelector("img#wishUppy.avatarTrigger");
    private final By wishModalIsPresent = By.cssSelector("button.sc-ePAWwb.gAOyDQ");
    private final By browseImage = By.cssSelector("input[type='file'].uppy-Dashboard-input");
    private final By createdWish = By.xpath("//*[contains(text(), 'AutoWish')]");


    public ChildHomePage(WebDriver driver) {
        super(driver);
    }

    public void clickAddWishButton(){
        driver.findElement(addWishButton).click();
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
        driver.findElements(browseImage).get(3)
                .sendKeys("/home/tester/Desktop/BaseModel(TestNG)/src/test/java/com/s_pro/kidsfund/img/toy1.jpg");

    }

    public void verifyIsChildPageIsOpen(){
        driver.findElement(wishModalIsPresent).isDisplayed();
    }

    public void verifyThatWishIsDisplayed(){
        driver.findElement(createdWish).isDisplayed();
    }

}
