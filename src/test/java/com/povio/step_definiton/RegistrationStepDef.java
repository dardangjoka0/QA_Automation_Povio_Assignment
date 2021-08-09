package com.povio.step_definiton;

import com.povio.helper.ConfigurationReader;
import com.povio.helper.Driver;
import com.povio.pages.BasePage;
import com.povio.pages.Register;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.Random;

public class RegistrationStepDef {
    BasePage page=new BasePage();
    String name, email, password;
    @Given("the user is on the signup page")
    public void the_user_is_on_the_signup_page() {
        Driver.getDriver().get(ConfigurationReader.get("url"));
        page.signUp.click();
    }
    @When("user inputs {string} into the name input")
    public void user_inputs_into_the_name_input(String name) {
        // Write code here that turns the phrase above into concrete actions
        this.name=name;
    }
    @When("a valid email {string} that will be randomly changed")
    public void a_valid_email_that_will_be_randomly_changed(String email) {
        // Write code here that turns the phrase above into concrete actions
        this.email=email;
    }
    @When("password {string} into the approprate inputs")
    public void password_into_the_approprate_inputs(String password) {
        this.password=password;
    }
    @When("cllicks Sign up")
    public void cllicks_sign_up() throws InterruptedException {
        Register register=new Register();
        Random random=new Random();
        String passi=password+random.nextInt(100);
        String na=name+random.nextInt(100);
        String emai=email+random.nextInt(100);
        register.createUser(na, emai,passi);
        Thread.sleep(5000);
    }
    @Then("a new user should be created")
    public void a_new_user_should_be_created() {
        Assert.assertEquals("Welcome! You have signed up successfully.", page.flag.getText());
    }

    @When("User enters already existing email, despide of other fields")
    public void user_enters_already_existing_email_despide_of_other_fields() {
        Register register=new Register();
        register.createUser("name", ConfigurationReader.get("email"), "pwd123123");
    }
    @Then("he should not be able to sign up and an error message should display.")
    public void he_should_not_be_able_to_sign_up_and_an_error_message_should_display() {
      Assert.assertEquals("Email has already been taken", Driver.getDriver().findElement(By.xpath("//*[@id='error_explanation']//li")).getText());
    }


}
