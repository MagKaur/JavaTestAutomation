package com.KozminProject.pop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    private WebDriver driver;

    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "cart-empty")
    private WebElement emptyCartMsg;

    public boolean isCartEmptyMessageDisplayed() {
        return emptyCartMsg.isDisplayed();
    }

    public String getEmptyCartMsgTxt(){
        return emptyCartMsg.getText();
    }
}
