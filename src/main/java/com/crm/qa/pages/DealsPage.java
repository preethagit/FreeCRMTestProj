package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class DealsPage extends TestBase{
	
	@FindBy(xpath="//input[@name='cs_keyword']")
	WebElement keywordTextBox;
	
	@FindBy(name="cs_closed")
	WebElement radio_status_closed;
	
	public DealsPage()
	{
		PageFactory.initElements(driver, this);
	}

	//Actions on deals page
	
	public void keywordSearch()
	{
		keywordTextBox.sendKeys("SS");
		
	}
	
	public void selectStatusClosed()
	{
		radio_status_closed.click();
	}
	
}
