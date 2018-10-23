package com.s_pro.kidsfund.tests;

import com.s_pro.kidsfund.pages.ChildHomePage;
import com.s_pro.kidsfund.pages.LandingPage;
import com.s_pro.kidsfund.pages.LoginPage;
import com.s_pro.kidsfund.pages.ParentHomePage;
import org.testng.annotations.Test;

public class A0004_DeleteWishTest extends BaseTest {

    private final String login = "imartynenko@s-pro.io";
    private final String password = "Qwerty123$";

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
        // Choose child for delete previously created wish
        parentHomePage.chooseChildAcc();
        // Verify that wish was displayed on the page
        childHomePage.verifyThatWishIsDisplayed();
        childHomePage.chooseWishForDelete();
        childHomePage.clickNoButton();
        //childHomePage.chooseWishForDelete();
        childHomePage.clickYesButton();
        // Verify that wish was successfully deleted
        childHomePage.verifyThatWishWasDeleted();

    }
}
