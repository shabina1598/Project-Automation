package pageClasses;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import utility.GeneralUtilities;
import utility.WaitUtilities;

public class UsersPageClass {

	WebDriver driver;
	GeneralUtilities gUtil = new GeneralUtilities();
	WaitUtilities wUtil = new WaitUtilities();

	public UsersPageClass(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@href='https://qalegend.com/billing/public/users/create']")
	WebElement addBtn;
	@FindBy(xpath = "//input[@type='search']")
	WebElement search;
	@FindBy(xpath = "//table//tbody//tr//td[contains(text(),'Shabina')]")
	WebElement searchResult;
	@FindBy(xpath = "//table//tbody//tr[1]//td[5]//button[contains(text(),'Delete')]")
	WebElement deleteBtn;
	@FindBy(xpath = "//button[text()='OK']")
	WebElement deleteOk;
	@FindBy(xpath = "//table//tbody//tr//td[contains(text(),'No matching records found')]")
	WebElement emptySearchResult;
	@FindBy(xpath = "//table//tbody//tr[1]//td//a[contains(text(),'View')]")
	WebElement viewBtn;
	@FindBy(xpath = " //span[contains(text(),'Action')]")
	WebElement actionBtn;
	@FindBy(xpath = " //a[contains(text(),'Column visibility')]")
	WebElement columnVisibility;
	@FindBy(xpath = "//a[text()='Username']")
	WebElement usernameColumn;
	@FindBy(xpath = "//a[text()='Role']")
	WebElement roleColumn;
	@FindBy(xpath = "//table//thead//tr[1]//th")
	List<WebElement> userTableHeaders;

	// Only locate table rows here
	@FindBy(xpath = "//table/tbody/tr")

	public List<WebElement> tableRows;

	@FindBy(xpath = "//table/tbody/tr[1]")
	private WebElement firstRow;

	public List<WebElement> getTableRows() {

		return tableRows;
	}

	public WebElement getFirstRow() {

		return firstRow;
	}

	public AddUserPageClass clickOnAddBtn() {

		gUtil.clickUsingJavaScriptExecutor(driver, addBtn);
		return new AddUserPageClass(driver);
				
	}

	public String getUrlOfUserPage(WebDriver driver) {

		return gUtil.getCurrentUrlOfPage(driver);
	}

	public void searchForUser(String user) throws InterruptedException {

		search.sendKeys(user);
		gUtil.addSleep(2000);
	}

	public String searchResultOfUser() {

		return gUtil.getTextOfElement(searchResult);
	}

	public void clickOnDeleteInAction() {
		
		wUtil.waitForElementToBeClickable(driver, 2, deleteBtn);
		deleteBtn.click();
		wUtil.waitForElementToBeClickable(driver, 2, deleteOk);
		deleteOk.click();

	}

	public String getTextOfEmptySearchResult() {

		return gUtil.getTextOfElement(emptySearchResult);
	}

	public void clickOnColumnVisibility() {

		wUtil.waitForElementToBeClickable(driver, 1, actionBtn);
		actionBtn.click();
		wUtil.waitForElementToBeClickable(driver, 1, columnVisibility);
		columnVisibility.click();
		wUtil.waitForElementToBeClickable(driver, 1, usernameColumn);
		usernameColumn.click();
		wUtil.waitForElementToBeClickable(driver, 1, roleColumn);
		roleColumn.click();
	}

	public List<String> getTextOfUserTableHeaders() {
		List<String> headerText = new ArrayList<>();
		for (WebElement headers : userTableHeaders) {

			headerText.add(headers.getText().trim());

		}
		return headerText;
	}

}
