package basePackage;

import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import constants.ConstantClass;
import extentReport.ExtentManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties property;
	
	public static void readProperty() throws IOException {
		
		property = new Properties();
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+ConstantClass.propertyPath);
		property.load(fs);
	}
 
 @Parameters("browser")
  @BeforeMethod(groups= {"TearUp"})
  public void beforeMethod(String browserValue) throws IOException {
	  readProperty();
	  if(browserValue.equalsIgnoreCase("chrome"))
	  {
		  driver=new ChromeDriver(); 
	  }
	  else if(browserValue.equalsIgnoreCase("edge"))
	  { 
		  driver=new EdgeDriver(); 
		  
	  }
	  else
	  {
		  throw new IllegalArgumentException("invalid browser : "+browserValue);
	  }
	 
	  driver.manage().window().maximize();
	  driver.get(property.getProperty("base_url"));
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConstantClass.implicitTimeOut));
	  
	  
  }

  @AfterMethod(groups= {"TearDown"})
  public void afterMethod() throws InterruptedException {
	  
	  Thread.sleep(2000);
	 driver.quit();
  }
  
  @BeforeSuite(alwaysRun = true)
  public void createReport()
  {
	  ExtentManager.createInstance();
  }
  

}
