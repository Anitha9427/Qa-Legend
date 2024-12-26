package testClasses;

import java.awt.Checkbox;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import UtilityClasses.ExcelReadClass;
import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import retryAnalyser.RetryAnalyser_class;

public class LoginPageTestClass extends BaseClass {

	LoginPageClass lp;
	HomePageClass hp;

	@Test(priority = 4,retryAnalyzer = RetryAnalyser_class.class,groups = {"functional"})
	public void verifySuccessfulLogin() throws IOException {
		lp = new LoginPageClass(driver); // constructor is called here.
		hp = lp.login(ExcelReadClass.getStringdata(0, 0), ExcelReadClass.getIntegerdata(0, 1)); // after login we go to home page.concept is known as chaining of pages.
		hp.clickOnEndTour();
		String actualRes = hp.getTextOfWelcomeAdmin();
		System.out.println(actualRes);
		String expRes=ExcelReadClass.getStringdata(5, 0);
	//	Assert.assertTrue(actualRes.contains(ExcelReadClass.getStringdata(5, 0)));
		Assert.assertEquals(actualRes, expRes);
		
	}

	@Test(priority = 2,retryAnalyzer = RetryAnalyser_class.class)
	public void verifyRememberMeCheckBoxIsSelectedByDefault() {
		lp = new LoginPageClass(driver);

		boolean actualRes = lp.isRememeberMeCheckBoxSelected();
		Assert.assertFalse(actualRes, "The checkBox is not selected");

	}

	@Test(dataProviderClass = DataProviderClassHome.class, dataProvider = "UnsuccessfullLogin", priority = 3,retryAnalyzer = RetryAnalyser_class.class,groups = {"functional"})
	public void verifyUnsuccessfullLogin(String userName, String passWord) throws IOException {
		lp = new LoginPageClass(driver);
		hp = lp.login(userName, passWord);
		String actualRes = lp.getTextOfErrorMessage();
		System.out.println(actualRes);
		String expectedRes = ExcelReadClass.getStringdata(6, 0);
		Assert.assertEquals(actualRes, expectedRes);

	}

	@Test(priority = 1,retryAnalyzer = RetryAnalyser_class.class)
	public void verifyTheExactURL_OpensWhileHittingTheBaseURL() {
		lp = new LoginPageClass(driver);
		String actRes = lp.getUrlOfThePage();
		String expectedRs = "https://qalegend.com/billing/public/login";
		Assert.assertEquals(actRes, expectedRs);
	}

	@Test(priority = 5,retryAnalyzer = RetryAnalyser_class.class)

	public void verifyResetPasswordPageComingWhileClickingOnForgotYourPassword() {
		lp = new LoginPageClass(driver);
		lp.clickOnForgotPassword();
		System.out.println(lp.getTextOfResetPassword());
		String act = lp.getTextOfResetPassword();
		String exp = "Reset Password";

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(act, exp);
		soft.assertAll();

	}
}
