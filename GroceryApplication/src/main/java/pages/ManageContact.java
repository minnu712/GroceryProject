package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.javafaker.Faker;

import utilities.FakerUtility;
import utilities.GeneralUtitilty;

public class ManageContact {
	public WebDriver driver;
	GeneralUtitilty general = new GeneralUtitilty();
	FakerUtility faker = new FakerUtility();

	public ManageContact(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//i[@class='fas fa-edit']")
	WebElement clickactionbutton;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement enterphonenumber;
	@FindBy(xpath = "//input[@id='email']")
	WebElement enteremail;
	@FindBy(xpath = "//textarea[@name='address']")
	WebElement enteraddress;
	@FindBy(xpath = "//textarea[@name='del_time']")
	WebElement enterdeliverytime;
	@FindBy(xpath = "//input[@id=\'del_limit\']")
	WebElement enterdeliverychargelimit;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement clickupdatebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertofupdatecontact;

	public ManageContact editContact(String deliverytime, String chargelimit) {
		clickactionbutton.click();
		enterphonenumber.clear();
		String number = faker.generatephonenumber();
		enterphonenumber.sendKeys(number);
		enteremail.clear();
		String email = faker.generateEmail();
		enteremail.sendKeys(email);
		enteraddress.clear();
		String address = faker.generateAddress();
		enteraddress.sendKeys(address);
		enterdeliverytime.clear();
		enterdeliverytime.sendKeys(deliverytime);
		enterdeliverychargelimit.clear();
		enterdeliverychargelimit.sendKeys(chargelimit);
		general.clickJavaScriptExecutor(clickupdatebutton, driver);
		return this;
	}

	public boolean isAlertsDisplayed() {
		return alertofupdatecontact.isDisplayed();

	}

}
