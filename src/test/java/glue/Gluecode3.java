package glue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;

public class Gluecode3
{
	Shared sh;
	
	public Gluecode3(Shared sh)
	{
		this.sh=sh;
	}
	
	/*@When("^send mail and validate the operation$")
	public void method10(DataTable dt) throws Exception
	{
		List<List<String>> data=dt.asLists();
		for(int i=1;i<data.size();i++)
		{
			String rp=data.get(i).get(0);
			String sub=data.get(i).get(1);
			String body=data.get(i).get(2);
			String attachment=data.get(i).get(3);
			sh.wait.until(ExpectedConditions.elementToBeClickable(sh.cp.comp));
			sh.cp.clickCompose();
			sh.wait.until(ExpectedConditions.visibilityOf(sh.cp.toaddress));
			sh.cp.fillTo(rp);
			sh.cp.fillSubject(sub);
			sh.cp.fillBody(body);
			sh.cp.attachment(attachment);
			sh.wait.until(ExpectedConditions.visibilityOf(sh.cp.uploaded));
			sh.cp.clickSend();
			sh.wait.until(ExpectedConditions.visibilityOf(sh.cp.outputmsg));	
		}	
	}*/
	@When("^send mail and validate the operation$")
	public void method10(DataTable dt) throws Exception
	{
		List<Map<String,String>> data=dt.asMaps();
		for(int i=0;i<data.size();i++)
		{
			String rp=data.get(i).get("recipient");
			String sub=data.get(i).get("sub");
			String body=data.get(i).get("body");
			String attachment=data.get(i).get("attachment");
			sh.wait.until(ExpectedConditions.elementToBeClickable(sh.cp.comp));
			sh.cp.clickCompose();
			sh.wait.until(ExpectedConditions.visibilityOf(sh.cp.toaddress));
			sh.cp.fillTo(rp);
			sh.cp.fillSubject(sub);
			sh.cp.fillBody(body);
			sh.cp.attachment(attachment);
			sh.wait.until(ExpectedConditions.visibilityOf(sh.cp.uploaded));
			sh.cp.clickSend();
			sh.wait.until(ExpectedConditions.visibilityOf(sh.cp.outputmsg));	
		}	
	}
	
	@When("^send mail by taking data from excel and validate the operation$")
	public void method11() throws Exception
	{
		File f=new File("emailids.xlsx");
		FileInputStream fi=new FileInputStream(f);
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sheet=wb.getSheet("Sheet1");
		int nour=sheet.getPhysicalNumberOfRows();
		int nouc=sheet.getRow(0).getLastCellNum();
		//Give headings to results in excel file
		sheet.getRow(0).createCell(nouc).setCellValue("Mail sent Status");
		//Data Driven from 2nd row(index=1)
		for(int i=1;i<nour;i++)
		{
			//Read data from excel
			DataFormatter df=new DataFormatter();
			String rp=df.formatCellValue(sheet.getRow(i).getCell(0));
			String sub=df.formatCellValue(sheet.getRow(i).getCell(1));
			String body=df.formatCellValue(sheet.getRow(i).getCell(2));
			sh.wait.until(ExpectedConditions.elementToBeClickable(sh.cp.comp));
			sh.cp.clickCompose();
			sh.wait.until(ExpectedConditions.visibilityOf(sh.cp.toaddress));
			sh.cp.fillTo(rp);
			sh.cp.fillSubject(sub);
			sh.cp.fillBody(body);
			sh.cp.clickSend();
			sh.wait.until(ExpectedConditions.visibilityOf(sh.cp.outputmsg));
			String outputmess=sh.cp.outputmsg.getText();
			//Write result back to excel
			sheet.getRow(i).createCell(nouc).setCellValue(outputmess);	
		}
		
		sheet.autoSizeColumn(nouc);
		
		//Save data back to excel
		FileOutputStream fo=new FileOutputStream(f);
		wb.write(fo);
		fi.close();
		fo.close();
		wb.close();
	}	
}
