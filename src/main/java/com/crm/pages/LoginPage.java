package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.Base;

public class LoginPage extends Base{
	
	@FindBy(name="username")
	WebElement usrname;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginButton;
	
	@FindBy(xpath="//a[@class='navbar-brand']/img")
	WebElement crmLogo;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public Boolean logoDisplayed() {
		return crmLogo.isDisplayed();
	}
	
	public String validateTitle() {
		return driver.getTitle();
	}
	
	public HomePage login(String username,String Password) {
		usrname.sendKeys(username);
		password.sendKeys(Password);
		loginButton.click();
		return new HomePage();
	}

		
}
