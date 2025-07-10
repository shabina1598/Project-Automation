package testClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import pageClasses.DashboardPageClass;
import pageClasses.LoginPageClass;
import pageClasses.MyProfilePageClass;
import utility.ExcelReadUtility;

public class DashboardTestClass extends BaseClass{
	
	LoginPageClass lp;
	DashboardPageClass dp;
	MyProfilePageClass mpp;
  @Test
  public void verifyTooltipTextOfHelpBtn() throws IOException {
	  
	  lp= new LoginPageClass(driver);
	  lp.login(ExcelReadUtility.getStringData(2, 0, "Login"), ExcelReadUtility.getIntData(2, 1, "Login"));
	  dp = new DashboardPageClass(driver);
	  dp.isEndTourDispalyed();
	  dp.mouseHoverOnHelpBtn();
	  String actualResult = dp.getAttriobuteOfToolTipHelpBtn();
	  System.out.println(actualResult);
	  Assert.assertEquals(actualResult, ExcelReadUtility.getStringData(3, 1, "Dashboard"));
	  
  }
  @Test
  public void verifyLogoIsDisplayed() throws IOException {
	  lp= new LoginPageClass(driver);
	  lp.login(ExcelReadUtility.getStringData(2, 0, "Login"), ExcelReadUtility.getIntData(2, 1, "Login"));
	  dp = new DashboardPageClass(driver);
	  dp.isEndTourDispalyed();
	  boolean actualResult = dp.isLogoDisplayed();
	  System.out.println(actualResult);
	  Assert.assertTrue(actualResult);
	  String actual= dp.getTextOfLogo();
	  System.out.println(actual);
	  Assert.assertEquals(actual, ExcelReadUtility.getStringData(6, 1, "Dashboard"));
	  
  }
  
  @Test
  public void verifyNavigationToMyProfileFromDashboard() throws IOException {
	  
	  lp= new LoginPageClass(driver);
	  lp.login(ExcelReadUtility.getStringData(2, 0, "Login"), ExcelReadUtility.getIntData(2, 1, "Login"));
	  dp=new DashboardPageClass(driver);
	  dp.isEndTourDispalyed();
	  dp.navigationToMyProfile();
	  mpp = new MyProfilePageClass(driver);
	  String actualResult = mpp.getTextOfMyProfile();
	  System.out.println(actualResult);
	  Assert.assertEquals(actualResult, ExcelReadUtility.getStringData(10, 1, "Dashboard"));
	  
	  
	  
  }
  @Test
  public void verifyTodaysProfitButtonIsWorking() throws IOException {
	  
	  lp= new LoginPageClass(driver);
	  lp.login(ExcelReadUtility.getStringData(2, 0, "Login"), ExcelReadUtility.getIntData(2, 1, "Login"));
	  dp=new DashboardPageClass(driver);
	  dp.isEndTourDispalyed();
	  dp.clickOnTodaysProfit();
	  String actualResult = dp.getTextOfNetProfit();
	  System.out.println(actualResult);
	  Assert.assertTrue(actualResult.contains(ExcelReadUtility.getStringData(1, 1, "Dashboard")));
	  
  }
  @Test
  public void verifyTotalPurchaseInfoIsDisplayed() throws IOException
  {
	  lp= new LoginPageClass(driver);
	  lp.login(ExcelReadUtility.getStringData(2, 0, "Login"), ExcelReadUtility.getIntData(2, 1, "Login"));
	  dp=new DashboardPageClass(driver);
	  dp.isEndTourDispalyed();
	  boolean actualResult = dp.isTotalPurchaseInfoDisplayed();
	  System.out.println(actualResult);
	  Assert.assertTrue(actualResult);
	  
	  
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
