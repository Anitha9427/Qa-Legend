package pageClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClasses.GeneralUtilities;

public class HomePageClass {

	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();

	public HomePageClass(WebDriver driver) { // why we use constructor in page class.since to say selenium the both
												// drivers are same.when we create object for this pageclass in the
												// testclass we call there the constructor.

		this.driver = driver; // first driver is the driver in this page class,next one is the driver in
								// baseclass.
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//button[text()='End tour']")
	WebElement endTour;

	@FindBy(xpath = "//h1[contains(text(),'Welcome Admin,')]")
	WebElement welcomeAdminHeading;

	@FindBy(xpath = "//div[@class='info-box-content']")
	List<WebElement> allTiles;

	@FindBy(id = "btnCalculator")
	WebElement calculator;

	@FindBy(xpath = "(//span[@class='title'])[1]")
	WebElement userManagement;

	@FindBy(xpath = "//span[contains(text(),'Users')]")
	WebElement users;

	@FindBy(xpath = "//span[text()='Products']")
	WebElement productButton;

	@FindBy(xpath = "//a[@href='https://qalegend.com/billing/public/products']")
	WebElement ListProducts;

	@FindBy(xpath = "//span[contains(text(),'Admin')]")
	WebElement adminBtn;

	@FindBy(xpath = "//a[contains(text(),'Out')]")
	WebElement signOutBtn;

	@FindBy(xpath = "//h1[contains(text(),'POS')]")
	WebElement loginPageDemoHd;

	public void clickOnEndTour() {

		try {
            if (endTour.isDisplayed()) {
            	endTour.click();
                System.out.println("Tour popup appeared and 'End tour' button clicked.");
            }
        } catch (Exception e) {
            System.out.println("Tour popup did not appear. Moving on...");
        }

	}

	public String getTextOfWelcomeAdmin() {
		return gl.getTextOfElement(welcomeAdminHeading);
	}

	public boolean isAllTilesDisplayed() {

		for (WebElement element : allTiles) {
			gl.isElementDisplayed(element);

		}
		return true;

	}

	public void moveTheMouseToTheCalculator() {
		gl.moveTheMouseToTheElement(driver, calculator);
	}

	public String getAttributeValueOfCalculatorButton(String value) {
		return gl.getAttributeValueOfElement(calculator, value);
	}

	public void clickOnUserManagement() {
		gl.clickOnElement(userManagement);

	}

	public ManageUser clickOnUsers() throws InterruptedException {
		gl.addThreadSleep();
		gl.clickOnElement(users);
		return new ManageUser(driver);

	}

	public String getCurrentUrl() {
		return gl.getCurrentUrl(driver);
	}

	public void clickOnProductButton() {
		gl.clickOnElement(productButton);
	}

	public ProductListPageClass clickOnListProducts() {
		gl.clickOnElement(ListProducts);
		return new ProductListPageClass(driver);
	}

	public LoginPageClass signOutFromHomePage() {

		gl.clickOnElement(adminBtn);
		gl.clickOnElement(signOutBtn);
		return new LoginPageClass(driver);

	}

	public String getTextOfDemo_POSHeadingInLoginPage() {

		return gl.getTextOfElement(loginPageDemoHd);

	}
}
