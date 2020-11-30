package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features= {"E:\\Automation\\AutomationNested\\com.bddtddHYBRID.gui.gmail\\src\\test\\resources\\features\\feature6.feature"},
				 monochrome=true,
				 glue= {"glue"},
				 plugin= {"pretty","html:target\\mailcomposetestexcelresults","rerun:target\\mailcomposetestexcelfailed.txt"}					
				)
public class MailComposeTestExcelRunner extends AbstractTestNGCucumberTests
{
}
