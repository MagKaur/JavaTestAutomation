package com.KozminProject.pop;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class TopBar {


    private WebDriver driver;

    public TopBar(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "a[href='#']")
    private WebElement contactEmail;

    @FindBy(className = "search-field-top-bar")
    private WebElement searchField;

    @FindBy(id = "search-top-bar-submit")
    private WebElement searchButton;

    @FindBy(css = "a[href='https://skleptest.pl/my-account/']")
    private WebElement accountButton;
    @FindBy(css = "a[href='https://skleptest.pl/cart/']")
    private WebElement cartLink;


    public boolean isContactEmailPresent(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            wait.until(ExpectedConditions.visibilityOf(contactEmail));
            return contactEmail.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getContactEmailTxt(){
        return contactEmail.getText();
    }


    public boolean isSearchFieldPresent() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            wait.until(ExpectedConditions.visibilityOf(searchField));
            return searchField.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isSearchButtonPresent () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            wait.until(ExpectedConditions.visibilityOf(searchButton));
            return searchButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void insertSearchQuery(String searchQuery){
            searchField.clear();
            searchField.sendKeys(searchQuery);
    }

    public void clickSearchButton () {
        searchButton.click();
    }


    public boolean isAccountButtonPresent () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            wait.until(ExpectedConditions.visibilityOf(accountButton));
            return accountButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public void clickAccountButton () {
        accountButton.click();
    }


    public boolean isCartLinkIsPresent () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            wait.until(ExpectedConditions.visibilityOf(cartLink));
            return cartLink.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public void clickCartButton () {
        cartLink.click();
    }



}
