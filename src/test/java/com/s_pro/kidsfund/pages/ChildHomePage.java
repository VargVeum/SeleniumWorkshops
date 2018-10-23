package com.s_pro.kidsfund.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
    private final By deleteWishButton = By.xpath("//*[contains(text(), 'Delete')]");
    private final By verifyDeleteModalTitle = By.xpath("//*[contains(text(), 'Are you sure that you want to delete this wish?')]");
    private final By cancelDeleteButton = By.xpath("//*[contains(text(), 'Cancel')]");
    private final By submitDeleteButton = By.xpath("//*[contains(text(), 'Ok')]");

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

    public void chooseWishForDelete(){
        waitForClickable(createdWish);
        driver.findElement(createdWish).click();
    }

    public void clickNoButton(){
        waitForClickable(deleteWishButton);
        driver.findElement(deleteWishButton).click();
        driver.findElement(verifyDeleteModalTitle).isDisplayed();
        driver.findElement(cancelDeleteButton).click();

    }

    public void clickYesButton(){
        waitForClickable(deleteWishButton);
        driver.findElement(deleteWishButton).click();
        driver.findElement(verifyDeleteModalTitle).isDisplayed();
        driver.findElement(submitDeleteButton).click();
    }

    public void verifyThatWishWasDeleted(){
        checkThatElementWasDeleted(createdWish);

    }





}
