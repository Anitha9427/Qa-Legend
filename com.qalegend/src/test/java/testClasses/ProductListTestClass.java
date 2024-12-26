package testClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import UtilityClasses.ExcelReadClass;
import UtilityClasses.FileUpload;
import UtilityClasses.RandomData_Utility;
import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import pageClasses.ProductListPageClass;
import retryAnalyser.RetryAnalyser_class;

public class ProductListTestClass extends BaseClass {
	LoginPageClass lp;
	HomePageClass hp;
	ProductListPageClass pl;

	@Test(priority = 1, retryAnalyzer = RetryAnalyser_class.class)
	public void verifyTheListOfProductPageIsOpenedWhilwClickingOnListProducts() throws IOException {

		lp = new LoginPageClass(driver);
		hp = lp.login(ExcelReadClass.getStringdata(0, 0), ExcelReadClass.getIntegerdata(0, 1));
		hp.clickOnEndTour();
		hp.clickOnProductButton();
		pl = hp.clickOnListProducts();
		String res = pl.verifyProductPageIsOpened();
		Assert.assertTrue(res.contains("Manage your products"));

	}

	@Test(priority = 2, retryAnalyzer = RetryAnalyser_class.class,groups = {"functional"})
	public void verifyToCreateAnewProduct() throws InterruptedException, IOException {

		String prodName = RandomData_Utility.getProductName();

		lp = new LoginPageClass(driver);
		hp = lp.login(ExcelReadClass.getStringdata(0, 0), ExcelReadClass.getIntegerdata(0, 1));
		hp.clickOnEndTour();
		hp.clickOnProductButton();
		pl = hp.clickOnListProducts();
		pl.clickOnAddProduct();
		pl.addNewProduct(prodName, RandomData_Utility.getProductAlertQuantity(),
				System.getProperty("user.dir") + "\\src\\test\\resources\\Aggregation.jpg",
				RandomData_Utility.getExpirirngPeriod(), RandomData_Utility.getExactTax());
		pl.searchAlreadyAddedProductInSearchBox(prodName);
		pl.scrollToFindDeleteSelectedButton();
		String actR = pl.toGetTheTextOfNameFieldAfterSearch();
		System.out.println(actR);
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(actR.contains(prodName), "The product not added successfully");
		soft.assertAll();
		System.out.println("Product added successfully");

	}

	@Test(priority = 3, retryAnalyzer = RetryAnalyser_class.class,groups = {"functional"})
	public void verifyToDeleteTheAddedProduct() throws InterruptedException, IOException {

		String prodName = RandomData_Utility.getProductName();

		lp = new LoginPageClass(driver);
		hp = lp.login(ExcelReadClass.getStringdata(0, 0), ExcelReadClass.getIntegerdata(0, 1));
		hp.clickOnEndTour();
		hp.clickOnProductButton();
		pl = hp.clickOnListProducts();
		pl.clickOnAddProduct();
		pl.addNewProduct(prodName, RandomData_Utility.getProductAlertQuantity(),
				System.getProperty("user.dir") + "\\src\\test\\resources\\Aggregation.jpg",
				RandomData_Utility.getExpirirngPeriod(), RandomData_Utility.getExactTax());
		pl.searchAlreadyAddedProductInSearchBox(prodName);
		pl.scrollToFindDeleteSelectedButton();
		// pl.searchAlreadyAddedProductInSearchBox(prodName);

		// pl.scrollToFindActionButton();

		pl.deleteAddedProduct(prodName);

		boolean actualRes = pl.isNoRecordsDisplayedAfterDeletion();
		System.out.println(actualRes);
		Assert.assertTrue(actualRes);
		System.out.println("Product deleted Successfully");
	}

}
