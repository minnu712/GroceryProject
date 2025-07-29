package testscript;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.BaseClass;
import constants.Constant;
import pages.AdminUsers;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageCategory;
import pages.ManageFooter;

public class ManageFooterTest extends BaseClass {
	LoginPage login;
	HomePage home;
	ManageFooter manage;
	@Test
	public void updateFooterTextWithValidData() throws IOException {

		login = new LoginPage(driver);
		home=login.loginUsingExcelData();
		manage=home.clickOnManageFooter().updateFooterText();
		boolean isalertdispalyed = manage.isAlertsDisplayed();
		Assert.assertTrue(isalertdispalyed, Constant.upf_updateFooterTextWithValidData);
	}

}
