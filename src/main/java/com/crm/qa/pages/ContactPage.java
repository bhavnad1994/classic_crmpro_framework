package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestParent;
import com.crm.qa.utils.Utilility;

public class ContactPage extends TestParent {

	
	Utilility util = new Utilility();
	
	public ContactPage() {
		PageFactory.initElements(driver, this);
	}
	
		
	@FindBy(xpath="//li/a[contains(text(),'Contacts')]")
	@CacheLookup
	public WebElement contactLink;
	
	
	
	public void clickContact() {
		contactLink.click();
		}
	
	
	public ContactPage table_Contact_Detail_along_with_pagination() {
		
		//total number of pages and clicking on those
		List<WebElement> tableList=driver.findElements(By.xpath("//tbody/tr[2]/td/div[@class='pagination']/a"));
		int size=tableList.size();
		
		for(int i=1;i<size;i++) {
		String currentPage=driver.findElement(By.xpath("//tbody/tr[2]/td/div[@class='pagination']/strong")).getText();
		System.out.println("Current Active page " + currentPage);
		
		int rows=driver.findElements(By.xpath("//form[@id='vContactsForm']//table[@class='datacard']/tbody/tr")).size();
		System.out.println(rows);
		
		String pageNo=Integer.toString(i+1);
		driver.findElement(By.xpath("//form[@id='vContactsForm']//table[@class='datacard']/tbody/tr[2]/td/div[@class='pagination']/a[text()='"+pageNo+"']"));
		
		
		
		}
		return new ContactPage();
		
		
		
		
		}
	
}
