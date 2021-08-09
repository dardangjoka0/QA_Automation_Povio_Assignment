package com.povio.step_definiton;

import com.povio.helper.ConfigurationReader;
import com.povio.helper.Driver;
import com.povio.pages.BasePage;
import com.povio.pages.Campaigns;
import com.povio.pages.SignIn;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Random;

public class CampaignStepDef {

   BasePage basePage=new BasePage();
   Campaigns cp=new Campaigns();
   String name,description, type;
   int randomNumber;

    @Given("the user is already logedin and on the Campaign page.")
    public void the_user_is_already_logedin_and_on_the_campaign_page() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.get("url"));
        Thread.sleep(2000);
        basePage.signIn.click();

        SignIn sn=new SignIn();
        sn.signMeIN(ConfigurationReader.get("email"),ConfigurationReader.get("password"));
        Thread.sleep(2000);
        basePage.campaign.click();
    }
    @When("the user clicks Add New Campaign button")
    public void the_user_clicks_add_new_campaign_button() {
       cp.addNewCampaignButton.click();
    }
    @Then("user should be sent into a new page")
    public void user_should_be_sent_into_a_new_page() {
       // Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("new"));
    }
    @Then("in the name input box user can put {string} of campaign")
    public void in_the_name_input_box_user_can_put_of_campaign(String name) {
        this.name=name;
    }
    @Then("in the description input {string} of campaign")
    public void in_the_description_input_of_campaign(String description) {
     this.description=description;
    }
    @Then("select the type {string}")
    public void select_the_type(String type) {
     this.type=type;
    }
    @Then("click create campaign")
    public void click_create_campaign() {
    cp.addNewCampaign(name, description,type);
    }
    @Then("a new campaign should be created")
    public void a_new_campaign_should_be_created() {
        Assert.assertEquals("Campaign was successfully created.", basePage.flag.getText());

    }
        /*
        EDIT CAMPAIGN
            |
            |
            |
            V
         */


    @When("User Selects a random Campaign")
    public void user_selects_a_random_campaign() throws Exception {
        Random random=new Random();
        if(cp.edit.size()==0 || cp.edit.size()==1)
            throw new Exception("You need to add a campaign first before you edit it");
       randomNumber=random.nextInt(cp.edit.size());
       if(randomNumber==0)
           randomNumber++;
    }
    @When("clicks on the edit button")
    public void clicks_on_the_edit_button() {
       cp.edit.get(randomNumber).click();
    }
    @Then("the edit page should appear")
    public void the_edit_page_should_appear() {
        //Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("edit"));
    }
    @Then("he can edit the colums with the values {string},{string}, {string}")
    public void he_can_edit_the_colums_with_the_values(String nam, String desc, String typ) throws InterruptedException {
        nam+=randomNumber;
        desc+=randomNumber;
        cp.editCampaign(nam,desc,typ);
        Thread.sleep(2000);
    }

    @Then("click the update button")
    public void click_the_update_button() {

    }
    @Then("a succsess message should appear")
    public void a_succsess_message_should_appear() {
       Assert.assertEquals("Campaign was successfully updated.", basePage.flag.getText());
    }

}
