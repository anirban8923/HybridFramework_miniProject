package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig
{

Properties pro ;
// Loading property file from config.properties
    public ReadConfig()
    {
        File src=new File("C:\\Ani\\HybridFramework\\HybridFramework\\src\\test\\java\\Configuration\\config.properties");

           try
           {
               FileInputStream fis=new FileInputStream(src);
               pro=new Properties();
               pro.load(fis);


        } catch (Exception ex) {
               System.out.println("Exception is " +ex.getMessage());
           }

    }

          public  String getApplicationURL()
         {
         String url=pro.getProperty("baseUrl");
         return  url ;
         }



          public  String getUsername()
        {
        String username=pro.getProperty("userName");
        return  username ;
        }

    public String getPassword()
    {
        String password=pro.getProperty("password");
        return  password;

    }


      public  String getChromePath()
      {
          String chromepath= pro.getProperty("chromepath");
          return chromepath;

      }

    public  String getFirefoxPath()
    {
        String firefoxpath= pro.getProperty("firefoxpath");
        return firefoxpath;

    }


}
