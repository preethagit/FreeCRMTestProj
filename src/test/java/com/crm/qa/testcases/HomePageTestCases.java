package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTestCases extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	DealsPage dealsPage;
	ContactsPage contactsPage;

	
	public HomePageTestCases() {
		super(); // super is used to call test base constructor.
	}
	//initialising all the steps to reach home page
	
	@BeforeMethod
	public void setUp() {
		Initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		dealsPage = new DealsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("Password"));
	}

	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.homePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO","Home Page title not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest() {
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyUserName(), "Passed user name");
	}
	
	@Test(priority=3)
	public void verifyDealLinkTest() {
		testUtil.switchToFrame();
		dealsPage = homePage.clickDealLink();
	}
	
	@Test(priority=4)
	public void verifyContactsLinkTest() {
		testUtil.switchToFrame();
		contactsPage = homePage.clickContactsLink();
		 
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
