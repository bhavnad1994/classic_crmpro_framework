package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.crm.qa.base.TestParent;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewContactsPage;
import com.crm.qa.utils.TestUtil;

public class HomePageTest extends TestParent {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	NewContactsPage contactsPage;
	
	public HomePageTest() {
		super();
	}
	
	
	@BeforeClass
	public void setUp(){
		initialization();
		testUtil =new TestUtil();
		contactsPage = new NewContactsPage();
		loginPage = new LoginPage();	
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void HomePageTitleTest(){
		String title = homePage.verifyHomePageTitle();
		Assert.assertEquals(title, "CRMPRO");
	}
	
		
	@Test(priority=2,enabled=false)
	public void verifyUserNameTest(){
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyloggedInUser());
	
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest(){
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnNewContactsLink();
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}

	
	
}
