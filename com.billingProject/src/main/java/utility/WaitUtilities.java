package utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtilities {
	
	WebDriverWait wait;
	
	public void waitForElementToBeClickableByXpath(WebDriver driver,int timeOut, String locatorValue) 
	{
		wait= new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorValue)));
	}
	
	public void waitForElementToBeClickableById(WebDriver driver,int timeOut, String id) 
	{
		wait= new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
	}
	
	public void waitForElementToBeClickable(WebDriver driver,int timeOut, WebElement element) 
	{
		wait= new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForVisibilityOfElement(WebDriver driver, int timeOut,WebElement element)
	{	
		wait= new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	public void waitForVisibilityOfElementByLocator(WebDriver driver, int timeOut,String locatorvalue)
	{	
		wait= new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorvalue)));
		
	}
	
	public void waitForAlertIsPresent(WebDriver driver,int timeOut)
	{
		wait= new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.alertIsPresent());
		
	}
	
	public void waitForPresenceOfElementByLocator(WebDriver driver,int timeOut,String locatorValue)
	{
		wait= new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorValue)));
		
	}
	
	public void waitForPresenceOfElementsByLocator(WebDriver driver, int timeOut,String locatorValue )
	{
		wait= new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locatorValue)));
	}
	
	public void waitForElementtoBeSelected(WebDriver driver, int timeOut,WebElement element )
	{
		wait= new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	

}
