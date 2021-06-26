package com.crm.qa.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.crm.qa.base.TestParent;

public class Utilility extends TestParent {
	Actions a = new Actions(driver);

	public void mouseHover(WebElement elem) {
		a.moveToElement(elem).build().perform();
	}

	public void click(WebElement elem) {
		elem.click();
	}
}
