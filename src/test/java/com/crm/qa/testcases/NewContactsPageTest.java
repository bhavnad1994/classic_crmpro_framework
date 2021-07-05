package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestParent;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewContactDetailsPage;
import com.crm.qa.pages.NewContactsPage;
import com.crm.qa.utils.TestUtil;

public class NewContactsPageTest extends TestParent {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	NewContactsPage contactsPage;
	NewContactDetailsPage newContactDetail;
	
	String sheetName = "contacts";
	
	public NewContactsPageTest() {
		super();
	}
	

	@BeforeClass
	public void setUp(){
		initialization();
		testUtil =new TestUtil();
		loginPage = new LoginPage();
		contactsPage = new NewContactsPage();
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		
	}
	
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=1, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title, String firstName, String lastName, String company){
		
		contactsPage=homePage.clickOnNewContactsLink();
		newContactDetail=contactsPage.createNewContact(title, firstName, lastName, company);
		newContactDetail.verifyEmployeeHeaderName(firstName + " " + lastName);
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}


}
