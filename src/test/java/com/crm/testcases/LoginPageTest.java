package com.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.Base;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;



public class LoginPageTest extends Base {
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}

	@Test(priority = 0)
	public void validateImageTest() {
		Boolean flag = loginPage.logoDisplayed();
		Assert.assertTrue(flag);
	}

	@Test(priority = 1)
	public void validateTitleTest() {
		String title = loginPage.validateTitle();
		System.out.println("Tilte --"+title);
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority = 2)
	public void validateLoginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
