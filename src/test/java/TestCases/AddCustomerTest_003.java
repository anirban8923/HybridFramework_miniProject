package TestCases;

import PageObjects.AddCustomerPage;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddCustomerTest_003 extends BaseClass


{

      @Test
    public void addNewCustomer() throws InterruptedException, IOException {

          logger.info("Test Case Name " +getClass());
    LoginPage lp=new LoginPage(driver);
    lp.setUserName(userName);
    logger.info("Username entered");
    lp.setPassword(password);
    logger.info("Password entered");
    lp.clickSubmit();
    logger.info("Submit button is clicked");

    Thread.sleep(3000);


          AddCustomerPage addcust=new AddCustomerPage(driver);

         

          addcust.clickAddNew();
          Thread.sleep(3000);

          logger.info("Adding New Customer");

          logger.info("Providing customer details");
          addcust.custName("Andy");
          addcust.custGender("male");
          addcust.custdob("2","15","1980");
          Thread.sleep(3000);
          addcust.custaddress("India");
          addcust.custcity("Noida");
          addcust.custstate("Uttar Pradesh");
          addcust.custpinno("540012");
          addcust.custtelephoneno("1234567892");


             String email=randomString()+"@gmail.com" ;
             addcust.custemailid(email);


            addcust.custpassword("qwerty@789");



            Thread.sleep(3000);
            addcust.custsubmit();

            Thread.sleep(3000);

            logger.info("validation started .....!!!");
            boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");

            if(res==true)
            {
                logger.info("test case success ");
                Assert.assertTrue(true);
                captureScreenShot(driver,"addNewCustomer");


            }

            else {
                captureScreenShot(driver,"addNewCustomer");
                logger.info("test case failed ");
                Assert.assertTrue(false);
            }

}




}
