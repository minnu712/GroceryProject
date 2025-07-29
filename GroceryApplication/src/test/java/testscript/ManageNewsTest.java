package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.BaseClass;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageFooter;
import pages.ManageNews;

public class ManageNewsTest extends BaseClass {
	LoginPage login;
	HomePage home;
	ManageNews news;
	@Test(groups="smoke")

	public void verifyAddNewNewsWithValidData() throws IOException {
		login = new LoginPage(driver);
		home=login.loginUsingExcelData();
		news=home.clickOnManageNews().addNews("Kottayam district declared red alert");
		boolean isalertdispalyed = news.isAlertsDisplayed();
		Assert.assertTrue(isalertdispalyed, Constant.nw_verifyAddNewNewsWithValidData);
	}

	@Test

	public void verifyNotExistingNews() throws IOException {
		login = new LoginPage(driver);
		home=login.loginUsingExcelData();
		HomePage home = new HomePage(driver);
		news=home.clickOnManageNews().searchNotExistingNews("There is no such news");
		boolean isresultnotfound = news.isresultfound();
		Assert.assertTrue(isresultnotfound, Constant.nw_verifyNotExistingNews);
		
	}

	@Test(groups="smoke")
	public void verifyExistingNewsDeleted() throws IOException {
		 login = new LoginPage(driver);
		home=login.loginUsingExcelData();
		HomePage home = new HomePage(driver);
		news=home.clickOnManageNews().deleteExistingNews();
		boolean isalertdisplay = news.isDeletionAlertDisplayed();
		Assert.assertTrue(isalertdisplay, Constant.nw_verifyExistingNewsDeleted);

	}

}
