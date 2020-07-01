package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTestCase extends TestBase {

	LoginPage loginPage;  //page objects
	HomePage homePage;
	
	public LoginPageTestCase(){
		super(); // super is used to call testbase constructor. 
	}
	
	
	@BeforeMethod
	public void setUp() {
		Initialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){	
		String title = loginPage.verifyLoginPageTitle();
				
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority=2)
	public void crmLogoImageTest() {
		boolean flag = loginPage.verifyPageLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("Password"));
		
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
