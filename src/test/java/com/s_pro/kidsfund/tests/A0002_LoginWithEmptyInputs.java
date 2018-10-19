package com.s_pro.kidsfund.tests;

import com.s_pro.kidsfund.pages.LandingPage;
import com.s_pro.kidsfund.pages.LoginPage;
import com.s_pro.kidsfund.pages.ParentHomePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class A0002_LoginWithEmptyInputs extends BaseTest {

    private final String login = "imartynenko@s-pro.io";
    private final String password = "Qwerty123$";
    private final By errorMessage = By.cssSelector("div.input-error-label.showError.sc-htpNat.bTlRna");

    @Test
    public void test() {
        driver.get(baseUrl);

        LoginPage loginPage = new LoginPage(driver);
        LandingPage landingPage = new LandingPage(driver);
        ParentHomePage parentHomePage = new ParentHomePage(driver);

        // Open Landing page
        landingPage.clickAlreadyHaveAccountButton();
        // Open Login page + try to login with empty fields
        loginPage.clickLoginButton();
        // Verify that error messages is displayed
        String actualEmailString = driver.findElements((errorMessage)).get(0).getText();
        Assert.assertTrue(actualEmailString.equals("Your email is required."), "Email error isn't displayed");
        String actualPasswordString = driver.findElements((errorMessage)).get(1).getText();
        Assert.assertTrue(actualPasswordString.equals("Your password is required."), "Password error isn't displayed");
        // Fill inputs with valid data
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
