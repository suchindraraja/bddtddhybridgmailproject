package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features= {"E:\\Automation\\AutomationNested\\com.bddtddHYBRID.gui.gmail\\src\\test\\resources\\features\\feature5.feature"},
				 monochrome=true,
				 glue= {"glue"},
				 plugin= {"pretty","html:target\\mailcomposetestresults","rerun:target\\mailcomposetestfailed.txt"}					
				)
public class MailComposeTestRunner extends AbstractTestNGCucumberTests
{
}
