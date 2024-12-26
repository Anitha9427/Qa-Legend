package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClasses.ExplicitWaitClass;
import UtilityClasses.GeneralUtilities;

public class ManageUser {

	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();
	ExplicitWaitClass el=new ExplicitWaitClass();

	public ManageUser(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//small[contains(text(),'Manage')]")
	WebElement manageUsersHeading;

	@FindBy(xpath = "//a[contains(@class,'btn-primary')]")
	WebElement addButton;

	@FindBy(id = "first_name")
	WebElement firstName;

	@FindBy(xpath = "//input[@id='email']")
	WebElement email;

	@FindBy(xpath = "//input[@id='password']")
	WebElement password;

	@FindBy(xpath = "//input[@id='username']")
	WebElement username;

	@FindBy(xpath = "//input[@id='confirm_password']")
	WebElement confirmPassword;

	@FindBy(id ="submit_user_button")
	WebElement saveButton;

	@FindBy(css = "input[type='search']")
	WebElement searchBar;

	@FindBy(xpath = "//table[@id='users_table']/tbody/tr/td[2]")
	WebElement nameField;

	public String GetTextOfManageUsersHeading() {

		return gl.getTextOfElement(manageUsersHeading);
	}

	public void addUserInManageUsers(String fName, String emailId, String pWord, String conPassword) throws InterruptedException {
		gl.clickOnElement(addButton);
		gl.typeOnElement(firstName, fName);
		gl.typeOnElement(email, emailId);
		gl.typeOnElement(password, pWord);
		gl.typeOnElement(confirmPassword, conPassword);
	
		gl.scrollToFindAnElement(driver, saveButton);
		
		gl.ClickAnElementJS(driver,saveButton);
		gl.addThreadSleep();
	}

	public void searchAddedUserUsingSearchBar(String value) {
		gl.typeOnElement(searchBar, value);
	}

	public String toGetTheTextOfValueUnderNameFieldAfterSearching() {
		
		//el.presenceOfElementLocatedWaitXpath(driver,"//table[@id='users_table']/tbody/tr/td[2]");
		return gl.getTextOfElement(nameField);

	}
	
	public boolean isCreatedNameDisplayed() {
		return gl.isElementDisplayed(nameField);
	}

}
