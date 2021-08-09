package com.povio.pages;

import com.povio.helper.ConfigurationReader;
import com.povio.helper.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignIn extends BasePage {
    private String endpoint= ConfigurationReader.get("url")+"/users/sign_in";
    public SignIn()
    {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id="user_email")
    WebElement email;
    @FindBy(id="user_password")
    WebElement password;

    @FindBy(id="user_remember_me")
    WebElement rememberMe;
    @FindBy(name = "commit")
    WebElement signInButton;

    public void signMeIN(String user, String password, boolean rememberMe)  {


        email.sendKeys(user);
        this.password.sendKeys(password);
        if(rememberMe)
            if(this.rememberMe.isSelected())
                return;
            else
                this.rememberMe.click();
            this.signInButton.click();
    }
    public void signMeIN(String user, String password)
    {

        email.sendKeys(user);
        this.password.sendKeys(password);
        this.signInButton.click();

    }

}
