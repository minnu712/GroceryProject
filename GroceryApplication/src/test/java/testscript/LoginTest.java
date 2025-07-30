package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationCore.BaseClass;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseClass {
	LoginPage login;
	HomePage home;

	@Test
	public void verifyLoginwithvalidcredentials() throws IOException {
		login = new LoginPage(driver);
		home=login.loginUsingExcelData();
		boolean ishomepageloaded = login.isHomepageLoaded();
		Assert.assertTrue(ishomepageloaded, Constant.lp_verifyLoginwithvalidcredentials);
	}

	@Test
	public void verifyLoginWithValidUsernameAndInvalidPassword() {
		login = new LoginPage(driver);
		login.enterUsernameOnUsernamefield("admin");
		login.enterPassword("1237u");
		login.clickOnloginbutton();
		boolean isalertmessagedisplayed = login.isAlertDisplayed();
		Assert.assertTrue(isalertmessagedisplayed, " alert is not displayed ");
	}

	@Test
	public void verifyLoginWithInValidUsernameAndvalidPassword() {
		login = new LoginPage(driver);
		login.enterUsernameOnUsernamefield("caro");
		login.enterPassword("admin");
		login.clickOnloginbutton();
		boolean isalertmessagedisplayed = login.isAlertDisplayed();
		Assert.assertTrue(isalertmessagedisplayed, " alert is not displayed ");
	}

	@Test(dataProvider = "logindataprovider")
	public void verifyLoginWithInValidcredentials(String username, String password) {
		login = new LoginPage(driver);
		login.enterUsernameOnUsernamefield(username);
		login.enterPassword(password);
		login.clickOnloginbutton();
		boolean isalertmessagedisplayed = login.isAlertDisplayed();
		Assert.assertTrue(isalertmessagedisplayed, " alert is not displayed ");
	}

	@DataProvider(name = "logindataprovider")
	public Object[][] dpmethod() {
		return new Object[][] { { "admi", "admn" }, { "carol", "christmas" }, { "cracker", "789" }, { "yhu", "onam" } };
	}

}
