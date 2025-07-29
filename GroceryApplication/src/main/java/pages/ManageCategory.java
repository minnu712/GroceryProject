package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constant;
import utilities.FileUploadUtility;
import utilities.GeneralUtitilty;

public class ManageCategory {

	public WebDriver driver;
	GeneralUtitilty general = new GeneralUtitilty();
	FileUploadUtility file = new FileUploadUtility();

	public ManageCategory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@href=\"https://groceryapp.uniqassosiates.com/admin/Category/status?id=2714&st=inactive&page_ad=1\"]")
	WebElement clickactivebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement categoryalertdisplayed;

	@FindBy(xpath = "//i[@class=\'fas fa-edit\']")
	WebElement clickactionbutton;
	@FindBy(xpath = "//input[@id='category']")
	WebElement entercategory;
	@FindBy(xpath = "//li[@id='134-selectable']")
	WebElement clickdiscountbutton;
	@FindBy(xpath = "//input[@type='file']")
	WebElement fileupload;
	@FindBy(xpath = "//button[@name='update']")
	WebElement clicksavebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement categoryaddedalert;

	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-danger btncss']")
	WebElement clickcategorydeletebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertofcategorydelete;

	public ManageCategory categoryStatus() {
		clickactivebutton.click();
		return this;
	}

	public boolean isAlertDisplay() {
		return categoryalertdisplayed.isDisplayed();

	}

	public ManageCategory updateCategory(String category) {
		clickactionbutton.click();
		entercategory.clear();
		entercategory.sendKeys(category + general.generateCurrentDateAndTime());
		clickdiscountbutton.click();
		return this;

	}

	public ManageCategory fileUploadSendkeys() {

		String filepath = Constant.imagepath;
		file.fileUploadSendkeys(fileupload, filepath);
		clicksavebutton.click();
		return this;
	}

	public ManageCategory deleteExistingCategory() {
		clickcategorydeletebutton.click();
		general.acceptAlert(driver);
		return this;
	}

	public boolean isAlertsDisplay() {
		return categoryaddedalert.isDisplayed();

	}

	public boolean isDeletionAlertDisplayed() {
		return alertofcategorydelete.isDisplayed();
	}

}
