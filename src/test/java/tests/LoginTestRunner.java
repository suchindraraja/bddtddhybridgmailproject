package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features= {"E:\\Automation\\AutomationNested\\com.bddtddHYBRID.gui.gmail\\src\\test\\resources\\features\\feature2.feature"},
				 monochrome=true,
				 glue= {"glue"},
				 plugin= {"pretty","html:target\\logintestresults","rerun:target\\logintestfailed.txt"}
				)

public class LoginTestRunner extends AbstractTestNGCucumberTests
{
}
