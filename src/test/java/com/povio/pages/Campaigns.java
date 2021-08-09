package com.povio.pages;

import com.povio.helper.ConfigurationReader;
import com.povio.helper.Driver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Campaigns {


    private String endpoint= "/campaigns/new";
    public Campaigns(){
        PageFactory.initElements(Driver.getDriver(), this);
        //Driver.getDriver().get("url"+endpoint);
    }

    @FindBy(css = ".container>a")
    public WebElement addNewCampaignButton;
    @FindBy(name = "campaign[name]")
    public WebElement nameInput;
    @FindBy(name = "campaign[description]")
    public WebElement descriptionInput;
    @FindBy(css = "input[type='radio']")
    public List<WebElement> radioB;
    @FindBy(css = "input[type='submit']")
    WebElement createButton;
    @FindBy(xpath = "//tbody//a[contains(text(), 'Edit')]")
    public List<WebElement> edit;
    private static int count=1;
    private int id;
    @FindBy(xpath = "//tbody//a[contains(text(), 'Destroy')]")
    public List<WebElement> destroy;
    @FindBy(id = "flash_notice")
    WebElement flag;

    public void addNewCampaign(String name, String description, String campaingType){
       //addNewCampaignButton.click();


            nameInput.sendKeys(name);
            descriptionInput.sendKeys(description);
            if(campaingType.contains("O"))
                radioB.get(0).click();
            else
                radioB.get(1).click();

            createButton.click();
          count++;
          id=count;





    }
    public void editCampaign( String name, String description, String type){
//        String xpath="("+"//tbody//a[contains(text(), 'Edit')]"+")["+id+"]";
         // edit.get(id).click();
         nameInput.sendKeys(name);
         descriptionInput.sendKeys(description);
        if(type.contains("One time"))
            radioB.get(0).click();
        else
            radioB.get(1).click();
        createButton.click();


    }
    public void deleteCapmpaign(int id){
        destroy.get(id).click();
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
    }

}
