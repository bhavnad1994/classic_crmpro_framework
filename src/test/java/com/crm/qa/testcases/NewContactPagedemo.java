package com.crm.qa.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestParent;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewContactsPage;
import com.crm.qa.utils.TestUtil;

public class NewContactPagedemo extends TestParent {
		
		LoginPage loginPage;
		HomePage homePage;
		TestUtil testUtil;
		NewContactsPage contactsPage;
		
		String sheetName = "contacts";
		
		public NewContactPagedemo() {
			super();
		}
		

		@BeforeClass
		public void setUp(){
			initialization();
			testUtil =new TestUtil();
			loginPage = new LoginPage();
			contactsPage = new NewContactsPage();
			homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
			
			
		}
		
		
		@DataProvider
		public Object[][] getCRMTestData(){
			Object data[][] = TestUtil.getTestData(sheetName);
			return data;
		}
		
		
		@Test(priority=1, dataProvider="getCRMTestData")
		public void validateCreateNewContact(String title, String firstName, String lastName, String company){
			testUtil.switchToFrame();
			contactsPage=homePage.clickOnNewContactsLink();
			contactsPage.createNewContact(title, firstName, lastName, company);
			
		}
		
		@AfterClass
		public void tearDown(){
			driver.quit();
		}


	}

