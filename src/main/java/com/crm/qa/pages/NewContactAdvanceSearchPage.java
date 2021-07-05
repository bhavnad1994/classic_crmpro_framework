package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestParent;

public class NewContactAdvanceSearchPage extends TestParent {
	public NewContactAdvanceSearchPage() {
		PageFactory.initElements(driver, this);
	}
	
		
	@FindBy(xpath="//*[@id=\"extendedSearchLayer\"]/table/tbody/tr[2]/td[1]/table/tbody/tr[3]/td[2]/input")
	public WebElement nameToBeSearched;
	
	@FindBy(xpath="//input[@value='Search']")
	public WebElement search;
	
	
	public void SearchName(String name) {
		
		nameToBeSearched.sendKeys(name);
		search.click();
		}

}
