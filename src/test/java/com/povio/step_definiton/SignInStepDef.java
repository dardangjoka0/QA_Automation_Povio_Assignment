package com.povio.step_definiton;

import com.povio.helper.ConfigurationReader;
import com.povio.helper.Driver;
import com.povio.pages.BasePage;
import com.povio.pages.SignIn;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SignInStepDef {
    BasePage page =new BasePage();
    @Given("the user is on the sign in page")
    public void the_user_is_on_the_sign_in_page() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        Driver.getDriver().get(ConfigurationReader.get("url"));
        Thread.sleep(2000);
        page.signIn.click();
    }
    @When("user enters {string} as an email, {string} as a password")
    public void user_enters_as_an_email_as_a_password(String string, String string2) throws InterruptedException {
        Thread.sleep(2000);
      SignIn signIn=new SignIn();
      signIn.signMeIN(string,string2);
    }
    @When("clicks on the sign in button")
    public void clicks_on_the_sign_in_button() {
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
    }
    @Then("the user should be logged in")
    public void the_user_should_be_logged_in() {
        Assert.assertEquals("Signed in successfully.",page.flag.getText() );
    }

}
