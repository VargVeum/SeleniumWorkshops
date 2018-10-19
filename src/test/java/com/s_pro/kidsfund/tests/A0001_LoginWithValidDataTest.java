package com.s_pro.kidsfund.tests;

import com.s_pro.kidsfund.pages.LandingPage;
import com.s_pro.kidsfund.pages.LoginPage;
import com.s_pro.kidsfund.pages.ParentHomePage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class A0001_LoginWithValidDataTest extends BaseTest {
    private final String login = "imartynenko@s-pro.io";
    private final String password = "Qwerty123$";

    @Test
    public void test() {
        driver.get(baseUrl);

        LoginPage loginPage = new LoginPage(driver);
        LandingPage landingPage = new LandingPage(driver);
        ParentHomePage parentHomePage = new ParentHomePage(driver);

        // Open Landing page
        landingPage.clickAlreadyHaveAccountButton();
        // Open Login page
        loginPage.fillLogin(login);
        loginPage.fillPassword(password);
        loginPage.clickLoginButton();
        // Open user's Home page + verify that Martin Iger's home page successfully open
        parentHomePage.verifyParentNameIsDisplayed();
        // Logout from Home page
        parentHomePage.clickMenuButton();
        parentHomePage.clickLogoutButton();
        parentHomePage.verifyLogoutTitleIsDisplayed();
        parentHomePage.clickYesButton();

    }




}
