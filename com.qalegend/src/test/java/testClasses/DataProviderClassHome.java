package testClasses;

import org.testng.annotations.Test;

import UtilityClasses.ExcelReadClass;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderClassHome {
	// @Test(dataProvider = "dp2",dataProviderClass=LoginPageTestClass.class)
	// public void verifyUnsuccessfullLogin(String userName , String passWord) {
//  }

	@DataProvider(name = "UnsuccessfullLogin")
	public Object[][] dp2() throws IOException {
		return new Object[][] {
				new Object[] { ExcelReadClass.getStringdata(1, 0), ExcelReadClass.getIntegerdata(1, 1) },
				new Object[] { ExcelReadClass.getStringdata(2, 0), ExcelReadClass.getIntegerdata(2, 1) },
				new Object[] { ExcelReadClass.getStringdata(3, 0), ExcelReadClass.getIntegerdata(3, 1) }

		};
	}
}
