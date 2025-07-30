package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtility;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='username']")
	WebElement usernamefield;
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordfield;
	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	WebElement loginbutton;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible' ]")
	WebElement Alertmessage;
	@FindBy(xpath = "//span[@class='brand-text font-weight-light']")
	WebElement Homepagetext;

	public void enterUsernameOnUsernamefield(String username) {
		usernamefield.sendKeys(username);
		
	}

	public void enterPassword(String password) {
		passwordfield.sendKeys(password);

	}

	public HomePage clickOnloginbutton() {
		loginbutton.click();
		return new HomePage(driver);
		
	}

	public boolean isHomepageLoaded() {
		return Homepagetext.isDisplayed();

	}

	public boolean isAlertDisplayed() {
		return Alertmessage.isDisplayed();
	}

	public HomePage loginUsingExcelData() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "Loginpage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		usernamefield.sendKeys(username);
		passwordfield.sendKeys(password);
		loginbutton.click();
		return new HomePage(driver);

	}
}

