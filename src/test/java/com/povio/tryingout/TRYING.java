package com.povio.tryingout;

import com.povio.helper.ConfigurationReader;
import com.povio.helper.Driver;
import com.povio.pages.BasePage;
import com.povio.pages.Campaigns;
import com.povio.pages.SignIn;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TRYING {
    @BeforeMethod
    public void startup(){
      //  Driver.getDriver().get(ConfigurationReader.get("url"));
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
    @Test
    public void test1() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.get("url"));
        BasePage page=new BasePage();
        page.signIn.click();
        Thread.sleep(2000);
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}

