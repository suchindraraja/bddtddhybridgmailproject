package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features= {"E:\\Automation\\AutomationNested\\com.bddtddHYBRID.gui.gmail\\src\\test\\resources\\features\\feature3.feature"},
				 monochrome=true,
				 glue= {"glue"},
				 plugin= {"pretty","html:target\\logouttestresults","rerun:target\\logouttestfailed.txt"}
				)

public class LogoutTestRunner extends AbstractTestNGCucumberTests
{
}
