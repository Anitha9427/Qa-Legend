package UtilityClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {
	
	public void clickOnElement(WebElement element) {
		element.click();
	}
	
	public void clearTheField(WebElement element) {
		element.clear();
		
	}
	
	public void typeOnElement(WebElement element,String value) {
		element.sendKeys(value);
	}
	
	
	public String getTextOfElement(WebElement element) {
		return element.getText();
	}
	
	public String getAttributeValueOfElement(WebElement element,String attributeName) {
		return element.getAttribute(attributeName);
	}
	
	public String getTitleOfThePage(WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}
	
	public boolean isElementEnabled(WebElement element) {
		return element.isEnabled();
	}
	
	public boolean isElementSelected(WebElement element) {
		return element.isSelected();
	}
	
	public void addThreadSleep()throws InterruptedException  {
		Thread.sleep(3000);
	}
	
	public void ClickAnElementJS(WebDriver driver,WebElement element) {
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",element);
	}
public void scrollToFindAnElement(WebDriver driver,WebElement element) {
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",element);
	}
	public String getTextOfAlertMsg(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	
	public void acceptTheAlertMsg(WebDriver driver) {
		 driver.switchTo().alert().accept();
	}
	
	public void dismissTheAlertMsg(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public void enterMsgInTheAlertBox(WebDriver driver , String value) {
		driver.switchTo().alert().sendKeys(value);
	}
	
	public void selectByIndexDropDown(WebElement element,int Index) {
		Select select=new Select(element);
		select.selectByIndex(Index);
	}
	
	public void selectByValueDropDown(WebElement element,String value) {
		Select select=new Select(element);
		select.selectByValue(value);
	}
	
	public void selectByVisibleTextDropDown(WebElement element,String visibleText) {
		Select select=new Select(element);
		select.selectByVisibleText(visibleText);
	}
	
	public List<WebElement> getAllSelectedOptionsDropDown(WebElement element) {
		Select select=new Select(element);
		return select.getAllSelectedOptions();
	}
	
	public void getFirstSelectedOptionDropDown(WebElement element) {
		Select select=new Select(element);
		select.getFirstSelectedOption();
	}
	
	public void deSelectByIndexDropDown(WebElement element,int Index) {
		Select select=new Select(element);
		select.deselectByIndex(Index);
		
	}
	
	public void deSelectByValueDropDown(WebElement element,String value) {
		Select select=new Select(element);
		select.deselectByValue(value);
	}
	
	public void deSelectByVisibleTextDropDown(WebElement element,String value) {
		Select select=new Select(element);
		select.deselectByVisibleText(value);
	}
	
	public void pressEnterKey(WebDriver driver) {
		
		Actions a=new Actions(driver);
		a.keyDown(Keys.ENTER).build().perform();
	}
	
	public void deSelectAllOptions(WebElement element) {
		Select select=new Select(element);
		select.deselectAll();
	}
	
	public WebElement getCssValue(WebElement element,String text) {
		return element.findElement(By.cssSelector(text));
	}
	
		
	public void moveTheMouseToTheElement(WebDriver driver,WebElement target) {
	
	    Actions b=new Actions(driver);
	    b.moveToElement(target).build().perform();
	    
	}
	
	public boolean toCheckDropDownIsMultiple(WebElement element) {
		Select select=new Select(element);
		return select.isMultiple();
		
	}
	public void dragAndDrop(WebDriver driver,WebElement source,WebElement target) {
		Actions action=new Actions(driver);
		action.dragAndDrop(source, target);
	}

	
		
	}

	
	
	
		
	
	


