package pageClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.GeneralUtilities;
import utility.WaitUtilities;

public class CustomerGroupsPageClass {
	

	WebDriver driver;
	GeneralUtilities gUtil = new GeneralUtilities();
	WaitUtilities wUtil = new WaitUtilities();

	public CustomerGroupsPageClass(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "//button[@type='button' and text()=' Add']")WebElement addBtn;
	@FindBy(xpath = "//input[@id='name']")WebElement customerGroupName;
	@FindBy(xpath = "//input[@id='amount']")WebElement calculationPercentage;
	@FindBy(xpath = "//button[@type='submit']")WebElement saveBtn;
	@FindBy(xpath = "//h3[@class='box-title']")WebElement allCustomerGroupsLbl;
	@FindBy(xpath = "//input[@type='search']")WebElement searchCustomerGroup;
	
	
	@FindBy(xpath = "//table//tbody//tr") public List<WebElement> tableRows;//for using table utility
	@FindBy(xpath = "//table//tbody//tr[1]") private WebElement firstRow;//for applying wait utlity inside test case
	
	
	public List<WebElement> getTableRows(){
		
		
		return tableRows;
	}
	
   public WebElement getFirstRow(){
		
		return firstRow;
	}
	
  
	public void clickOnAddBtn()
	{
		addBtn.click();
		
	}
	public void addCustomerGroup(String groupName , String percentage) {
		
		customerGroupName.sendKeys(groupName);
		calculationPercentage.sendKeys(percentage);
		wUtil.waitForElementToBeClickable(driver, 2, saveBtn);
		saveBtn.click();
		
		
	}
	public String getTextOfAllCustomerGroupsLbl() {
		
		return gUtil.getTextOfElement(allCustomerGroupsLbl);
	}
	public void searchForCustomerGroup(String user) {
		
		
		searchCustomerGroup.sendKeys(user);
		
	}


}
