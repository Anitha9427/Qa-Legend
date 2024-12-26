package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClasses.GeneralUtilities;

public class LoginPageClass {
	WebDriver driver;

	GeneralUtilities gl = new GeneralUtilities(); // instantiate this class here to get the utilities here.

	public LoginPageClass(WebDriver driver) { // why we use constructor in page class.since to say selenium the both
												// drivers are same.when we create object for this pageclass in the
												// testclass we call there the constructor.

		this.driver = driver; // first driver is the driver in this page class,next one is the driver in
								// baseclass.
		PageFactory.initElements(driver, this); // basefactory is a class,initelemnts is a static
												// method,driver.findElements(use cheitu elements initialize cheyyanda.)
	}

	@FindBy(id = "username")
	WebElement username; // this is how we locate element in pom using page factory.

	@FindBy(id = "password")
	WebElement password;

	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement loginButton;

	@FindBy(xpath = "//strong[contains(text(),'credentials')]")
	WebElement unsuccessfulLoginMsg;

	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement checkBox;

	@FindBy(xpath = "//a[contains(@class,'btn-link')]")
	WebElement forgotPassword;

	@FindBy(css = "div.panel-heading")
	WebElement resetPassword;

	public HomePageClass login(String uname, String pass) { // can b used for both success and unsuccess login.

		gl.typeOnElement(username, uname);
		gl.typeOnElement(password, pass);
		gl.clickOnElement(loginButton);

		return new HomePageClass(driver); /// login button click cheyumbo homepage pokum,so we give here homepageclass
											/// return here.

	}

	public String getTextOfErrorMessage() {

		return gl.getTextOfElement(unsuccessfulLoginMsg);
	}

	public boolean isRememeberMeCheckBoxSelected() {
		return gl.isElementSelected(checkBox);
	}

	public String getUrlOfThePage() {
		return gl.getCurrentUrl(driver);
	}

	public void clickOnForgotPassword() {
		gl.clickOnElement(forgotPassword);
	}

	public String getTextOfResetPassword() {
		return gl.getTextOfElement(resetPassword);
	}

}
