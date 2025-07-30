package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FakerUtility;

public class ManageFooter {
	public WebDriver driver;
	FakerUtility faker = new FakerUtility();

	public ManageFooter(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href=\'https://groceryapp.uniqassosiates.com/admin/Footertext/edit?edit=2\']")
	WebElement clickactionbutton;
	@FindBy(xpath = "//textarea[@id='content']")
	WebElement enteraddress;
	@FindBy(xpath = "//input[@id='email']")
	WebElement enteremail;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement enterphonenumber;
	@FindBy(xpath = "//button[@name='Update']")
	WebElement clickupadtebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertoffootertext;

	public ManageFooter updateFooterText() {
		clickactionbutton.click();
		enteraddress.clear();
		String address = faker.generateAddress();
		enteraddress.sendKeys(address);
		enteremail.clear();
		String email = faker.generateEmail();
		enteremail.sendKeys(email);
		enterphonenumber.clear();
		String number = faker.generatephonenumber();
		enterphonenumber.sendKeys(number);
		clickupadtebutton.click();
		return this;
	}

	public boolean isAlertsDisplayed() {
		return alertoffootertext.isDisplayed();

	}

}
