package com.KozminProject.pop;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


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
        return contactEmail.isDisplayed();
    }
    public String getContactEmailTxt(){
        return contactEmail.getText();
    }


    public boolean isSearchFieldPresent(){
        return searchField.isDisplayed();
    }

    public boolean isSearchButtonPresent(){
        return searchButton.isDisplayed();
    }
    public void clickSearchButton(){
        searchButton.click();
    }


    public boolean isAccountButtonPresent(){
        return accountButton.isDisplayed();
    }
    public void clickAccountButton(){
        accountButton.click();
    }



    public boolean isCartLinkIsPresent(){
        return cartLink.isDisplayed();
    }
    public void clickCartButton() {
        cartLink.click();
    }



}
