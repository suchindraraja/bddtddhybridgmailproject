package glue;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Gluecode2
{
	Shared sh;
	
	public Gluecode2(Shared sh)
	{
		this.sh=sh;
	}
	
	@When("^close site$")
	public void method3()
	{
		sh.driver.close();
	}
	
	@When("^enter email id as \"(.*)\" and click next button$")
	public void method4(String uid) throws Exception
	{
		sh.hp.fillUID(uid);
		sh.wait.until(ExpectedConditions.elementToBeClickable(sh.hp.uidnext));
		sh.hp.clickUIDNext();
		Thread.sleep(5000);
	}
	
	@Then("^validate email id field with \"(.*)\" criteria$")
	public void method5(String uidc)
	{
		try
		{
			//Validations
			if(uidc.equalsIgnoreCase("blank") && sh.hp.blankuiderr.isDisplayed())
			{
				sh.s.write("Blank UID test passed");
				Assert.assertTrue(true);
			}
			else if(uidc.equalsIgnoreCase("invalid") && sh.hp.invaliduiderr.isDisplayed())
			{
				sh.s.write("Invalid UID test passed");
				Assert.assertTrue(true);
			}
			else if(uidc.equalsIgnoreCase("valid") && sh.lip.pwd.isDisplayed())
			{
				sh.s.write("Valid UID test passed");
				Assert.assertTrue(true);
			}
			else
			{
				byte[] b=sh.driver.getScreenshotAs(OutputType.BYTES);
				sh.s.embed(b,"UID test failed");
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
	
	@When("^do logout$")
	public void method8() throws Exception
	{
		sh.wait.until(ExpectedConditions.visibilityOf(sh.cp.comp));
		sh.lop.clickProfilePic();
		sh.wait.until(ExpectedConditions.visibilityOf(sh.lop.signout));
		sh.lop.clickSignout();
		Thread.sleep(5000);
	}
	
	@Then("^validate logout$")
	public void method9()
	{
		//Validations
		try
		{
			if(sh.driver.findElement(By.xpath("//*[text()='Use another account']")).isDisplayed())
			{
				sh.s.write("Logout test passed");
				Assert.assertTrue(true);
			}
		}
		catch(Exception ex)
		{
			byte[] b=sh.driver.getScreenshotAs(OutputType.BYTES);
			sh.s.embed(b,"Logout test failed");
			Assert.assertTrue(false);
		}
	}
}
