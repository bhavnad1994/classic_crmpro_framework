package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestParent;
import com.crm.qa.utils.Utilility;

public class LoginPage extends TestParent {

	 Utilility util=new Utilility();

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@class='form-control' and @type='text']")
	@CacheLookup
	public WebElement txt_username;

	@FindBy(xpath = "//input[@class='form-control' and @type='password']")
	@CacheLookup
	public WebElement txt_password;

	@FindBy(xpath = "//input[@type='submit']")
	@CacheLookup
	public WebElement btn_login;

	public String verifyLoginPageTitle() {
		return driver.getTitle();
	}

	public HomePage doLogin(String u, String p) {
		txt_username.sendKeys(u);
		txt_password.sendKeys(p);
		util.click(btn_login);
		// btn_login.click();

		return new HomePage();
		/*
		 * JavascriptExecutor js = (JavascriptExecutor)driver;
		 * js.executeScript("arguments[0].click();", loginBtn);
		 */

	}

}
