package com.KozminProject;
import com.KozminProject.pop.AccountPage;
import com.KozminProject.pop.CartPage;
import com.KozminProject.utils.DriverSetup;
import com.KozminProject.pop.TopBar;
import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestProject extends DriverSetup {


    private TopBar topBar;
    private CartPage cartPage;
    private AccountPage accountPage;
    private static final String EMAIL  = "test.example.com";
    private static final String PASSWORD  = "astdELKJ823SDGll?!";

    @Test(alwaysRun = true)
    private void isContactFieldPresent() {
        driver.get("https://skleptest.pl/");
        topBar = new TopBar(driver);
        Assert.assertTrue(topBar.isContactEmailPresent());
    }

    @Test(alwaysRun = true)
    private void isEmailContactValueCorrect() {
        driver.get("https://skleptest.pl/");
        topBar = new TopBar(driver);
        String expectedContactValue = "skleptestarmy@gmail.com";
        String actualContactValue = topBar.getContactEmailTxt();
        Assert.assertEquals(actualContactValue, expectedContactValue, "Email is incorrect");
    }

    @Test(alwaysRun = true)
    private void isSearchFieldPresent() {
        driver.get("https://skleptest.pl/");
        topBar = new TopBar(driver);
        Assert.assertTrue(topBar.isSearchFieldPresent());
    }

    @Test(alwaysRun = true)
    private void isButtonSearchPresent() {
        driver.get("https://skleptest.pl/");
        topBar = new TopBar(driver);
        accountPage = new AccountPage(driver);
        Assert.assertTrue(topBar.isSearchButtonPresent());
    }

    private void isSearchResultPresent(){
        //TODO
    }



    @Test(alwaysRun = true)
    private void isAccountButtonPresent() {
        driver.get("https://skleptest.pl/");
        topBar = new TopBar(driver);
        Assert.assertTrue(topBar.isAccountButtonPresent());
    }
    @Test(alwaysRun = true)
    private void isAccountPageOpens() {
        driver.get("https://skleptest.pl/");
        topBar = new TopBar(driver);
        topBar.clickAccountButton();
        String expectedURL = "https://skleptest.pl/my-account/";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL, "Correct Login Page unavailble");
    }


    @Test(alwaysRun = true)
    public void verifyErrorRegisterMessage(){
        driver.get("https://skleptest.pl/");
        topBar = new TopBar(driver);
        accountPage = new AccountPage (driver);
        topBar.clickAccountButton();
        accountPage.enterEmailInRegisterField(EMAIL);
        accountPage.enterPassInRegisterField(PASSWORD);
        accountPage.clickRegButton();
        if(accountPage.isErrorMsgDisplayed()) {
            String expectedErrorText = "Error: Please provide a valid email address.";
            String actualErrorText = accountPage.getErrorMessage();
            Assert.assertEquals(actualErrorText, expectedErrorText, "Error message is incorrect");
        } else {
            Assert.fail("Error msg not displayed");
        }
    }

    @Test(alwaysRun = true)
    private void isCartButtonPresent(){
        driver.get("https://skleptest.pl/");
        topBar = new TopBar(driver);
        Assert.assertTrue(topBar.isCartLinkIsPresent());
    }
    @Test(alwaysRun = true)
    private void isCartPageOpens(){
        driver.get("https://skleptest.pl/");
        topBar = new TopBar(driver);
        topBar.clickCartButton();
        String expectedURL = "https://skleptest.pl/cart/";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL, "Correct Cart Page unavailble");
    }


    @Test(alwaysRun = true)
    private void isEmptyCartInfoCorrect() {
        driver.get("https://skleptest.pl/");
        topBar = new TopBar(driver);
        cartPage = new CartPage(driver);
        topBar.clickCartButton();
        if (cartPage.isEmptyCartMessageDisplayed()) {
            String expectedMsg = "Your cart is currently empty";
            String actualMsg = cartPage.getEmptyCartMsgTxt();
            Assert.assertEquals(actualMsg, expectedMsg, "Incorrect cart empty message");
        } else {
            Assert.fail("Empty cart msg not present on a cart page or cart is not empty");
        }
    }
}








