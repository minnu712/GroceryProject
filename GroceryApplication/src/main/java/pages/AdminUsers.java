package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.GeneralUtitilty;
import utilities.WaitUtilities;

public class AdminUsers {
	public WebDriver driver;
	GeneralUtitilty general = new GeneralUtitilty();
	WaitUtilities wait = new WaitUtilities();

	public AdminUsers(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement clicknewbutton;
	@FindBy(xpath = "//input[@id='username']")
	WebElement enterusername;
	@FindBy(xpath = "//input[@id='password']")
	WebElement enterpassword;
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement selectusertype;
	@FindBy(xpath = "//button[@type='submit'and@name='Create']")
	WebElement clicksavebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertofnewadminadded;

	public AdminUsers addAdmin(String username, String password) {
		clicknewbutton.click();
		enterusername.sendKeys(username + general.generateCurrentDateAndTime());
		enterpassword.sendKeys(password);
		return this;
	}

	public AdminUsers selectUserType() {
		general.selectDropdownWithIndex(selectusertype, 1);
		general.clickJavaScriptExecutor(clicksavebutton, driver);
		return this;
	}

	public boolean isAlertsDisplayed() {
		return alertofnewadminadded.isDisplayed();

	}

}
