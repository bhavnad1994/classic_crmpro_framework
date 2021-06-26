package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestParent;
import com.crm.qa.utils.Utilility;

public class HomePage extends TestParent {

	Utilility util = new Utilility();

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//td[contains(text(),'User: group automation ')]")
	@CacheLookup
	public WebElement loggedInUserLabel;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
		
	public boolean verifyloggedInUser() {
		return loggedInUserLabel.isDisplayed();
	}
	
	public NewContactsPage clickOnNewContactsLink() {
		util.mouseHover(contactsLink);
		newContactLink.click();
	//	util.mouseHover(newContactsLink);
	//	util.click(newContactsLink);
		return new NewContactsPage();
	}

}
