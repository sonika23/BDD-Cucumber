package testRunner;
import java.io.File;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"D:\\selenium-java\\BDDCucumber\\src\\test\\java\\features\\feature1.feature","D:\\selenium-java\\BDDCucumber\\src\\test\\java\\features\\feature2.feature"},
                             glue= {"stepDefinition"},
                             plugin="com.cucumber.listener.ExtentCucumberFormatter:D:\\selenium-java\\BDDCucumber\\target\\cucumber-reports\\report.html")

public class Runner 
{ 
	@AfterClass
	 public static void writeExtentReport() 
	 {
	  Reporter.loadXMLConfig(new File("D:\\selenium-java\\BDDCucumber\\report\\extent-config.xml"));
	  Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
	 }
}
