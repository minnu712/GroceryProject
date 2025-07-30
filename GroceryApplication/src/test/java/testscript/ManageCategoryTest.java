package testscript;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import automationCore.BaseClass;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageCategory;

public class ManageCategoryTest extends BaseClass {
	LoginPage login;
	HomePage home;
	ManageCategory category;

	@Test
	public void verifystatusoffirstactivebuttonchanged() throws IOException {
		login = new LoginPage(driver);
		home = login.loginUsingExcelData();
		category = home.ClickOnManageCategory().categoryStatus();
		boolean isalertdispalyed = category.isAlertDisplay();
		Assert.assertTrue(isalertdispalyed, "alert not displayed");
	}

	@Test
	public void verifythecategoryisUpdated() throws IOException {
		login = new LoginPage(driver);
		home = login.loginUsingExcelData();
		category = home.ClickOnManageCategory().updateCategory("Meats").fileUploadSendkeys();
		boolean isalertdisplayed = category.isAlertsDisplay();
		Assert.assertTrue(isalertdisplayed, Constant.cp_verifythecategoryisUpdated);
	}

	@Test
	public void verifyTheCategoryIsDeleted() throws IOException {
		login = new LoginPage(driver);
		home = login.loginUsingExcelData();
		category = home.ClickOnManageCategory().deleteExistingCategory();
		boolean isalertdisplay = category.isDeletionAlertDisplayed();
		Assert.assertTrue(isalertdisplay, Constant.cp_verifyTheCategoryIsDeleted);
	}
}
