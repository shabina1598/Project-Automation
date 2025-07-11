package testClasses;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import pageClasses.AddUserPageClass;
import pageClasses.DashboardPageClass;
import pageClasses.LoginPageClass;
import pageClasses.UsersPageClass;
import utility.ExcelReadUtility;
import utility.GeneralUtilities;
import utility.RandonDataUtility;
import utility.TableUtility;
import utility.WaitUtilities;

public class AddUserTestClass extends BaseClass {

	LoginPageClass lp;
	DashboardPageClass dp;
	UsersPageClass up;
	AddUserPageClass aup;

	@Test(priority = 11)
	public void verifyAddUserFunctionality() throws IOException, InterruptedException {

		lp = new LoginPageClass(driver);
		dp=lp.login(ExcelReadUtility.getStringData(2, 0, "Login"), ExcelReadUtility.getIntData(2, 1, "Login"));
		up=dp.navigateToUserPage();
		//up = new UsersPageClass(driver);
		aup=up.clickOnAddBtn();
		//aup = new AddUserPageClass(driver);
		
		String prefix = RandonDataUtility.getPrefix();
		String fname = RandonDataUtility.getFirstName();
		String lname = RandonDataUtility.getLastName();
		String email = RandonDataUtility.getEmail_Utility();
		String password = RandonDataUtility.getPassword();
		int roleIndex = RandonDataUtility.getRandomRoleIndex();

		aup.addUser(prefix, fname, lname, email, roleIndex, password, password);
		up.searchForUser(fname);
		List<WebElement> filteredRows = up.getTableRows();
		boolean actualResult = TableUtility.isTextPresentInTable(filteredRows, fname);
		System.out.println("User found? " + actualResult);
		Assert.assertTrue(actualResult, "User with name '" + fname + "' not found in search results.");

	}

}
