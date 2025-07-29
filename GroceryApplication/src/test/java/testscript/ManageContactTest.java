package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.BaseClass;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageCategory;
import pages.ManageContact;

public class ManageContactTest extends BaseClass {
	LoginPage login;
	HomePage home;
	ManageContact contact;
	@Test
	public void updateContactWithValidData() throws IOException {
		login = new LoginPage(driver);
		home=login.loginUsingExcelData();
		contact=home.clickOnManageContact().editContact("2pm", "70");
        boolean isalertdispalyed = contact.isAlertsDisplayed();
		Assert.assertTrue(isalertdispalyed,Constant.upc_updateContactWithValidData);
	}
}
