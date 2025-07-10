package testClasses;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import dataProvider.DataProviderClass;
import pageClasses.CustomerGroupsPageClass;
import pageClasses.DashboardPageClass;
import pageClasses.LoginPageClass;
import pageClasses.UsersPageClass;
import utility.ExcelReadUtility;
import utility.GeneralUtilities;
import utility.RandonDataUtility;
import utility.TableUtility;
import utility.WaitUtilities;

public class CustomerGroupsTestClass  extends BaseClass{

	LoginPageClass lp;
	DashboardPageClass dp;
	CustomerGroupsPageClass cgp;
	WaitUtilities wUtil = new WaitUtilities();
	GeneralUtilities gUtil  = new GeneralUtilities();
	
	
  @Test
  public void verifyAddCustomerGroupFunctionality() throws IOException, InterruptedException {
	  
		lp = new LoginPageClass(driver);
		lp.login(ExcelReadUtility.getStringData(2, 0, "Login"), ExcelReadUtility.getIntData(2, 1, "Login"));
		dp = new DashboardPageClass(driver);
		dp.isEndTourDispalyed();
		dp.clickOnCustomerGroupsSubMenu();
		cgp = new CustomerGroupsPageClass(driver);
		cgp.clickOnAddBtn();
		String customerGroupName = RandonDataUtility.getCustomerGroupName();
		String percentage = RandonDataUtility.getRandomPercentage();
		cgp.addCustomerGroup(customerGroupName, percentage);
		
		gUtil.addSleep(2000);
		cgp.searchForCustomerGroup(customerGroupName);
		
		gUtil.addSleep(2000);
		List<WebElement> filteredRows = cgp.getTableRows();

		boolean actualResult = TableUtility.isTextPresentInTable(filteredRows, customerGroupName);
		System.out.println("Customer group found ?: " + actualResult);
		Assert.assertTrue(actualResult, "The customer group " + customerGroupName + " is not found");
	  
  }
  
  
}

