package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewContactsPage;
import com.crm.qa.util.TestUtil;

public class NewContactPageTestCase extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	NewContactsPage newContactsPage;
	TestUtil testUtil;
	
	//constructor to call the base class constructor
	public NewContactPageTestCase()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		Initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("Password"));
		testUtil = new TestUtil();
		testUtil.switchToFrame();
		newContactsPage = homePage.clickNewContactMenu();
	}
	

	@DataProvider
	public Object[][] getContactsTestData()
	{
		Object data[][] = TestUtil.getTestData("Contacts");
		return data;
	}
	
	
	@Test(priority=1,dataProvider="getContactsTestData")
	public void validateCreateNewContact(String title,String firstNM, String LastNM, String company)
	{
		
		newContactsPage.createNewContact(title, firstNM,LastNM, company);
		
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

	
}
