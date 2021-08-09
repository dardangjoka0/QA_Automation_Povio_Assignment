package com.povio.step_definiton;

import com.povio.helper.Driver;
import com.povio.pages.BasePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;

public class DeleteAcc {
    BasePage page=new BasePage();
    @When("user is on the Edit account page.")
    public void user_is_on_the_edit_account_page() {
       page.editAccount.click();
    }
    @When("navigates to the bottom")
    public void navigates_to_the_bottom() {

    }
    @When("clicks Cancel my account button")
    public void clicks_cancel_my_account_button() throws InterruptedException {
      page.cancelAacc.click();
      Thread.sleep(2000);
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
    }
    @Then("a succsess message should be displayed")
    public void a_succsess_message_should_be_displayed() {

    }
}
