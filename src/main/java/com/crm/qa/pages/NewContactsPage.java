package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestParent;
import com.crm.qa.utils.Utilility;

public class NewContactsPage extends TestParent {
	
	Utilility util = new Utilility();
	public NewContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
		
	@FindBy(id="first_name")
	@CacheLookup
	public WebElement firstName;
	
	@FindBy(id="surname")
	@CacheLookup
	public WebElement lastName;
	
	@FindBy(name="client_lookup")
	@CacheLookup
	public WebElement company;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	@CacheLookup
	public WebElement saveBtn;
	
	
	public NewContactDetailsPage createNewContact(String title, String ftName, String ltName, String comp)
	{
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		firstName.clear();
		firstName.sendKeys(ftName);
		lastName.clear();
		lastName.sendKeys(ltName);
		company.clear();
		company.sendKeys(comp);
		util.click(saveBtn);
		return new NewContactDetailsPage();

	}
	
}