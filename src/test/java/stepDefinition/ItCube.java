package stepDefinition;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import com.cucumber.listener.Reporter;
import com.google.common.io.Files;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utility.UtilityFunctions;


public class ItCube extends UtilityFunctions
{  
	UtilityFunctions utility= new UtilityFunctions();	
	public ItCube() throws InterruptedException 
	  {
		  super();
		// TODO Auto-generated constructor stub
	  }
		 
	/*
	 * @After public void tearDown() { driver.quit(); }
	 */

	
	@Given("^User is on chrome$")
 public void launchApplication() throws Throwable							
    {	
      System.out.println("This Step will open the chrome and launch the application.");	
           driver.get("https://tcube.technossusdev1.com/");         
             Thread.sleep(3000);
    }		

   @When("^Enter the Username and Password$")					
   public void enter_the_Username_and_Password() throws Throwable 							
    {		
       System.out.println("This step enter the Username and Password on the login page.");	
       driver.findElement(By.xpath("//input[@type='email']")).sendKeys("sonika.goyal@technossus.com");
       driver.findElement(By.xpath("//input[@type='submit']")).click();
       Thread.sleep(3000);       
       driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Soumil@2013");
       driver.findElement(By.xpath("//input[@class='btn btn-block btn-primary']")).submit();
    }		

    @Then("^Verify the logged user$")					
    public String clickLogin() throws Throwable 							
    {    		
        System.out.println("This step will click on the Login button.");	
        driver.findElement(By.xpath("//input[@type='submit']")).click();
         Thread.sleep(2000);
    
        //WebElement label = driver.findElement(By.xpath("//span[@class='hidden-sm hidden-md ng-binding']"));
         WebElement label = driver.findElement(By.cssSelector("span[class='hidden-sm hidden-md ng-binding']"));
                        
         String logged_user= label.getText().toString();
              System.out.println(logged_user);
              utility.writeToPropertyFile("name",logged_user);
       
            if(logged_user.equalsIgnoreCase("sonika.goyal@technossus.com"))
            
            	System.out.println("User logged in successfully");
            else
            	
            	System.out.println("User is not able to login");
			return logged_user;

    }

   @After()
   public void captureScreenshot(Scenario scenario) 
	{  
	    if(scenario.isFailed())
	     {
	    	 String screenshotName= scenario.getName().replaceAll(" ", "_");
			try 
			{
				TakesScreenshot scrshot= ((TakesScreenshot)driver);
			
				File srcFile= scrshot.getScreenshotAs(OutputType.FILE);
				//String path ="D:\\selenium-java\\BDDCucumber\\target\\cucumber-reports";
				 File destiFile= new File("D:\\selenium-java\\BDDCucumber\\target\\cucumber-reports\\screenshots\\" +screenshotName+ ".png");
				 Files.copy(srcFile, destiFile);
				 	Reporter.addScreenCaptureFromPath(destiFile.toString());
				} 
			catch (IOException e) 
			    {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	    }
   
}

