package automationCore;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constant;
import utilities.ScreenshotUtility;
import utilities.WaitUtilities;

public class BaseClass {
	Properties prop ;
	FileInputStream fs;
	
    WaitUtilities wait = new WaitUtilities();
	public WebDriver driver;

	@BeforeMethod(alwaysRun=true)
	@Parameters("browser")
	public void initialiseBrowser(String browser) throws Exception {
		prop = new Properties();
		fs=new FileInputStream(Constant.CONFIGFILE);
		prop.load(fs);
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			
			
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else {
			throw new Exception("invalid browser");
		}
		
		
		driver.get(prop.getProperty("url"));
		wait.implicitWait(driver);
		
	}

	@AfterMethod(alwaysRun=true)

	public void driverQuit(ITestResult itestresult) throws IOException {
		if (itestresult.getStatus() == ITestResult.FAILURE) {
			ScreenshotUtility screenshot = new ScreenshotUtility();
			screenshot.getScreenshot(driver, itestresult.getName());
		}
		// driver.quit();

	}
	
}
