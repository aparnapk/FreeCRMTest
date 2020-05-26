package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.Base;
import com.crm.util.Utils;

public class HomePage extends Base{
	
	@FindBy(xpath="//td[contains(text(),'User: Demo User')]")
	WebElement usernameLabel;
	
	@FindBy(xpath="//a[@title='Contacts']")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[@title ='New Contact']")
	WebElement newcontactsLink;		
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifytUserName() {
		try {
		Utils.switchToFrame("mainpanel");
		Utils.waitForAnElement(10,usernameLabel);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return usernameLabel.isDisplayed() ;
		
	}
	
	public ContactsPage clickOnNewContacts() {	
		try {
		Utils.switchToFrame("mainpanel");
		System.out.println("Switched");
		//Utils.waitForAnElement(10, contactsLink);
		//Utils.jsClick(contactsLink);
		//contactsLink.click();
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newcontactsLink.click();
		
		System.out.println("clicked on new contacts");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ContactsPage();
	}
	
	
}
