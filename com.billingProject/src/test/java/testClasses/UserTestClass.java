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
import pageClasses.AddUserPageClass;
import pageClasses.DashboardPageClass;
import pageClasses.LoginPageClass;
import pageClasses.UsersPageClass;

import utility.ExcelReadUtility;
import utility.GeneralUtilities;
import utility.RandonDataUtility;
import utility.TableUtility;
import utility.WaitUtilities;

public class UserTestClass extends BaseClass {

	LoginPageClass lp;
	DashboardPageClass dp;
	UsersPageClass up;
	AddUserPageClass aup;

	@Test(priority = -1)
	public void verifyUserSearchFunctionality() throws IOException, InterruptedException {

		lp = new LoginPageClass(driver);
		dp = lp.login(ExcelReadUtility.getStringData(2, 0, "Login"), ExcelReadUtility.getIntData(2, 1, "Login"));
		up = dp.navigateToUserPage();
		// up = new UsersPageClass(driver);
		up.searchForUser(ExcelReadUtility.getStringData(1, 1, "User"));
		List<WebElement> filteredRows = up.getTableRows();
		boolean actualResult = TableUtility.isTextPresentInTable(filteredRows,
				ExcelReadUtility.getStringData(1, 1, "User"));
		System.out.println("User found? " + actualResult);

		Assert.assertTrue(actualResult,
				"User with name '" + ExcelReadUtility.getStringData(1, 1, "User") + "' not found in search results.");

	}

	@Test(priority = 0)
	public void verifyDeleteUserFunctionality() throws IOException, InterruptedException {

		lp = new LoginPageClass(driver);
		dp = lp.login(ExcelReadUtility.getStringData(2, 0, "Login"), ExcelReadUtility.getIntData(2, 1, "Login"));
		// dp = new DashboardPageClass(driver);
		up = dp.navigateToUserPage();
		// up = new UsersPageClass(driver);
		aup = up.clickOnAddBtn();
		// aup = new AddUserPageClass(driver);

		String prefix = RandonDataUtility.getPrefix();
		String fname = RandonDataUtility.getFirstName();
		String lname = RandonDataUtility.getLastName();
		String email = RandonDataUtility.getEmail_Utility();
		String password = RandonDataUtility.getPassword();
		int roleIndex = RandonDataUtility.getRandomRoleIndex();

		aup.addUser(prefix, fname, lname, email, roleIndex, password, password);
		up.searchForUser(fname);
		up.clickOnDeleteInAction();
		up.searchForUser(fname);
		String actualResult = up.getTextOfEmptySearchResult();
		System.out.println(actualResult);
		Assert.assertTrue(actualResult.contains(ExcelReadUtility.getStringData(5, 1, "User")));

	}

	@Test(priority = 1)
	public void verifyColumnVisibilityFunctionality() throws IOException {
		lp = new LoginPageClass(driver);
		dp = lp.login(ExcelReadUtility.getStringData(2, 0, "Login"), ExcelReadUtility.getIntData(2, 1, "Login"));
		up = dp.navigateToUserPage();
		// up = new UsersPageClass(driver);
		up.clickOnColumnVisibility();
		List<String> actualResult = up.getTextOfUserTableHeaders();
		List<String> expectedResult = Arrays.asList(ExcelReadUtility.getStringData(7, 1, "User"),
				ExcelReadUtility.getStringData(7, 2, "User"), ExcelReadUtility.getStringData(7, 3, "User"));
		System.out.println("Actual Result: " + actualResult);
		System.out.println("Expected Result: " + expectedResult);
		Assert.assertEquals(actualResult, expectedResult);

	}
}
