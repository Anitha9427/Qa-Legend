package testClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import UtilityClasses.ExcelReadClass;
import UtilityClasses.RandomData_Utility;
import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import pageClasses.ManageUser;
import pageClasses.ProductListPageClass;
import retryAnalyser.RetryAnalyser_class;

public class ManageUserTestClass extends BaseClass {
	
	LoginPageClass lp;
	HomePageClass hp;
	ManageUser mp;
	ProductListPageClass pl;
	
	@Test(retryAnalyzer = RetryAnalyser_class.class)
	public void verifyTheManageUsersPageIsOpenWhileClickingOnUsers() throws InterruptedException, IOException {
		lp = new LoginPageClass(driver);
		hp = lp.login(ExcelReadClass.getStringdata(0, 0), ExcelReadClass.getIntegerdata(0, 1));
		hp.clickOnEndTour();
		hp.clickOnUserManagement();
		mp = hp.clickOnUsers();
		String actualRes = mp.GetTextOfManageUsersHeading();
		Assert.assertTrue(actualRes.contains("Manage"));

	}
	
  @Test(retryAnalyzer = RetryAnalyser_class.class,groups = {"functional"})
  public void addANewUser() throws InterruptedException, IOException {
	  
	  String uName=RandomData_Utility.getNewUserFullName();
	  String passWord=RandomData_Utility.getPassword();
	 
	  lp=new LoginPageClass(driver)  ;
		hp=lp.login(ExcelReadClass.getStringdata(0, 0), ExcelReadClass.getIntegerdata(0, 1));
		hp.clickOnEndTour();
		hp.clickOnUserManagement();
		mp=hp.clickOnUsers();
		mp.addUserInManageUsers(uName,RandomData_Utility.getRandomEmail(),passWord,passWord);
        mp.searchAddedUserUsingSearchBar(uName);
		boolean actName=mp.isCreatedNameDisplayed();
		
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(actName);
		soft.assertAll();
		System.out.println("User added successfully!!!");

		}
}
