package com.KozminProject.pop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "a.ajax_add_to_cart.add_to_cart_button.button.primary")
    private WebElement blackTop35pln;


    public void clickBlackTop35pln(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try{
            wait.until(ExpectedConditions.visibilityOf(blackTop35pln));
            blackTop35pln.click();
            wait.withTimeout(Duration.ofSeconds(5)).until((WebDriver d) -> false);//musiałam dodać tego wait. Po zbyt szybkim przejsciu do koszyka, towar nie zdąża się tam przekazać,
            //nawet jeśli poczekam na jego pojawienie się po otwarciu koszyka zgodnie z webdriver wait z metody "isCartIsFull"
            //(niezależnie od długości oczekiwania w koszyku, towar się tam nie pokazuje. Niezbędne więc było zabezpieczenie odczekania
            //paru sekund po kliknięciu w add to cart, aby zdążył się tam przekazać.
        } catch (Exception e){
            System.out.println("Chosen element didn't appear on a website");
            e.printStackTrace();
        }
    }


}
