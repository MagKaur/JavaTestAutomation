package com.KozminProject.pop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderConfirmPage {

    private WebDriver driver;

    public OrderConfirmPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "h2.woocommerce-order-details__title" )
    private WebElement orderConfText;

    public boolean ifConfirmOrderElementDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try{
            wait.until(ExpectedConditions.visibilityOf(orderConfText));
            return orderConfText.isDisplayed();
        } catch (Exception e){

            return false;
        }

    }

    public String OrderConfGetTxt(){
        return orderConfText.getText();
    }
}
