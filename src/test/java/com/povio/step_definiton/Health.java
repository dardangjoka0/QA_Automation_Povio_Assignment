package com.povio.step_definiton;

import com.povio.helper.ConfigurationReader;
import com.povio.helper.Driver;
import com.povio.pages.BasePage;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;


public class Health {
    BasePage bp=new BasePage();
    @When("user goes to main page")
    public void user_goes_to_main_page() {
        Driver.getDriver().get(ConfigurationReader.get("url"));
//        Response rs= RestAssured.get(ConfigurationReader.get("url"));
//        rs.statusCode()


    }
    @When("the user is on the signup page.")
    public void the_user_is_on_the_signup_page() {
       bp.signUp.click();
    }
}
