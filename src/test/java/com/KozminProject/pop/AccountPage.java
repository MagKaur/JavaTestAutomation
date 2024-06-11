package com.KozminProject.pop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountPage {

    private WebDriver driver;


    public AccountPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "reg_email")
    private WebElement emailRegisterField;

    @FindBy(id = "reg_password")
    private WebElement passRegisterField;

    @FindBy(className = "register")
    private WebElement registerButton;

    @FindBy(css = "ul.woocommerce-error li")
    private WebElement errorMessage;


   public boolean isEmailRegisterFieldPresent(){
        return emailRegisterField.isDisplayed();
    }
   public boolean isPassRegisterFieldPresent(){
        return passRegisterField.isDisplayed();
    }
    public boolean isRegisterButtonPresent(){
        return registerButton.isDisplayed();
    }
    public void clickRegButton(){
        registerButton.click();
    }

    public void enterEmailInRegisterField(String EMAIL) {
        emailRegisterField.clear(); // Wyczyszczenie pola przed wprowadzeniem tekstu
        emailRegisterField.sendKeys(EMAIL);
    }

    public void enterPassInRegisterField(String PASSWORD) {
        passRegisterField.clear();
        passRegisterField.sendKeys(PASSWORD);
    }

    public boolean isErrorMsgDisplayed(){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            try {
                wait.until(ExpectedConditions.visibilityOf(errorMessage));
                return errorMessage.isDisplayed();
            } catch (Exception e) {
                return false;
            }
        }


    public String getErrorMessage() {
        return errorMessage.getText();
    }

    //TODO insert pwassword and email methods
    //TODO selector, methods for failed account register.
}
