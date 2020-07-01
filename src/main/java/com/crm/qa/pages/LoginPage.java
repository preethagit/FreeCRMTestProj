package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page factory or Object repository
	
	@FindBy(name="username")
	@CacheLookup
		WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	//"//div/input[@type='submit']"
	
	
	@FindBy(xpath="//form[@id='loginForm']/div/div/input")

	WebElement loginbtn;
	
	@FindBy(xpath="//a[contains(@href,'https://register.freecrm.com')]")
	WebElement signup;
	
	@FindBy(xpath="//img[contains(@src,'https://classic.freecrm.com')]")
	WebElement crmlogo;
	
	//Initializing the page objects
	public LoginPage() {
		PageFactory.initElements(driver,this);
	}
	
	//Actions:
	public String verifyLoginPageTitle() {
		return driver.getTitle(); // return title of the page
	}
	
	public boolean verifyPageLogo() {
		return crmlogo.isDisplayed();  
	}
	
	public HomePage login(String usernm, String passwrd) {
		username.sendKeys(usernm);
		password.sendKeys(passwrd);
		loginbtn.submit();
		
		return new HomePage();
	}
}
