package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClasses.ExplicitWaitClass;
import UtilityClasses.FileUpload;

import UtilityClasses.GeneralUtilities;

public class ProductListPageClass {

	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();
	ExplicitWaitClass el = new ExplicitWaitClass();

	public ProductListPageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//small[contains(text(),'Manage your products')]")
	WebElement manageYourProduct;

	@FindBy(xpath = "//a[@href='https://qalegend.com/billing/public/products/create']")
	WebElement addProductButton;

	@FindBy(xpath = "//input[@placeholder='Product Name']")
	WebElement productName;

	@FindBy(xpath = "//input[@type='number']")
	WebElement alertQuantity;

	@FindBy(id = "upload_image")
	WebElement browseButton;

	@FindBy(id = "expiry_period")
	WebElement expiryPerid;

	@FindBy(xpath = "(//input[@placeholder='Exc. tax'])[1]")
	WebElement exacTax;

	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveButton;

	@FindBy(css = "input[type='search']")
	WebElement search;

	@FindBy(xpath = "//table[@id='product_table']/tbody/tr/td[3]")
	WebElement searchedProdName;

	@FindBy(css = "input.row-select[type='checkbox']")
	WebElement checkbox;

	@FindBy(css = "input#delete-selected")
	WebElement deleteSelected;

	@FindBy(xpath = "//button[contains(@class,'tn-info dropdown-toggle btn-xs')]")
	WebElement action;

	@FindBy(xpath = "//a[@class='delete-product']")
	WebElement deleteBtn;

	@FindBy(xpath = "//button[text()='OK']")
	WebElement deleteOk;

	@FindBy(xpath = "//table[@id='product_table']/tbody/tr/td")
	WebElement recordsEmpty;

	public String verifyProductPageIsOpened() {
		return gl.getTextOfElement(manageYourProduct);
	}

	public void clickOnAddProduct() {
		gl.clickOnElement(addProductButton);
	}

	public void addNewProduct(String prname, String alertqnty, String filePath, String expiry, String tax) {

		gl.typeOnElement(productName, prname);
		gl.typeOnElement(alertQuantity, alertqnty);
		FileUpload.fileUploading(browseButton, filePath);
		gl.typeOnElement(expiryPerid, expiry);
		gl.scrollToFindAnElement(driver, exacTax);
		el.presenceOfElementLocatedWaitXpath(driver, "(//input[@placeholder='Exc. tax'])[1]");
		// el.visibiltyOf(driver, exacTax);
		gl.typeOnElement(exacTax, tax);
		gl.clickOnElement(saveButton);

	}

	public void searchAlreadyAddedProductInSearchBox(String searchData) {

		el.visibiltyOf(driver, search);
		gl.typeOnElement(search, searchData);

	}

	public String toGetTheTextOfNameFieldAfterSearch() {

		el.visibiltyOf(driver, searchedProdName);

		return gl.getTextOfElement(searchedProdName);

	}

	public void deleteAddedProduct(String prodName) throws InterruptedException {
		
		
		el.presenceOfElementLocatedWaitXpath(driver,"//button[contains(@class,'tn-info dropdown-toggle btn-xs')]");
		gl.scrollToFindAnElement(driver, action);
		gl.ClickAnElementJS(driver, action);
		gl.clickOnElement(deleteBtn);
		el.elementToBeClickableWait(driver, deleteOk);
		gl.clickOnElement(deleteOk);
		gl.addThreadSleep();

	}


	public void scrollToFindDeleteSelectedButton() throws InterruptedException {

		gl.addThreadSleep();
		gl.scrollToFindAnElement(driver, deleteSelected);
	}

	public boolean isNoRecordsDisplayedAfterDeletion() {

		el.presenceOfElementLocatedWaitXpath(driver, "//table[@id='product_table']/tbody/tr/td");
		return gl.isElementDisplayed(recordsEmpty);
	}

	// public void scrollToFindActionButton() throws InterruptedException {

	// gl.scrollToFindAnElement(driver, action);

//	}

}
