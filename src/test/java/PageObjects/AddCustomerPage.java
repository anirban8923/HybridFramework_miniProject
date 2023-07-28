package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage
{

    WebDriver ldriver ;

    public AddCustomerPage(WebDriver rdriver) {
        this.ldriver = rdriver;
        PageFactory.initElements(rdriver,this);

    }

    @FindBy(how= How.XPATH, using = "/html/body/div[3]/div/ul/li[2]/a")
    @CacheLookup
    WebElement lnkAddNewCustomer ;

    @FindBy(how= How.NAME, using = "name")
    @CacheLookup
    WebElement customerName ;

    @FindBy(how= How.NAME, using = "rad1")
    @CacheLookup
    WebElement gender ;


    @FindBy(how= How.ID_OR_NAME, using = "dob")
    @CacheLookup
    WebElement dob ;


    @FindBy(how= How.NAME, using = "addr")
    @CacheLookup
    WebElement address ;

    @FindBy(how= How.NAME, using = "city")
    @CacheLookup
    WebElement city ;


    @FindBy(how= How.NAME, using = "state")
    @CacheLookup
    WebElement state ;


    @FindBy(how= How.NAME, using = "pinno")
    @CacheLookup
    WebElement pincode ;


    @FindBy(how= How.NAME, using = "telephoneno")
    @CacheLookup
    WebElement telephone ;


    @FindBy(how= How.NAME, using = "emailid")
    @CacheLookup
    WebElement emailId ;

    @FindBy(how= How.NAME, using = "password")
    @CacheLookup
    WebElement txtpass ;


    @FindBy(how= How.XPATH, using = "/html/body/table/tbody/tr/td/table/tbody/tr[14]/td[2]/input[1]")
    @CacheLookup
    WebElement btn1submit ;



    public void clickAddNew()
    {
        lnkAddNewCustomer.click();
    }

    public void custName(String cname)
    {
            customerName.sendKeys(cname);

    }

    public void custGender(String cgender)
    {
        gender.sendKeys(cgender);
    }

    public  void custdob(String dd, String mm, String yy)
    {
        dob.sendKeys(dd);
        dob.sendKeys(mm);
        dob.sendKeys(yy);
    }


    public void custaddress(String caddress)
    {
        address.sendKeys(caddress);
    }

    public void custcity(String ccity)
    {
        city.sendKeys(ccity);
    }

    public void custstate(String cstate)
    {
        state.sendKeys(cstate);
    }

    public void custpinno(String cpinno)
    {
       pincode.sendKeys(String.valueOf(cpinno));
    }


    public void custtelephoneno(String ctelephone)
    {
        telephone.sendKeys(ctelephone);
    }


    public void custemailid(String cemailid)
    {
       emailId.sendKeys(cemailid);
    }


    public void custpassword(String cpassword)
    {
        txtpass.sendKeys(cpassword);
    }

public void custsubmit()
{
    btn1submit.click();

}


}
