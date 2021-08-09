package com.povio.pages;

import com.povio.helper.ConfigurationReader;
import com.povio.helper.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public BasePage()
    {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(linkText = "Home")
    public  WebElement home;
    @FindBy(linkText =  "Sign in")
    public WebElement signIn;
    @FindBy(linkText = "Sign up")
    public WebElement signUp;
    @FindBy(linkText = "Edit account")
    public WebElement editAccount;
    @FindBy(xpath = "(//input[@type='submit'])[2]")
    public WebElement cancelAacc;


}
