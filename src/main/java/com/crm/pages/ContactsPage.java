package com.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.base.Base;
import com.crm.util.Utils;

public class ContactsPage extends Base {
	
	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@id='surname']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement compName;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveButton;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	public void selectContacts(String userName) {
		driver.findElement(By.xpath("//a[text()='"+userName+"']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@align='left']//input[@type='checkbox']")).click();
		
	}
	
	public String checkPageTitle() {
		Utils.waitForAnElement(10, contactsLabel);
		return contactsLabel.getText();
		
	}
	
	public void createNewContact(String tilte,String ftName,String ltName,String companyName) {
		
		Select select = new Select(driver.findElement(By.xpath("//select[@name='title']")));
		select.selectByVisibleText(tilte);
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		compName.sendKeys(companyName);
		saveButton.click();
		
	}

}
