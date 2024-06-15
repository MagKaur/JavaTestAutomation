package com.KozminProject.pop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    private WebDriver driver;

    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "cart-empty")
    private WebElement emptyCartMsg;

    @FindBy(css = "form.woocommerce-cart-form")
    private WebElement productsInCartIndication;

    public boolean isCartFull(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try{
            wait.until(ExpectedConditions.visibilityOf(productsInCartIndication));
            return productsInCartIndication.isDisplayed();
        } catch (Exception e){
            return false;
        }
    }
    public boolean isEmptyCartMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            wait.until(ExpectedConditions.visibilityOf(emptyCartMsg));
            return emptyCartMsg.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getEmptyCartMsgTxt(){
        return emptyCartMsg.getText();
    }
}
