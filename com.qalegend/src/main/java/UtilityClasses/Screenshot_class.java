package UtilityClasses;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot_class {

	public static void takeScreenShot(WebDriver driver, String testcasename) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;                 // TakesScreenshot is the interface and then inistantiate
		File screenshotFile = ts.getScreenshotAs(OutputType.FILE);     // File is the class and use getScreenshotAs method
																       // to store as File

		String dest = System.getProperty("user.dir") + "//Test_Evidence";   // create a folder inside project named 'Test
																			// Evidence' & We use user.dir used get the
		File f1 = new File(dest);
		if (!f1.exists()) {               // this is to check if already a folder is created
			f1.mkdirs();                  // this is to create a file
		}
			String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
			// Date import java.util

			String destinationPath = System.getProperty("user.dir") + "//Test_Evidence//" + testcasename + timeStamp + ".png"; // format
			// to
			// save
			// file
			File finalDestination = new File(destinationPath);
			FileHandler.copy(screenshotFile, finalDestination);//it is used to copy the screenshot to test_evidence folder

		
	}

}
