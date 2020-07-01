package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{

	static Workbook book;
	static Sheet sheet;
	
	
	//function to switch to frame
	public void switchToFrame()
	{
		driver.switchTo().frame("mainpanel");
	}
	
	
	//function to read data from the excel
	public static Object[][] getTestData(String Sheetname)
	{
		FileInputStream file = null;
		try {
			//System.out.println(prop.getProperty("TestDataFilePath"));
			file = new FileInputStream(prop.getProperty("TestDataFilePath"));
			
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(file);
		}catch(InvalidFormatException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	
		sheet = book.getSheet(Sheetname);
		
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int j=0; j<sheet.getRow(0).getLastCellNum();j++)
			{
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}
		}
		
		return data;
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException{
		File inputfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentdir = System.getProperty("user.dir");
		File outputfile = new File(currentdir+"/Screenshot/img_" + System.currentTimeMillis() + ".png");
		FileUtils.copyFile(inputfile,outputfile );
	}
	
}
