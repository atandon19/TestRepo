package com.mmt.common;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Keys;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class Keywords extends PageObject {
	
	public String getCurrentDate() {
		java.util.Date date = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(date);
	}
	
	public String randomString() {
		Date date = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");   
	    String strDate = formatter.format(date);     
	    String randomValue = strDate.replaceAll("-", "").replaceAll(":", "").replaceAll(" ", "");
		return randomValue;
	}
	
	
public void pressEnterKey(WebElementFacade metric1_txt_box) {
		
		metric1_txt_box.sendKeys(Keys.TAB);
	}
}
