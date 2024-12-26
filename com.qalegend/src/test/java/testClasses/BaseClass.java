package testClasses;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import extentReport.ExtentManager;

import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties p;
	
	public static void readProperty() throws IOException
	{
		p=new Properties();
		FileInputStream fs = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\configuration.properties");
		p.load(fs);
	}
	
//	@BeforeClass
//	@Parameters("browser")
//	public void beforeClass(String browserValue) {
//		if(browserValue.equalsIgnoreCase("CHROME")) {
//			driver = new ChromeDriver();
//		}
//		else if (browserValue.equalsIgnoreCase("Edge")) {
//			driver = new EdgeDriver();
//		}
//	}

	@BeforeMethod(groups = {"launch"})
	public void beforeMethod() throws IOException {
		
		readProperty();
		driver=new ChromeDriver();
		driver.get(p.getProperty("Base_url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterMethod(groups = {"close"})
	public void afterMethod() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();

	}
	
	@BeforeSuite
	public void createReport() {
	    ExtentManager.createInstance();
	}
	
	

	

  
  
}
