package com.crm.qa.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.crm.qa.base.TestParent;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.utils.ExcelReader;
import com.crm.qa.utils.TestUtil;

public class DemoTest extends TestParent {

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");	
		driver = new ChromeDriver(); 
		Thread.sleep(3000);
		
		driver.get("https://classic.freecrm.com/index.html");
			
		driver.findElement(By.xpath("//input[@class='form-control' and @type='text']")).sendKeys("groupautomation");
		driver.findElement(By.xpath("//input[@class='form-control' and @type='password']")).sendKeys("Test@12345");
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	
		TestUtil testUtil =new TestUtil();
		
		
		testUtil.switchToFrame();
		driver.findElement(By.xpath("//li/a[contains(text(),'Contacts')]")).click();
		
		System.out.println("clicked on contact");
		//*[@id="vContactsForm"]/table/tbody/tr[4]/td[2]
		//*[@id="vCompaniesForm"]/table/tbody/tr[5]/td[2]
		
		//*[@id="vCompaniesForm"]/table/tbody/tr[6]/td[2]
		//*[@id="vContactsForm"]/table/tbody/tr[5]/td[2]/a
		String beforeXpath="//*[@id='vCompaniesForm']/table/tbody/tr[";
		String afterXpath="]/td[2]/a";
		
			/*
			//total number of pages and clicking on those
			List<WebElement> tableList=driver.findElements(By.xpath("//tbody/tr[2]/td/div[@class='pagination']/a"));
			int size=tableList.size();
			System.out.println("size " + size);
			
			for(int i=2;i<=size+1;i++) {
			WebElement activePage=driver.findElement(By.xpath("//tbody/tr[2]/td/div[@class='pagination']/strong"));
			String currentPage=activePage.getText();
			System.out.println("Current Active page " + currentPage);
			String pageNo=Integer.toString(i);
			driver.findElement(By.xpath("//form[@id='vContactsForm']//table[@class='datacard']/tbody/tr[2]/td/div[@class='pagination']/a[text()='"+pageNo+"']")).click();
			
			
				
		
			int rows=driver.findElements(By.xpath("//form[@id='vContactsForm']/table[@class='datacard']/tbody/tr")).size();
			System.out.println("number of rows " +rows);
			
			System.out.println("*************data read**************");
			for(int i=4;i<rows;i++) {
			
			String companyName=driver.findElement(By.xpath("//*[@id='vContactsForm']/table/tbody/tr["+i+"]/td[2]")).getText();	
			System.out.println( companyName  + "   " );
			
			if(companyName.contains("Bosede Moba" )) {
				
				driver.findElement(By.xpath("//*[@id='vContactsForm']/table/tbody/tr["+i+"]/td[1]/input")).click();
				System.out.println("Clicked in the checkbox");
			}
		
			
			}
			
			*/
		
		
		
		
	
}}
