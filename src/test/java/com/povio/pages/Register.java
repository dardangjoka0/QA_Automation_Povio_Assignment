package com.povio.pages;

import com.povio.helper.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Register {
    public Register(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(css="input[type='text']")
    public WebElement nameInput;
    @FindBy(css = "input[type='email']")
    public WebElement emailInput;
    @FindBy(xpath="(//input[@type='password'])[1]")
    public WebElement passwordInput;
    @FindBy(xpath = "(//input[@type='password'])[2]")
    public WebElement passwordConfirmInput;
    @FindBy(css="input[type='submit']")
    public WebElement signUp;


    public void createUser(String name, String email, String password){
        nameInput.sendKeys(name);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        passwordConfirmInput.sendKeys(password);
        signUp.click();
    }

}
