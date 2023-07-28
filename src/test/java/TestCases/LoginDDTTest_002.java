package TestCases;

import PageObjects.LoginPage;
import Utilities.XLUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoginDDTTest_002 extends BaseClass
{


    @Test(dataProvider ="LoginData" )
    public  void loginDDT(String user, String pwd) throws InterruptedException, IOException {
        LoginPage lp= new LoginPage(driver);
        lp.setUserName(user);
        logger.info("user name provided ");
        lp.setPassword(pwd);
        logger.info("password provided ");
        lp.clickSubmit();
        logger.info("submit button is clicked ");

        Thread.sleep(3000);

        if(isAlertPresent()==true) {

            // means login fails as alert comes if logins data is in correct
            driver.switchTo().alert().accept();// close alert
            driver.switchTo().defaultContent();// go to main page
            Assert.assertTrue(false);

            //captureScreenShot(driver,"loginDDT");


            TakesScreenshot ts= (TakesScreenshot) driver;
            File source1=ts.getScreenshotAs(OutputType.FILE);
            String timeStamp1= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

            File target= new File(System.getProperty("user.dir")+"/Screenshots/"+timeStamp1+".png");
            FileUtils.copyFile(source1,target);

            logger.warn(" login failed ");

        }
        else {
            // login passed
            Assert.assertTrue(true);
            //captureScreenShot(driver,"loginDDT");

            TakesScreenshot ts= (TakesScreenshot) driver;
            File source1=ts.getScreenshotAs(OutputType.FILE);
            String timeStamp1= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

            File target= new File(System.getProperty("user.dir")+"/Screenshots/"+timeStamp1+".png");
            FileUtils.copyFile(source1,target);
            logger.info(" login passed");
            // redirected to home page
            //click on logout button (put page object of logout button )
            //go to the login page again
              lp.clickLogout();
            Thread.sleep(3000);

            driver.switchTo().alert().accept();// close the logout alert
            driver.switchTo().defaultContent();

        }




    }


    public  boolean isAlertPresent() // user defined method to check alert is present or not
    {
        try {
            driver.switchTo().alert();
            return  true;
        }
           catch (NoAlertPresentException e)
           {
                return false ;
           }
    }




       @DataProvider(name="LoginData")
      public Object[][] getData() throws IOException {
          String path="C:\\Ani\\HybridFramework\\HybridFramework\\src\\test\\java\\TestData\\LoginData.xlsx";
         //  String path=System.getProperty("user.dir")+"/src/test/java/TestData/LoginData.xlsx";

           int rownum= XLUtils.getRowCount(path,"Sheet1");
           int cocount=XLUtils.getCellCount(path,"Sheet1",1);


           Object logindata[][]=new Object[rownum][cocount];

           for(int i=1;i<=rownum;i++)
           {
               for(int j=0;j<cocount;j++)
               {
                   logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1",i,j); // 1,0(actual excel file) to 0,0(2D array)

               }
           }
                     return logindata ;


       }








}
