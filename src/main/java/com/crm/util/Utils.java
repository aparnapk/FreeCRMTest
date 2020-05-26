package com.crm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.base.Base;

public class Utils extends Base{
		public static long PAGE_LOAD_TIMEOUT = 20;
		 public static long IMPLICIT_WAIT = 10;
		 public static String TESTDATA_SHEET_PATH = "C:\\Users\\user\\eclipse-workspace\\FreeCrmTest\\src\\main\\java\\com\\crm\\testdata\\test.xlsx";

			static Workbook book;
			static org.apache.poi.ss.usermodel.Sheet sheet;
		 public static void jsClick(WebElement e) {
			 JavascriptExecutor js = ((JavascriptExecutor)driver);
			 js.executeScript("arguments[0].click();", e);
		 }
		 
		 public static void switchToFrame(String name) {
			 driver.switchTo().frame(name);
		 }
		 
		 public static void waitForAnElement(int timeout, WebElement e) {
				WebDriverWait wait = new WebDriverWait(driver, timeout);
				wait.until(ExpectedConditions.visibilityOf(e));
			}
		 
		 public static Object[][] getTestData(String sheetName) {
				FileInputStream file = null;
				try {
					file = new FileInputStream(TESTDATA_SHEET_PATH);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				try {
					book = WorkbookFactory.create(file);
				} catch (InvalidFormatException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				sheet = book.getSheet(sheetName);
				Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
				// System.out.println(sheet.getLastRowNum() + "--------" +
				// sheet.getRow(0).getLastCellNum());
				for (int i = 0; i < sheet.getLastRowNum(); i++) {
					for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
						data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
						// System.out.println(data[i][k]);
					}
				}
				return data;
			}

			public static void takeScreenshotAtEndOfTest() throws IOException {
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				String currentDir = System.getProperty("user.dir");
				FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
			}
}
