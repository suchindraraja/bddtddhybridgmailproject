package glue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;

public class PriyankaFevicolShwetha3
{
	Shared sh;
	
	public PriyankaFevicolShwetha3(Shared sh)
	{
		this.sh=sh;
	}
	
	@When("^send mail and validate the operation$")
	public void method10(DataTable dt) throws Exception
	{
		List<List<String>> data=dt.asLists();
		for(int i=1;i<data.size();i++)
		{
			String rp=data.get(i).get(0);
			String sub=data.get(i).get(1);
			String body=data.get(i).get(2);
			sh.cp.clickCompose();
			sh.wait.until(ExpectedConditions.visibilityOf(sh.cp.toaddress));
			sh.cp.fillTo(rp);
			sh.cp.fillSubject(sub);
			sh.cp.fillBody(body);
			sh.cp.clickSend();
			sh.wait.until(ExpectedConditions.elementToBeClickable(sh.cp.comp));	
		}	
	}
}
