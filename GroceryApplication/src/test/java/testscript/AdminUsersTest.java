package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.BaseClass;
import constants.Constant;
import pages.AdminUsers;
import pages.HomePage;
import pages.LoginPage;

public class AdminUsersTest extends BaseClass {
	LoginPage login;
	HomePage home;
	AdminUsers admin;

	@Test
	public void addValidAdminUsers() throws IOException {
		login = new LoginPage(driver);
		home = login.loginUsingExcelData();
		admin = home.clickOnAdminUsers().addAdmin("Jona", "Jona1334").selectUserType();
		boolean isadminadded = admin.isAlertsDisplayed();
		Assert.assertTrue(isadminadded, Constant.au_addValidAdminUsers);
	}
}
