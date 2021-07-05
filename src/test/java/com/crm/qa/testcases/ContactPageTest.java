package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.crm.qa.base.TestParent;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewContactsPage;
import com.crm.qa.utils.TestUtil;

public class ContactPageTest extends TestParent {
	
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactPage contactPage;
	
	public ContactPageTest() {
		super();
	}
	
	
	@BeforeClass
	public void setUp(){
		initialization();
		testUtil =new TestUtil();
		loginPage = new LoginPage();	
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
			
	@Test()
	public void verifyContact_Table_details_Test() throws Exception{
		testUtil.switchToFrame();
		contactPage.clickContact();
		Thread.sleep(3000);
		contactPage.table_Contact_Detail_along_with_pagination();
	
	}
	

}
