package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.GeneralUtilities;
import utility.WaitUtilities;

public class DashboardPageClass {
	
	
	WebDriver driver;
	GeneralUtilities gUtil  = new GeneralUtilities();
	WaitUtilities wUtil  = new WaitUtilities();
	
	public DashboardPageClass(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//h1[contains(text(),'Welcome')]")WebElement welcomeMsg;
	@FindBy(xpath = "//span[contains(text(),'User Management')]")WebElement userManagementMenu;
	@FindBy(xpath = "//a[@href='https://qalegend.com/billing/public/users']//span[contains(text(),'Users')]")WebElement userSubMenu;
	@FindBy(xpath  = "//button[@id='start_tour']")WebElement helpBtn;
	@FindBy(xpath = "//span[text()='Contacts']")WebElement contactsMenu;
	@FindBy(xpath = "//a[@href='https://qalegend.com/billing/public/contacts/import']")WebElement importContactssubMenu;
	@FindBy(xpath = "//a[@class='logo']")WebElement logo;
	@FindBy(xpath = "//a[@class='dropdown-toggle' and @data-toggle='dropdown']")WebElement usernameOnTitlebar;
	@FindBy(xpath = "//a[@href='https://qalegend.com/billing/public/user/profile']")WebElement profile;
	@FindBy(xpath = "//button[contains(text(),'End tour')]")WebElement endTourBtn;
	@FindBy(xpath = "//a[@href='https://qalegend.com/billing/public/customer-group']")WebElement customerGroupsSubMenu;
	@FindBy(css  = "#view_todays_profit")WebElement todaysProfit;
	@FindBy(xpath = "//h3[contains(text(),'Net Profit: ')]")WebElement netProfit;
	@FindBy(xpath = "//div[@class='info-box']//span[text()='Total purchase']")WebElement totalPurchaseInfo;
	
	
	public String getTextOfWelcomeMsg()
	{
		return gUtil.getTextOfElement(welcomeMsg);
	}
	
	public void navigateToUserPage()
	{
		wUtil.waitForElementToBeClickable(driver, 1, userManagementMenu);
		gUtil.clickUsingJavaScriptExecutor(driver, userManagementMenu);
		wUtil.waitForElementToBeClickable(driver, 1,userSubMenu);
		gUtil.clickUsingJavaScriptExecutor(driver, userSubMenu);
	}
	
	public void mouseHoverOnHelpBtn() {
		
		wUtil.waitForPresenceOfElementByLocator(driver, 10, "//button[@id='start_tour']");
		gUtil.mouseHover(driver, helpBtn);
		
	}
	public String getAttriobuteOfToolTipHelpBtn() {
		
		return gUtil.getAttributeOfElement(helpBtn, "data-original-title");
	}
	
	public void navigateToImportContactsPage()
	{
		
		gUtil.clickUsingJavaScriptExecutor(driver, contactsMenu);
		gUtil.clickUsingJavaScriptExecutor(driver, importContactssubMenu);
	}
	public boolean isLogoDisplayed() {
		
		return gUtil.isElementDisplayed(logo);
	}
	
	public String getTextOfLogo() {
		return gUtil.getTextOfElement(logo);
	}
	
	public void navigationToMyProfile() {
		
		wUtil.waitForElementToBeClickable(driver, 2, usernameOnTitlebar);
		gUtil.clickUsingJavaScriptExecutor(driver, usernameOnTitlebar);

	    wUtil.waitForElementToBeClickable(driver, 2, profile);
	    gUtil.clickUsingJavaScriptExecutor(driver, profile);
	}
	
	public void isEndTourDispalyed() {
		
		boolean displayed = endTourBtn.isDisplayed();
		if(displayed== true)
		{
			endTourBtn.click();
		}
		else
		{
			
		}
		
	}
	public void clickOnCustomerGroupsSubMenu()
	{
		contactsMenu.click();
		customerGroupsSubMenu.click();
		
		
	}
	
	public void clickOnTodaysProfit() {
		
		todaysProfit.click();
	}
	public String getTextOfNetProfit() {
		
		wUtil.waitForVisibilityOfElement(driver, 2, netProfit);
		return gUtil.getTextOfElement(netProfit);
	}
	public boolean isTotalPurchaseInfoDisplayed()
	{
		return gUtil.isElementDisplayed(totalPurchaseInfo);
	}
	
	

}
