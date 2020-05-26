package com.crm.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.base.Base;
import com.crm.pages.ContactsPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.util.Utils;

public class ContactsPageTest extends Base{
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	String sheetName="contacts";
	public ContactsPageTest() {
		super();
		
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	/*@Test(priority=2)
	public void selectContacts() {
		contactsPage = homePage.clickOnNewContacts();
		contactsPage.selectContacts("Aakash Anmash");
		System.out.println("clicked on contacts");
	}*/
	
	@DataProvider
	public Object[][] getCrmData() {
		Object[][] data = Utils.getTestData(sheetName);
		return data;
	}
	@Test(priority=1, dataProvider="getCrmData")
	public void createContact(String tilte, String ftName,String ltName,String companyName) {
		contactsPage = homePage.clickOnNewContacts();
		contactsPage.createNewContact(tilte, ftName, ltName, companyName);
	}
	@AfterMethod
	public void teatDown() {
		driver.close();
	}
	
}
