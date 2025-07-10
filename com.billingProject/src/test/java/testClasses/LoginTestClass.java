package testClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import dataProvider.DataProviderClass;
import pageClasses.DashboardPageClass;
import pageClasses.LoginPageClass;
import utility.ExcelReadUtility;

public class LoginTestClass extends BaseClass {
	
	LoginPageClass lp ;
	DashboardPageClass dp;
	
  @Test
  public void verifySuccessfullLogin() throws IOException {
	  
	  lp = new LoginPageClass(driver);
	  lp.login(ExcelReadUtility.getStringData(2, 0, "Login"), ExcelReadUtility.getIntData(2, 1, "Login"));
	  dp = new DashboardPageClass(driver);
	  dp.isEndTourDispalyed();
	  String actualResult=dp.getTextOfWelcomeMsg();
	  System.out.println(actualResult);
	  Assert.assertTrue(actualResult.contains("Welcome"));
	 
  }
  @Test(dataProvider = "unSuccessfullLogin",dataProviderClass = DataProviderClass.class)
  public void verifyUnSuccessfullLogin(String uname,String pword) throws IOException
  {
	  lp= new LoginPageClass(driver);
	  lp.login(uname,pword);
	  String actualResult=lp.getTextOfLoginErrorMsg();
	  System.out.println(actualResult);
	  Assert.assertTrue(actualResult.contains("do not match"));
  }
}
