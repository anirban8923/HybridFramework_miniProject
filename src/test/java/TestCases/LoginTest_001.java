package TestCases;

import PageObjects.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LoginTest_001 extends BaseClass
{

    @Test
    public void logintest() throws InterruptedException, IOException {


      logger.info("TC_001");
     logger.info("URL is opened");

        LoginPage lp=new LoginPage(driver);

        lp.setUserName(userName);
         logger.info("UserName is entered");

         lp.setPassword(password);
           logger.info("Password is entered");
       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

       lp.clickSubmit();
       logger.info("Submit Button is clicked");


       // System.out.println(driver.getTitle());
          if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
          {

              Assert.assertTrue(true);
              captureScreenShot(driver,"logintest");
              logger.info("Login Test passed");
              logger.info("The Title of the Page Assertion passed");
          }

          else {
              captureScreenShot(driver,"logintest");
              Assert.assertTrue(false);
              logger.info("Test Case failed");
          }

    }








}
