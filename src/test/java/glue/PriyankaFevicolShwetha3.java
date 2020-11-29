package glue;

import java.util.List;

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
	public void method9(DataTable dt)
	{
		List<List<String>> data=dt.asLists();
		for(int i=1;i<data.size();i++)
		{
			String rp=data.get(i).get(0);
			String sub=data.get(i).get(1);
			String body=data.get(i).get(2);
			
			
			
			
			
			
			
			
			
			
			
			
		}
	}
}
