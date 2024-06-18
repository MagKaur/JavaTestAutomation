package com.KozminProject.pop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CheckoutPage {

        private WebDriver driver;

        public CheckoutPage(WebDriver driver){
            this.driver = driver;
            PageFactory.initElements(driver,this);
        }

        @FindBy(id = "billing_first_name")
        private WebElement firstName;
        @FindBy(id = "billing_last_name")
        private WebElement lastName;
        @FindBy(id = "billing_country")
        private WebElement billingCountry;
        @FindBy(id = "billing_address_1")
        private WebElement streetAddress;
        @FindBy(id = "billing_postcode")
        private WebElement postcode;
        @FindBy(id = "billing_city")
        private WebElement town;
        @FindBy(id = "billing_state")
        private WebElement state;
        @FindBy(id = "billing_phone")
        private WebElement phone;
        @FindBy(id = "billing_email")
        private WebElement email;
        @FindBy(id = "payment_method_cod")
        private WebElement paymentMethodCash;
        @FindBy(id = "place_order")
        private WebElement placeOrderButton;


        public void enterNameCheckout(String name) {
            firstName.clear();
            firstName.sendKeys(name);
        }
        public void enterSurnameCheckout(String surname) {
            lastName.clear();
            lastName.sendKeys(surname);
        }
        public void selectCountry(String countryName){
            Select select = new Select(billingCountry);
            select.selectByVisibleText(countryName);
        }

        public void enterAddressCheckout(String address) {
            streetAddress.clear();
            streetAddress.sendKeys(address);
        }

        public void enterTownCheckout(String townName){
            town.clear();
            town.sendKeys(townName);
        }

        public void enterPostCodeCheckout(String postCodeNumber){
            postcode.clear();
            postcode.sendKeys(postCodeNumber);
        }

        public void enterPhoneNumber(String number){
            phone.clear();
            phone.sendKeys(number);
        }

        public void enterEmailCheckout(String emailAdd){
            email.clear();
            email.sendKeys(emailAdd);
        }

        public void  clickPaymentMethod(){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            try{
                wait.until(ExpectedConditions.visibilityOf(paymentMethodCash));
                paymentMethodCash.click();
            } catch (Exception e){
                System.out.println("Chosen payment element didn't appear on a website");
                e.printStackTrace();
            }

        }

        public void clickPlaceOrder(){
            placeOrderButton.click();
        }


}
