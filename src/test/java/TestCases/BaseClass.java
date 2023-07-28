package TestCases;

import Utilities.ReadConfig;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BaseClass
{

   /* public String baseUrl="https://demo.guru99.com/v4";
    public  String userName="mngr515069";
    public  String password="ypYnahe";*/

    ReadConfig readconfig=new ReadConfig();
    public  static WebDriver driver ;
    public    Logger logger;


    public String baseUrl= readconfig.getApplicationURL();
    public  String userName= readconfig.getUsername();
    public  String password= readconfig.getPassword();



@Parameters("browser")
@BeforeClass
public void setup(String br)
{
   // System.setProperty("webdriver.chrome.driver","C:\\Ani\\HybridFramework\\HybridFramework\\src\\test\\resources\\Drivers\\chromedriver.exe");
  //  System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//resources//Drivers//chromedriver.exe");./--current dir(proprties file plus java class)
    // System.setProperty("webdriver.chrome.driver",readconfig.getFirefoxPath());
    // driver=new FirefoxDriver();

    logger=Logger.getLogger("eBanking");
    PropertyConfigurator.configure("Log4j.properties");


            if(br.equals("chrome"))
            {
                System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
                driver = new ChromeDriver();
                logger.info("Using Chrome Driver");
            }
            else if (br.equals("firefox"))
            {
                System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
                 driver=new FirefoxDriver();
                logger.info("Using Firefox Driver");
            }


          /*  else if (br.equals("ie"))
            {
                System.setProperty("webdriver.ie.driver",readconfig.getIEPath());
                driver=new InternetExplorerDriver();
            }*/


                  else {
                System.out.println("Enter the correct browser");
                logger.info("Enter the correct Browser");
                       }

                  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

                  driver.get(baseUrl);
                  driver.manage().window().maximize();
}






@AfterClass
public void tearDown()
{
    driver.quit();
}

    public  void captureScreenShot(WebDriver driver,String tname) throws IOException
    {
        TakesScreenshot ts= (TakesScreenshot) driver;
        File source=ts.getScreenshotAs(OutputType.FILE);

        //String timeStamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());


       // File target= new File(System.getProperty("user.dir")+"./Reports/"+tname +".png");

        File target= new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
        FileUtils.copyFile(source,target);
        System.out.println("Screenshot Taken");
        logger.info("ScreenShot is captured");



    }


    public     String randomString()
    {
        String generatedString = RandomStringUtils.randomAlphabetic(8);
        return  generatedString ;
    }


    public    static String randomNumber()
    {
        String generatedNo =RandomStringUtils.randomNumeric(8);
        return  generatedNo ;
    }



}
