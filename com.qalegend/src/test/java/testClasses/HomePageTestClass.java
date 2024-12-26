package testClasses;

import org.testng.annotations.Test;

import UtilityClasses.ExcelReadClass;
import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import pageClasses.ManageUser;
import retryAnalyser.RetryAnalyser_class;

import java.io.IOException;

import org.testng.Assert;

public class HomePageTestClass extends BaseClass {

	LoginPageClass lp;
	HomePageClass hp;
	ManageUser mp;

	@Test(retryAnalyzer = RetryAnalyser_class.class)
	public void verifyAllTilesDisplayedOnHomePage() throws InterruptedException, IOException {

		lp = new LoginPageClass(driver);
		hp = lp.login(ExcelReadClass.getStringdata(0, 0), ExcelReadClass.getIntegerdata(0, 1));
		hp.clickOnEndTour();
		boolean actRes = hp.isAllTilesDisplayed();
		Assert.assertTrue(actRes);

	}

	@Test(retryAnalyzer = RetryAnalyser_class.class)
	public void verifyTheToolTipCalculatorIsShowingWhileHoveringTheMouseOnCalculator() throws InterruptedException, IOException {
		lp = new LoginPageClass(driver);
		hp = lp.login(ExcelReadClass.getStringdata(0, 0), ExcelReadClass.getIntegerdata(0, 1));
		hp.clickOnEndTour();
		hp.moveTheMouseToTheCalculator();
		String disAct = hp.getAttributeValueOfCalculatorButton("data-original-title");
		Assert.assertTrue(disAct.contains("Calculator"));
		System.out.println(disAct);
	}

	

	@Test(retryAnalyzer = RetryAnalyser_class.class,groups = {"functional"})
	public void verifySuccessfulSignOut() throws IOException {

		lp = new LoginPageClass(driver);
		hp = lp.login(ExcelReadClass.getStringdata(0, 0), ExcelReadClass.getIntegerdata(0, 1));
		hp.clickOnEndTour();
		lp = hp.signOutFromHomePage();
		String actualRes = hp.getTextOfDemo_POSHeadingInLoginPage();
		String expectedRes = "Demo POS";
		Assert.assertEquals(actualRes, expectedRes);
		System.out.println("Signed Out Successfully!!!");

	}

	
	

}
