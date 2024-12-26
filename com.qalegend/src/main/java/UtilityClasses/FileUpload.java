package UtilityClasses;

import org.openqa.selenium.WebElement;

public class FileUpload {

	public static void fileUploading(WebElement element,String filePath) {
		element.sendKeys(filePath);
		
		

	}

}
