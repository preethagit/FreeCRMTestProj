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
	
	@FindBy(name="title")
	WebElement titleDropdown;
	
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath = "//form[@id='contactForm']/table/tbody/tr/td/input[@type='submit' and @value='Save']")
	WebElement saveButton;
	
		
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
	
	public void createNewContact(String title, String firstnm, String Lastnm, String companynm)
	{
		Select titleObj = new Select(driver.findElement(By.name("title")));
	//	Select titleObj = new Select(titleDropdown);
		
		titleObj.selectByValue(title);
		titleObj.selectByVisibleText(title);
		firstName.sendKeys(firstnm);
		lastName.sendKeys(Lastnm);
		company.sendKeys(companynm);
		saveButton.click();
	}
}
