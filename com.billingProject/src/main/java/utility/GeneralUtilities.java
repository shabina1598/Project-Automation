package utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {
	
	//contains reusable general utility methods
	//call inside a page class
	
	public String getTextOfElement(WebElement element)
	{
		return element.getText();
	}
	
	public boolean isElementDisplayed(WebElement element)
	{
		return element.isDisplayed();
	}
	
	public String getAttributeOfElement(WebElement element,String attribute)
	{
		return element.getAttribute(attribute);
	}
	
	public boolean isElementSelected(WebElement element)
	{
		return element.isSelected();
	}
	
	public boolean isElementEnabled(WebElement element)
	{
		return element.isEnabled();
		
	}
	public String getTitleOfPage(WebDriver driver)
	{
		return driver.getTitle();
	}
	
	public String getCurrentUrlOfPage(WebDriver driver)
	{
		return driver.getCurrentUrl();
	}
	
	public void mouseHover(WebDriver driver,WebElement element) {
		Actions obj_actions= new Actions(driver);
		obj_actions.moveToElement(element).perform();
	}
	
	public void mouseHoverAndClick(WebDriver driver,WebElement element) {
		Actions obj_actions= new Actions(driver);
		obj_actions.moveToElement(element).click().perform();
	}
	
	public void doubleClickOnElement(WebDriver driver,WebElement element)
	{
		Actions obj_actions = new Actions(driver);
		obj_actions.doubleClick().perform();
		
	}
	
	public void dragAndDropElement(WebDriver driver,WebElement sourceElement,WebElement targetElement)
	{
		Actions obj_actions = new Actions(driver);
		obj_actions.dragAndDrop(sourceElement, targetElement).perform();
	}
	
	//Press the down arrow key n times 
	public void pressArrowDown(WebDriver driver,int index)
	{
		
		Actions obj_actions= new Actions(driver);
		for (int i=0;i<=index;i++)
		{
			obj_actions.sendKeys(Keys.ARROW_DOWN);
		}
		obj_actions.sendKeys(Keys.ENTER).perform();
	}
	
	  // Press and hold a key (typically a modifier key like SHIFT, CTRL, ALT)
    public static void keyDown(WebDriver driver, Keys key) {
        Actions actions = new Actions(driver);
        actions.keyDown(key).perform();
    }

    // Release a previously held key
    public static void keyUp(WebDriver driver, Keys key) {
        Actions actions = new Actions(driver);
        actions.keyUp(key).perform();
    }

	
	public void fileUploadUsingSendkeys(WebElement element,String filePath)
	{
		 element.sendKeys(filePath);
	}
	
	public void fileUploadUsingRobotClass(String filePath) throws AWTException
	{
		String path="filePath";
		StringSelection obj = new StringSelection("path");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(obj, null);
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.delay(2000);
		robot.keyPress(KeyEvent.VK_V);
		robot.delay(2000);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.delay(2000);
		robot.keyRelease(KeyEvent.VK_V);
		robot.delay(2000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(2000);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void dropDown_SelectByIndex(WebElement element,int index)
	{
		Select obj_select = new Select(element);
		 obj_select.selectByIndex(index);
	}
	
	public void dropDown_SelectByVisibleText(WebElement element,String visibleText)
	{
		Select obj_select = new Select(element);
		 obj_select.selectByVisibleText(visibleText);
	}
	public void dropDown_SelectByContainsVisibleText(WebElement element,String containsVisibleText)
	{
		Select obj_select = new Select(element);
		 obj_select.selectByContainsVisibleText(containsVisibleText);
	}
	public void dropDown_SelectByValue(WebElement element,String value)
	{
		Select obj_select = new Select(element);
		 obj_select.selectByValue(value);
	}
	
	public boolean isDropDown_MultipleSelect(WebElement element)
	{
		Select obj_select = new Select(element);
		return obj_select.isMultiple();
	}
	
	public void dropDown_DeselectAll(WebElement element)
	{
		Select obj_select = new Select(element);
		obj_select.deselectAll();
	}

	public void dropDown_DeselectByIndex(WebElement element,int index)
	{
		Select obj_select = new Select(element);
		obj_select.deselectByIndex(index);
	}
	public void dropDown_DeselectByVisibleText(WebElement element,String visibleText)
	{
		Select obj_select = new Select(element);
		obj_select.deselectByVisibleText(visibleText);
	}
	public void dropDown_DeselectByContainsVisibleText(WebElement element,String containsVisibleText)
	{
		Select obj_select = new Select(element);
		obj_select.deselectByVisibleText(containsVisibleText);
	}
	public void dropDown_DeselectByValue(WebElement element,String value)
	{
		Select obj_select = new Select(element);
		obj_select.deselectByValue(value);
	}
	public List<String> getOptionsOfDropDown(WebElement element)
	{
		Select obj_select = new Select(element);
		return obj_select.getOptions().stream().map(WebElement::getText).collect(Collectors.toList());
		
	}
	public List<String> getAllSelectedOptionsOfDropDown(WebElement element)
	{
		Select obj_select = new Select(element);
		return obj_select.getAllSelectedOptions().stream().map(WebElement::getText).collect(Collectors.toList());
		
	}
	public WebElement getFirstSelectedOptionOfDropDown(WebElement element)
	{
		Select obj_select = new Select(element);
		return obj_select.getFirstSelectedOption();
	}
	
	public void alertAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void alertDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	public String getTextOfAlert(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	
	public void alertUsingSendkeys(WebDriver driver,String value)
	{
		driver.switchTo().alert().sendKeys(value);
	}
	public void iframeByIndex(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	public void iframeByNameOrId(WebDriver driver,String nameOrId) 
	{
		driver.switchTo().frame(nameOrId);
	}
	public void iframeAsWebelement(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	public void switchtoDefaultContent(WebDriver driver)
	{
		driver.switchTo().defaultContent();
		
	}
	
	public String getWindowHandleOfParentWindow(WebDriver driver)
	{
		return driver.getWindowHandle();
	}
	
	/*public Set<String> getWindowHandlesOfChildWindow(WebDriver driver)
	{
		return driver.getWindowHandles();
	
		
	}*/
	
	// **********************************JavaScript//
			public void clickUsingJavaScriptExecutor(WebDriver driver, WebElement element) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", element);
			}

			public void scrollUsingJavaScriptExecutor(WebDriver driver, WebElement element) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView();", element);
		
			}
			
			public void scrollUsingJavaScriptExecutor_ScrollBy(WebDriver driver) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,1000)");
		
			}
			
		public void addSleep(long timeOut) throws InterruptedException
		{
			Thread.sleep(timeOut);
		}

		public boolean isElementTextEmpty(WebElement element)
		{
			return element.getText().isEmpty();
		}
		
		public boolean isElementAttributeEmpty(WebElement element,String attribute)
		{
			return element.getAttribute("attribute").isEmpty();
		}
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
