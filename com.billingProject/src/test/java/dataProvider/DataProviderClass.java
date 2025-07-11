package dataProvider;

import org.testng.annotations.Test;

import utility.ExcelReadUtility;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	

	@DataProvider(name = "unSuccessfullLogin")
	public Object[][] dp() throws IOException {
		return new Object[][] {

				new Object[] { ExcelReadUtility.getStringData(5, 0, "Login"),
						ExcelReadUtility.getIntData(5, 1, "Login") },
				new Object[] { ExcelReadUtility.getStringData(6, 0, "Login"),
						ExcelReadUtility.getIntData(6, 1, "Login") },
				new Object[] { ExcelReadUtility.getStringData(7, 0, "Login"),
						ExcelReadUtility.getIntData(7, 1, "Login") }, };
	}

	
}
