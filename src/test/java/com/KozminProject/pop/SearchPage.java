package com.KozminProject.pop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage {

    private WebDriver driver;

    @FindAll({
            @FindBy(css = "main#main .tyche-blog-post")
    })
    private List<WebElement> resultlist;



    public SearchPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public int countResults(){
        return resultlist.size();
    }

    //TODO locators and methods for searched list
}
