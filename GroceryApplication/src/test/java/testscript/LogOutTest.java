package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.BaseClass;
import constants.Constant;
import pages.HomePage;

import pages.LoginPage;


public class LogOutTest extends BaseClass { 
	LoginPage login;
	HomePage home;
	@Test
 public void logoutApplication() throws IOException {
	  login = new LoginPage(driver);
	  home=login.loginUsingExcelData();
	  home.logoutPage();
	   boolean isloginpageloaded = home.isLoginPageLoaded();
		Assert.assertTrue(isloginpageloaded, Constant.lo_logoutApplication);
	}
 }


