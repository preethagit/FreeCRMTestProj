package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTestCase extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;

	//constructor to call the base class constructor
	public ContactsPageTestCase() {
		super();
	}
	
	@BeforeMethod
	public void setUP() {
		Initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("Password"));
		testUtil.switchToFrame();
		contactsPage = homePage.clickContactsLink();
	}
	

	@DataProvider
	public Object[][] getContactsTestData()
	{
		Object data[][] = TestUtil.getTestData("Contacts");
		return data;
	}	
	@Test(priority=1)
	public void verifyContactsPageLabelTestcase()
	{
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "The contacts label is displayed"); 
	}
	
	@Test(priority=2)
	public void selectContactsByNameTestCase()
	{
		contactsPage.selectContactByName("abhi sahu");
	}
	
	@Test(priority=3)
	public void selectMultipleContactsByNameTestCase()
	{
		contactsPage.selectContactByName("Aashik rajput");
		contactsPage.selectContactByName("Aashiq Limbu");
	}

	
	@Test(priority=4,dataProvider="getContactsTestData")
	public void validateCreateNewContact(String title,String firstNM, String LastNM, String company)
	{
		homePage.clickNewContactMenu();
		contactsPage.createNewContact(title, firstNM,LastNM, company);
		
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
