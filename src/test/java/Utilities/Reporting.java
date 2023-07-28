

/*
package Utilities;


import TestCases.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

//Listener Class used to generate Extent Report

public class Reporting extends TestListenerAdapter
{

     public ExtentHtmlReporter htmlreporter ;

    public ExtentReports extent ; //used for creating tests
    public ExtentTest logger ;  //generating logs

    BaseClass bs=new BaseClass();

    public void onStart(ITestContext testContext)
    {


       String timeStamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String repName="Test-Report-"+timeStamp+".html";
        htmlreporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repName);
        htmlreporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");




        extent=new ExtentReports();

        extent.attachReporter(htmlreporter);
        extent.setSystemInfo("Host Name","Local Host");
        extent.setSystemInfo("Environment","QA");
        extent.setSystemInfo("user","Ani");

        htmlreporter.config().setDocumentTitle("Banking Test Project"); //Title of the Report
        htmlreporter.config().setReportName("Functional Test report");   // Name of the Report
         htmlreporter.config().setTestViewChartLocation(ChartLocation.TOP); //Location of the chart
        htmlreporter.config().setTheme(Theme.DARK);
        bs.logger.info("onStart method");
    }


    public void onTestSuccess(ITestResult tr)
    {
        logger=extent.createTest(tr.getName()); //create new entry in the report
        logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN)); // send the passed information
        bs.logger.info("onTestSuccess method");
    }

    public void onTestFailure(ITestResult tr)
    {
        logger=extent.createTest(tr.getName()); //create new entry in the report
        logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED)); // send the passed information

        bs.logger.info("onTestFailure method");
        String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
        File f=new File(screenshotPath);


        if(f.exists())
        {
            try {
                logger.fail("Screenshot is below" +logger.addScreenCaptureFromPath(screenshotPath));
            } catch (IOException e) {
                System.out.println("Exception " +e);
                      e.printStackTrace();

            }
        }

    }


    public void onTestSkipped(ITestResult tr)
    {
        logger=extent.createTest(tr.getName()); //create new entry in the report
        logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
        bs.logger.info("onTestSkipped method");

    }

    public void onFinish(ITestContext testContext)
    {

        bs.logger.info("onFinish method");
        extent.flush();

    }

}




*/

/////////////////////////////////






package Utilities;



import TestCases.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

//Listener Class used to generate Extent Report

public class Reporting extends TestListenerAdapter
{


    public ExtentReports extentReports ; //used for creating tests
    public ExtentSparkReporter spark ;  //extenthtmlreporter
    public  ExtentTest test; // for log purpose


       BaseClass bs=new BaseClass();




    public void onStart(ITestContext testContext)
    {

        bs.logger=Logger.getLogger("eBanking");
        PropertyConfigurator.configure("Log4j.properties");

        String timeStamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String repName="Test-Report-"+timeStamp+".html";

       // spark= new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/"+repName);
        spark= new ExtentSparkReporter(System.getProperty("user.dir")+"./Reports/"+repName);
        try {
            spark.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        extentReports = new ExtentReports();
        extentReports.attachReporter(spark);


        extentReports.setSystemInfo("Host Name","Anirban");
        extentReports.setSystemInfo("Environment","QA");
        extentReports.setSystemInfo("user","Ani");

        spark.config().setDocumentTitle("Banking Mini Test Project");//Title of the Report
        spark.config().setReportName("Functional Test report");   // Name of the Report
        spark.config().setTheme(Theme.DARK);

         bs.logger.info("onStart method");

    }


    public void onTestSuccess(ITestResult tr) {

        System.out.println("on success");
        test = extentReports.createTest(tr.getName()); //create new entry in the report
        test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN)); // send the passed information

        bs.logger.info("onTestSuccess method");


 String screenshotPath = (System.getProperty("user.dir") + "\\Screenshots\\" + tr.getName() + ".png");
        File f = new File(screenshotPath);

        if (f.exists()) {

            test.pass("Screenshot is above" + test.addScreenCaptureFromPath(screenshotPath));
            bs.logger.info("ScreenShot taken on Successfull of Test Case and attatched to Extent Report");

        }
        else{
            bs.logger.info("Screenshot does not exists");
        }

    }

    public void onTestFailure(ITestResult tr)
    {
        test=extentReports.createTest(tr.getName()); //create new entry in the report
        test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED)); // send the passed information
        bs.logger.info("onTestFailure method");

        System.out.println("Test name " +tr.getName());

        String screenshotPath= (System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png");
       // String screenshotPath= "C:\\Ani\\HybridFramework\\HybridFramework\\Screenshots\\" +tr.getName()+".png";

        File f=new File(screenshotPath);



            if (f.exists()) {
                test.fail("Screenshot is above" + test.addScreenCaptureFromPath(screenshotPath));
                bs.logger.info("Screenshot taken on test case failure and attatched to extent report");

            }
            else {
                bs.logger.info("Screenshot file does not exists");
            }


    }


    public void onTestSkipped(ITestResult tr)
    {
        test=extentReports.createTest(tr.getName()); //create new entry in the report
        test.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
         bs.logger.info("onTestSkipped method");

/*
        String screenshotPath= (System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png");
         File f=new File(screenshotPath);



        if (f.exists()) {
            test.fail("Screenshot is above" + test.addScreenCaptureFromPath(screenshotPath));
            bs.logger.info("Screenshot taken on test case failure and attatched to extent report");

        }
        else {
            bs.logger.info("Screenshot file does not exists");
        }*/




    }

    public void onFinish(ITestContext testContext)
    {
        bs.logger.info("onFinish method");
        extentReports.flush();

    }

}

