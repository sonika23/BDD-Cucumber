package utility;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UtilityFunctions 
 {	 
		
	  public static WebDriver driver;
	  public UtilityFunctions() throws InterruptedException 
	      {
		      if(driver==null)
		      {  
				  System.setProperty("webdriver.chrome.driver", "D:\\Downloads\\chromedriver_win32\\chromedriver.exe"); 
				  driver = new ChromeDriver(); 
				  driver.manage().window().maximize();
				    Thread.sleep(2000); 
		      }
		  }
	 
   public void writeToPropertyFile(String key,String value) throws IOException
     {
		 String file = "D:\\selenium-java\\BDDCucumber\\inputSheet\\testData.properties";
         Properties property = new Properties();
       	 FileOutputStream output= new FileOutputStream(file);  
                 property.setProperty(key,value);
                property.store(output, "Save text");
                     output.close();
	 }
	public String readPropertyFile(String key) throws IOException
	{
	   String file = "D:\\selenium-java\\BDDCucumber\\inputSheet\\testData.properties";
         Properties property = new Properties(); 
         try {
			FileInputStream input= new FileInputStream(file);
			   property.load(input);
		    String value=   property.getProperty(key);
			 	 input.close();
			       return value;
		} 
         catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   	return null;
		}	         
		
	}
    
}
