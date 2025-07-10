package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.GeneralUtilities;
import utility.WaitUtilities;

public class MyProfilePageClass {
	

	WebDriver driver;
	GeneralUtilities gUtil = new GeneralUtilities();
	WaitUtilities wUtil = new WaitUtilities();

	public MyProfilePageClass(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "//h1[contains(text(),'My Profile')]")WebElement myProfile;
	
	public String getTextOfMyProfile()
	{
		return gUtil.getTextOfElement(myProfile);
	}
	


}
