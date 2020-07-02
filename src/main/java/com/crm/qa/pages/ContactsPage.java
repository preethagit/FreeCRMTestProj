package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
		
	@FindBy(xpath="//form[@id=\"vContactsForm\"]/table/tbody/tr/td/table/tbody/tr/td")
	WebElement contactTableText;
	
	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactsText;
	
	
	@FindBy(name="cs_name")
	WebElement searchName;
		
	@FindBy(name="cs_submit")
	WebElement searchButton;
	
	public ContactsPage(){
	PageFactory.initElements(driver, this);				
	}

	//Actions in this page
	
	public boolean verifyContactsLabel()
	{
		return contactsText.isDisplayed();
	}
	
	
	public void selectContactByName(String name)
	{
		String nameXpath = "//a[text()='"+ name +"']//parent::td[@class='datalistrow']/preceding-sibling::td/input[@name='contact_id']";
		driver.findElement(By.xpath(nameXpath)).click();
	}
	
	public void enterName(String name)
	{
		searchName.sendKeys(name);
	}
	
	public void clickSearch()
	{
		searchButton.click();
		
	}
	
	}
