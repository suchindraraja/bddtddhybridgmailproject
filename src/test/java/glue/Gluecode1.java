package glue;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.Composepage;
import pages.Homepage;
import pages.Loginpage;
import pages.Logoutpage;

public class Gluecode1
{
	public Shared sh;
	
	public Gluecode1(Shared sh)
	{
		this.sh=sh;
	}
	
	@Given("^launch site$")
	public void method1()
	{
		WebDriverManager.chromedriver().setup();
		sh.driver=new ChromeDriver();
		sh.driver.manage().window().maximize();
		sh.driver.get(sh.p.getProperty("url"));
		sh.wait=new WebDriverWait(sh.driver,20);
		sh.hp=new Homepage(sh.driver);
		sh.lip=new Loginpage(sh.driver);
		sh.cp=new Composepage(sh.driver);
		sh.lop=new Logoutpage(sh.driver);
		sh.wait.until(ExpectedConditions.visibilityOf(sh.hp.uid));
	}

	@Then("^title should be \"(.*)\" for homepage$")
	public void method2(String et)
	{
		String at=sh.driver.getTitle();
		if(at.contains(et))
		{
			sh.s.write("Title test passed");
			Assert.assertTrue(true);
		}
		else
		{
			byte[] b=sh.driver.getScreenshotAs(OutputType.BYTES);
			sh.s.embed(b,"Title test failed");
			Assert.assertTrue(false);
		}
	}
	
	@When("^enter password as \"(.*)\" and click next button$")
	public void method6(String pwd) throws Exception
	{
		sh.lip.fillPWD(pwd);
		sh.wait.until(ExpectedConditions.elementToBeClickable(sh.lip.pwdnext));
		sh.lip.clickPWDNext();
		Thread.sleep(5000);
	}
	
	@Then("^validate password field with \"(.*)\" criteria$")
	public void method7(String pwdc)
	{
		//Validations
		try
		{
			if(pwdc.equalsIgnoreCase("blank") && sh.lip.blankpwderr.isDisplayed())
			{
				sh.s.write("Blank Password test passed");
				Assert.assertTrue(true);
			}
			else if(pwdc.equalsIgnoreCase("invalid") && sh.lip.invalidpwderr.isDisplayed())
			{
				sh.s.write("Invalid Password test passed");
				Assert.assertTrue(true);
			}
			else if(pwdc.equalsIgnoreCase("valid") && sh.cp.comp.isDisplayed())
			{
				sh.s.write("Valid Password test passed");
				Assert.assertTrue(true);
			}
			else
			{
				byte[] b=sh.driver.getScreenshotAs(OutputType.BYTES);
				sh.s.embed(b,"Password test failed");
				Assert.assertTrue(false);
				//Assert.fail();
			}
		}
		catch(Exception ex)
		{
			byte[] b=sh.driver.getScreenshotAs(OutputType.BYTES);
			sh.s.embed(b,ex.getMessage());
			Assert.assertTrue(false);
			//Assert.fail();
		}
	}	
}
