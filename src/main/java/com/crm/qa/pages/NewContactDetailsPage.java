package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestParent;

public class NewContactDetailsPage extends TestParent {
	
	
	public NewContactDetailsPage() {
		PageFactory.initElements(driver, this);
	}
	
		
	public String verifyEmployeeHeaderName(String empname ) {
		String empName=	driver.findElement(By.xpath("//td[@class='tabs_header'][contains(text(),'"+empname+"')]")).getText();
		return empName;
	
	}
	
	

}
