package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtilities {
	public static int IMPLICITWAIT_DURATION=10;
	public static int EXPLICITWAIT_DURATION=20;
	public static int FLUENTWAIT_DURATION=3;
	public void fluentWaitElements(WebDriver driver, WebElement element, String attribute, String attributeValue,
			int total) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(total))
				.pollingEvery(Duration.ofSeconds(FLUENTWAIT_DURATION)).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.attributeContains(element, attribute, attributeValue));
	}
	public void waitForWebElementAlert(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT_DURATION));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	public void waitForWebElementclick(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT_DURATION));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForWebElementselect(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT_DURATION));
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	public void waitForWebElementinvisible(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT_DURATION));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public void waitForWebElementselectionstatetobe(WebDriver driver,WebElement element,boolean value) { //..check
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT_DURATION));
		wait.until(ExpectedConditions.elementSelectionStateToBe(element,value));
	
	}
	public void waitForWebElementurl(WebDriver driver,String element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT_DURATION));
		wait.until(ExpectedConditions.urlToBe(element));
	}
	
	
	
	public void implicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITWAIT_DURATION));
	}
}
