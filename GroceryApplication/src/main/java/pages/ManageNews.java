package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtitilty;

public class ManageNews {
	public WebDriver driver;
	GeneralUtitilty general=new GeneralUtitilty();
	public ManageNews(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement clicknewbutton;
	@FindBy(xpath = "//textarea[@id='news']")
	WebElement addnewsfield;
	@FindBy(xpath = "//button[@name='create']")
	WebElement savebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertnewscreated;
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")WebElement clickfirstsearchbutton;
	@FindBy(xpath = "//input[@class=\'form-control\']")WebElement searchnewsfield;
	@FindBy(xpath = "//button[@class=\'btn btn-danger btn-fix\'and@name=\'Search\']")WebElement clicklastsearchbutton;
	@FindBy(xpath = "//span[@id='res']")WebElement resultnotfoundmessage;
	
	@FindBy(xpath = "//a[@class=\'btn btn-sm btn btn-danger btncss\']")WebElement newsdeletionbutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")WebElement deletionalert;
	
	
	public ManageNews addNews(String addnews) {
		clicknewbutton.click();
		addnewsfield.sendKeys(addnews);
		savebutton.click();
        return this;
	}
	
	public ManageNews searchNotExistingNews(String searchnews) {
		clickfirstsearchbutton.click();
		searchnewsfield.sendKeys(searchnews);
		
		
		general.clickJavaScriptExecutor(clicklastsearchbutton ,driver);
		
	     return this;

	}	
	
	public ManageNews deleteExistingNews() {
		newsdeletionbutton.click();
		general.acceptAlert(driver);
		return this;
	}
	
	
	public boolean isAlertsDisplayed() {
		return alertnewscreated.isDisplayed();
		

	}
	public boolean isresultfound() {
		return resultnotfoundmessage.isDisplayed();
	}
	public boolean isDeletionAlertDisplayed() {
		return deletionalert.isDisplayed();
	}

	

}
