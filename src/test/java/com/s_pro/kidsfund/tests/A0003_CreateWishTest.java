package com.s_pro.kidsfund.tests;

import com.s_pro.kidsfund.pages.ChildHomePage;
import com.s_pro.kidsfund.pages.LandingPage;
import com.s_pro.kidsfund.pages.LoginPage;
import com.s_pro.kidsfund.pages.ParentHomePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class A0003_CreateWishTest extends BaseTest {

    private final String login = "imartynenko@s-pro.io";
    private final String password = "Qwerty123$";
    private final By wishTitle = By.cssSelector("p.sc-dNLxif.cIYdyB");

    @Test
    public void test() {
        driver.get(baseUrl);

        LoginPage loginPage = new LoginPage(driver);
        LandingPage landingPage = new LandingPage(driver);
        ParentHomePage parentHomePage = new ParentHomePage(driver);
        ChildHomePage childHomePage = new ChildHomePage(driver);

        // Open Landing page
        landingPage.clickAlreadyHaveAccountButton();
        // Fill inputs with valid data
        loginPage.fillLogin(login);
        loginPage.fillPassword(password);
        loginPage.clickLoginButton();
        // Open user's Home page + verify that Martin Iger's home page successfully open
        parentHomePage.verifyParentNameIsDisplayed();
        // Choose child for create wish
        parentHomePage.chooseChildAcc();
        // Click Add wish button on the child page
        childHomePage.verifyIsChildPageIsOpen();
        childHomePage.clickAddWishButton();
        // Verify that modal is opened
        String actualEmailString = driver.findElement((wishTitle)).getText();
        Assert.assertTrue(actualEmailString.equals("Create Wish Fund"), "Wish modal isn't opened");
        // Fill other fields
        childHomePage.uploadPhoto();
        childHomePage.fillWishTitle();
        childHomePage.fillWishDescription();
        childHomePage.fillWishCost();
        childHomePage.clickSubmitButton();
        // Verify that wish was successfully created
        childHomePage.verifyThatWishIsDisplayed();
        // Logout from Home page
        parentHomePage.clickMenuButton();
        parentHomePage.clickLogoutButton();
        parentHomePage.verifyLogoutTitleIsDisplayed();
        parentHomePage.clickYesButton();

    }
}
