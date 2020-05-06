package stepDefinition;
import org.openqa.selenium.By;
import cucumber.api.java.en.Given;
import utility.UtilityFunctions;

public class Search extends UtilityFunctions
{	
	public Search() throws InterruptedException {
	     	super();
		// TODO Auto-generated constructor stub
	}
	UtilityFunctions utility= new UtilityFunctions();
	
	@Given("^User is on chrome browser$")
	 public void launchApplication1() throws Throwable							
	    {	
	             //utility.OpenBrowser();
	      System.out.println("This Step will launch the application.");		      
	          driver.get("https://google.com/");
	          System.out.println("Google opened");	        
	               Thread.sleep(3000);
	    }
	@Given("^Search text$")
	 public void searchText() throws Throwable
	 {
		  String value= utility.readPropertyFile("name").toString();
		   
           System.out.println("search_text: " +value);
		 driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys(value);
		        Thread.sleep(4000);
		 driver.findElement(By.xpath("//input[@class='gNO89b']")).click();
	 } 
}
