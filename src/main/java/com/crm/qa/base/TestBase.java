package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TimeoutVal;
import com.crm.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener listner;
	
	public TestBase()
	{
		try	{
			prop = new Properties();
			FileInputStream file = new FileInputStream("D:/Preetha/Eclipse/FreeCRMProject"+
			"/src/main/java/com/crm/qa/config/config.properties");
			prop.load(file);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	public static void Initialization()
	{
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:/Preetha/Eclipse/Browsers/chromedriver/chromedriver.exe");
			driver = new ChromeDriver();

		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "D:/Preetha/Eclipse/Browsers/");
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("IExplorer"))
		{
			System.setProperty("webdriver.ie.driver", "D:/Preetha/Eclipse/Browsers/");
			driver = new InternetExplorerDriver();
		}

		e_driver = new EventFiringWebDriver(driver);
		listner = new WebEventListener();
		e_driver.register(listner);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();  ///delete all the cookies
		driver.manage().timeouts().pageLoadTimeout(TimeoutVal.page_load_timeout, TimeUnit.SECONDS); // Page load timeout
		driver.manage().timeouts().implicitlyWait(TimeoutVal.implicit_wait_time, TimeUnit.SECONDS); //implicit wait
		driver.get(prop.getProperty("url"));
	}
}
