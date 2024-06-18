package com.KozminProject;

import com.KozminProject.pop.*;

import com.KozminProject.utils.DriverSetup;

import org.testng.Assert;
import org.testng.annotations.Test;


public class TestProject extends DriverSetup {


    private TopBar topBar;
    private CartPage cartPage;
    private AccountPage accountPage;
    private SearchPage searchPage;
    private HomePage homePage;
    private CheckoutPage checkoutPage;
    private OrderConfirmPage orderConfirmPage;
    private static final String EMAIL = "test.example.com";
    private static final String PASSWORD = "astdELKJ823SDGll?!";
    private String validSearchQuery = "fabric";
    private String invalidSearchQuery = "a";
    private String name = "Monkey";
    private String surname = "M";
    private String countryName = "Poland";
    private String adrress = "Crows 123";
    private String townName = "Honolulu";
    private String stateName = "Nebraska";
    private String postCodeNumbers = "02567";
    private String number = "5679879000";
    private String emailAdd = "testmktest1@gmail.com";

    /***
     * TC1: Sprawdzenie obecności pola kontakt
     ***/
    @Test(alwaysRun = true)
    private void isContactFieldPresent() {
        driver.get("https://skleptest.pl/");
        topBar = new TopBar(driver);
        Assert.assertTrue(topBar.isContactEmailPresent(), "Expected: Contact field present in top bar");
    }

    /***
     * TC2: Sprawdzenie poprawności adresu email w polu kontakt
     ***/
    @Test(alwaysRun = true)
    private void isEmailContactValueCorrect() {
        driver.get("https://skleptest.pl/");
        topBar = new TopBar(driver);
        String expectedContactValue = "skleptestarmy@gmail.com";
        String actualContactValue = topBar.getContactEmailTxt();
        Assert.assertEquals(actualContactValue, expectedContactValue, "Email in Contact field incorrect");
    }

    /***
     * TC3: Sprawdzenie obecności pola wyszukiwania
     ***/
    @Test(alwaysRun = true)
    private void isSearchFieldPresent() {
        driver.get("https://skleptest.pl/");
        topBar = new TopBar(driver);
        Assert.assertTrue(topBar.isSearchFieldPresent(), "Expected: Search field present in top bar");
    }

    /***
     * TC4: Sprawdzenie obecności przycisku wyszukiwania
     ***/
    @Test(alwaysRun = true)
    private void isSearchMagnifierPresent() {
        driver.get("https://skleptest.pl/");
        topBar = new TopBar(driver);
        accountPage = new AccountPage(driver);
        Assert.assertTrue(topBar.isSearchButtonPresent(), "Expected: Search magnifier present in top bar");
    }

    /***
     * TC5: Sprawdzenie ilości wyników wyszukiwania
     ***/
    @Test(alwaysRun = true)
    private void howManySearchResultsPresent() {
        driver.get("https://skleptest.pl/");
        topBar = new TopBar(driver);
        searchPage = new SearchPage(driver);
        topBar.insertSearchQuery(validSearchQuery);
        topBar.clickSearchButton();
        int expectedCount = 10;
        int actualCount = searchPage.countResults();
        Assert.assertEquals(actualCount, expectedCount, "Search count not equal to data base result count");
    }

    /***
     * TC6: Weryfikacja wyników niepoprawnego zapytania wyszukiwania
     ***/
    @Test(alwaysRun = true)
    private void verifyInvalidSearchQuery() {
        driver.get("https://skleptest.pl/");
        topBar = new TopBar(driver);
        searchPage = new SearchPage(driver);
        topBar.insertSearchQuery(invalidSearchQuery);
        topBar.clickSearchButton();
        int actualCount = searchPage.countResults();
        Assert.assertEquals(actualCount, 0, "Expected no search results");
    }

    /***
     * TC7: Sprawdzenie obecności przycisku „Account” (konto)
     ***/
    @Test(alwaysRun = true)
    private void isAccountButtonPresent() {
        driver.get("https://skleptest.pl/");
        topBar = new TopBar(driver);
        Assert.assertTrue(topBar.isAccountButtonPresent(), "Expected: Account button present in top bar");
    }

    /***
     * TC8: Sprawdzenie poprawności otwieranej strony „AccountPage” (konta)
     ***/
    @Test(alwaysRun = true)
    private void isCorrectAccountPageOpens() {
        driver.get("https://skleptest.pl/");
        topBar = new TopBar(driver);
        topBar.clickAccountButton();
        String expectedURL = "https://skleptest.pl/my-account/";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL, "Expected: correct Account page url");
    }

    /***
     * TC9: Sprawdzenie wyświetlania błędu przy próbie rejestracji z błędnym adresem email
     ***/
    @Test(alwaysRun = true)
    public void verifyErrorRegisterMessage() {
        driver.get("https://skleptest.pl/");
        topBar = new TopBar(driver);
        accountPage = new AccountPage(driver);
        topBar.clickAccountButton();
        if (!accountPage.isUserIsLoggedIn()) {
            accountPage.enterEmailInRegisterField(EMAIL);
            accountPage.enterPassInRegisterField(PASSWORD);
            accountPage.clickRegButton();
            if (accountPage.isErrorMsgDisplayed()) {
                String expectedErrorText = "Error: Please provide a valid email address.";
                String actualErrorText = accountPage.getErrorMessage();
                Assert.assertEquals(actualErrorText, expectedErrorText, "Error message incorrect");
            } else {
                Assert.fail("Error msg: Please provide a valid email address is not displayed");
            }
        } else {
            Assert.fail("User logged in");
        }
    }

    /***
     * TC10: Sprawdzenie obecności przycisku „Cart” (koszyk)
     ***/
    @Test(alwaysRun = true)
    private void isCartButtonPresent() {
        driver.get("https://skleptest.pl/");
        topBar = new TopBar(driver);
        Assert.assertTrue(topBar.isCartLinkIsPresent(), "Expected: Cart button present in top bar");
    }


    /***
     * TC11: Sprawdzenie poprawności otwierania strony „CartPage” (kosz)
     ***/
    @Test(alwaysRun = true)
    private void isCorrectCartPageOpens() {
        driver.get("https://skleptest.pl/");
        topBar = new TopBar(driver);
        topBar.clickCartButton();
        String expectedURL = "https://skleptest.pl/cart/";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL, "Expected: correct Cart Page url");
    }

    /***
     * TC12: Sprawdzenie wyświetlania informacji o pustym koszyku
     ***/
    @Test(alwaysRun = true)
    private void isEmptyCartInfoCorrect() {
        driver.get("https://skleptest.pl/");
        topBar = new TopBar(driver);
        cartPage = new CartPage(driver);
        topBar.clickCartButton();
        if (!cartPage.isCartFull()) {
            if (cartPage.isEmptyCartMessageDisplayed()) {
                String expectedMsg = "Your cart is currently empty";
                String actualMsg = cartPage.getEmptyCartMsgTxt();
                Assert.assertEquals(actualMsg, expectedMsg, "Incorrect cart empty message");
            } else {
                Assert.fail("Expected: Empty cart msg displayed");
            }
        } else {
            Assert.fail("Cart is not empty");
        }
    }


    @Test(alwaysRun = true)
    public void e2eBuyTC() {
        driver.get("https://skleptest.pl/");
        topBar = new TopBar(driver);
        cartPage = new CartPage(driver);
        homePage = new HomePage(driver);
        checkoutPage = new CheckoutPage(driver);
        orderConfirmPage = new OrderConfirmPage(driver);
        homePage.clickBlackTop35pln();
        topBar.clickCartButton();
        if (cartPage.isCartFull()) {
            cartPage.clickProceedToCheckout();
            checkoutPage.enterNameCheckout(name);
            checkoutPage.enterSurnameCheckout(surname);
            checkoutPage.selectCountry(countryName);
            checkoutPage.enterAddressCheckout(adrress);
            checkoutPage.enterTownCheckout(townName);
            checkoutPage.enterPostCodeCheckout(postCodeNumbers);
            checkoutPage.enterPhoneNumber(number);
            checkoutPage.enterEmailCheckout(emailAdd);
            checkoutPage.clickPaymentMethod();
            checkoutPage.clickPlaceOrder();
            if(orderConfirmPage.ifConfirmOrderElementDisplayed()){
                String expectedTxt = "Order details";
                String actualTxt = orderConfirmPage.OrderConfGetTxt();
                Assert.assertEquals(actualTxt, expectedTxt, "Order Confirmation String is incorrect");
            }else {
                Assert.fail("Confirmation order unavailble");
            }
        } else {
            Assert.fail("Cart is empty");
        }
    }

}







