package com.transavia.assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.helper.Utility;

public class HomePage {

	private WebDriver driver;
	private Utility util;
	
	public HomePage(WebDriver driver) {
		 this.driver = driver;
		 this.util = new Utility(driver);
	}
	
	//Constructor
	public HomePage() {
		// TODO Auto-generated constructor stub
	}

	@FindBy (id="routeSelection_DepartureStation-input")
	private WebElement FromTxtBx;
	
	//click Logout button
	public boolean clickFromTxtBx(){
		FromTxtBx.click();
		util.waitForElement();
		return false;
	}

/*	// automatic properties
	public WebDriver getDriver() {
		return driver;
	}
	
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	public Utility getUtil() {
		return util;
	}
	
	public void setUtil(Utility util) {
		this.util = util;
	}*/
}
