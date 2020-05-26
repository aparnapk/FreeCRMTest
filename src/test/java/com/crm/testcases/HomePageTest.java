package com.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.Base;
import com.crm.pages.ContactsPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.util.Utils;

public class HomePageTest extends Base {
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority = 0)
	public void verifyUserNameLabelTest() {
		Assert.assertTrue(homePage.verifytUserName(),"Not matchings");
	}
	
	@Test(priority = 1)
	public void clickOnContactsPageTest() {
		contactsPage = homePage.clickOnNewContacts();
	}
	
	@Test(priority = 2)
		public void selectContact() {
		    contactsPage = homePage.clickOnNewContacts();
		    contactsPage.selectContacts("Aakash Anmash");
		}
	
	
	@AfterMethod
	public void teatDown() {
		driver.close();
	}
	
}
