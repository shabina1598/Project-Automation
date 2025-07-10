package testClasses;

import java.io.IOException;
import java.nio.file.attribute.UserPrincipal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import pageClasses.DashboardPageClass;
import pageClasses.LoginPageClass;
import pageClasses.UsersPageClass;

import utility.ExcelReadUtility;
import utility.GeneralUtilities;
import utility.TableUtility;
import utility.WaitUtilities;

public class UserTestClass extends BaseClass{
	
	LoginPageClass lp;
	DashboardPageClass dp;
	UsersPageClass up;
	WaitUtilities wUtil = new WaitUtilities();
	GeneralUtilities gUtil = new GeneralUtilities();
	
	
  @Test
  public void verifyUserSearchFunctionality() throws IOException, InterruptedException {
	  
		lp = new LoginPageClass(driver);
		lp.login(ExcelReadUtility.getStringData(2, 0, "Login"), ExcelReadUtility.getIntData(2, 1, "Login"));
		dp = new DashboardPageClass(driver);
		dp.navigateToUserPage();
		
		up = new UsersPageClass(driver);
		up.searchForUser(ExcelReadUtility.getStringData(1, 1, "User"));
		
		//gUtil.addSleep(2000);
		wUtil.waitForVisibilityOfElement(driver, 5, up.getFirstRow());
		
		List<WebElement> filteredRows = up.getTableRows();
		boolean actualResult = TableUtility.isTextPresentInTable(filteredRows,ExcelReadUtility.getStringData(1, 1, "User"));
		System.out.println("User found? " + actualResult);

		Assert.assertTrue(actualResult,"User with name '" + ExcelReadUtility.getStringData(1, 1, "User") + "' not found in search results.");
 
  }
 
  @Test
  public void verifySearchAndDeleteUserFunctionality() throws IOException {
	  
	  lp= new LoginPageClass(driver);
	  lp.login(ExcelReadUtility.getStringData(2, 0, "Login"), ExcelReadUtility.getIntData(2, 1, "Login"));
	  dp= new DashboardPageClass(driver);
	  dp.navigateToUserPage();
 
	  up= new UsersPageClass(driver);
	  up.searchForUser(ExcelReadUtility.getStringData(4, 1, "User"));
	  up.clickOnDeleteInAction();
	  String actualResult = up.getTextOfEmptySearchResult();
	  System.out.println(actualResult);
	  Assert.assertTrue(actualResult.contains(ExcelReadUtility.getStringData(5, 1, "User")));
	  
	  
  }
  @Test
  public void verifyColumnVisibilityFunctionality() throws IOException
  {
	  lp= new LoginPageClass(driver);
	  lp.login(ExcelReadUtility.getStringData(2, 0, "Login"), ExcelReadUtility.getIntData(2, 1, "Login"));
	  dp = new DashboardPageClass(driver);
	  dp.navigateToUserPage();
	  up = new UsersPageClass(driver);
	  up.clickOnColumnVisibility();
	  List<String> actualResult = up.getTextOfUserTableHeaders();
	  List<String> expectedResult=Arrays.asList(ExcelReadUtility.getStringData(7, 1, "User"),ExcelReadUtility.getStringData(7, 2, "User"),ExcelReadUtility.getStringData(7, 3, "User"));
	  System.out.println("Actual Result: " + actualResult);
	  System.out.println("Expected Result: " + expectedResult);
	  Assert.assertEquals(actualResult, expectedResult);
	  
  }
}
