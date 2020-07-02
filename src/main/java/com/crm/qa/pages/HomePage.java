package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{

	
	@FindBy(xpath="//tr/td[contains(text(),'User:')]")
	 WebElement userNameLabel;
	

	@FindBy(xpath="//tr/td/a[contains(text(),'Upgrade your account')]")
	 WebElement freeAccountLink;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	 WebElement contactLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	 WebElement newContactLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	 WebElement dealLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	 WebElement taskLink;
	
	//initializing page objects
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String homePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyUserName() {
		return userNameLabel.isDisplayed();
		
	}
	
	public ContactsPage clickContactsLink() {
		contactLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickDealLink() {
		dealLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickTaskLink() {
		taskLink.click();
		return new TasksPage();
	}
	
	public NewContactsPage clickNewContactMenu()
	{
		Actions action = new Actions(driver);
		action.moveToElement(contactLink).build().perform();
		newContactLink.click();
		return new NewContactsPage();
	}
}



