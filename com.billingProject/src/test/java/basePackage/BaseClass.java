package basePackage;

import org.testng.annotations.Test;

import constants.ConstantClass;

import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class BaseClass {
	
	public WebDriver driver;
	public static Properties property;
	
	public static void readProperty() throws IOException {
		
		property = new Properties();
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+ConstantClass.propertyPath);
		property.load(fs);
	}
 
 
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  readProperty();
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get(property.getProperty("base_url"));
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConstantClass.implicitTimeOut));
	  
	  
  }

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  
	  Thread.sleep(2000);
	 driver.quit();
  }

}
