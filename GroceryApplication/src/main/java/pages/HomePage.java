package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']")
	private WebElement managenewslink;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category'and@class='active nav-link']")
	private WebElement managecategorylink;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact'and@class='small-box-footer']")
	private WebElement managecontactlink;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'and@class=\'small-box-footer\']")
	private WebElement adminuserslink;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext'and @class='small-box-footer']")
	private WebElement managefooterlink;
	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement clickadminbutton;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout'and@class='dropdown-item']")
	WebElement clicklogoutbutton;

	@FindBy(xpath = "//p[@class='login-box-msg']")
	WebElement loginpagetext;

	public ManageNews clickOnManageNews() {
		managenewslink.click();
		return new ManageNews(driver);
	}

	public ManageCategory ClickOnManageCategory() {
		managecategorylink.click();
		return new ManageCategory(driver);
	}

	public ManageContact clickOnManageContact() {
		managecontactlink.click();
		return new ManageContact(driver);
	}

	public AdminUsers clickOnAdminUsers() {
		adminuserslink.click();
		return new AdminUsers(driver);
	}

	public ManageFooter clickOnManageFooter() {
		managefooterlink.click();
		return new ManageFooter(driver);
	}

	public void logoutPage() {
		clickadminbutton.click();
		clicklogoutbutton.click();

	}

	public boolean isLoginPageLoaded() {
		return loginpagetext.isDisplayed();

	}

}
