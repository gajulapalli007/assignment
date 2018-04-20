package com.transavia.assignment;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.Keys;
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
	
	@FindBy(id="routeSelection_ArrivalStation-input")
	private WebElement ToTxtBx;
	
	@FindBy(xpath="//*[@id=\"desktop\"]/section/div[3]/div/button")
	private WebElement SearchButton;
	
	@FindBy(xpath="//*[@id=\"desktop\"]/section/div[2]/div[2]/div/div/div[2]/div/div[1]/label/span")
	private WebElement RetunrOnCheckBox;
	
	@FindBy(id="dateSelection_OutboundDate-datepicker")
	private WebElement DepartingDate;
	
	@FindBy(id="dateSelection_IsReturnFlight-datepicker")
	private WebElement ReturnDate;
	
	@FindBy(xpath=" //*[@id=\"top\"]/div[1]/section/div/section/div/div[1]/div/div[5]/div/img")
	private WebElement TransaviaLogo;
	
	@FindBy(id="booking-passengers-input")
	private WebElement NoOfPassengersInputBox;
	
	@FindBy(xpath="//*[@id=\"desktop\"]/section/div[2]/div[3]/div/div[2]/div[2]/div[1]")
	private WebElement NoOfPassengersPopup ;
	
	@FindBy(xpath="//*[@id=\"desktop\"]/section/div[2]/div[3]/div/div[2]/div[2]/div[1]/div[1]/div/div/div[2]/div/div/button[2]")
	private WebElement AddAdultPassengersButton ;
	
	@FindBy(xpath="//*[@id=\"desktop\"]/section/div[2]/div[3]/div/div[2]/div[2]/div[1]/div[1]/div/div/div[2]/div/div/div[2]/input")
	private WebElement AdultNoOfPassengers;
	
	@FindBy(xpath="//*[@id=\"desktop\"]/section/div[2]/div[3]/div/div[2]/div[2]/div[2]/button")
	private WebElement SaveButtonNoOfPassengers ;
	
	
	public void clickFromTxtBx(){
		FromTxtBx.click();
		util.waitForElement();

	}
	
	
	
	public void enterFromAndToDestination() {
		FromTxtBx.sendKeys("Amsterdam");
		util.waitForElement();
		FromTxtBx.sendKeys(Keys.TAB);
		ToTxtBx.sendKeys("Rotterdam");
	
	}
	

	public void clickReturnCheckbox() {
		RetunrOnCheckBox.click();
		RetunrOnCheckBox.click();
	}
	
	public void enterDate() {
		DepartingDate.clear();
		DepartingDate.sendKeys("05 Dec 2017");
		util.waitForElement();
		ReturnDate.clear();
		ReturnDate.sendKeys("09 Dec 2017");
		util.waitForElement();
	}
	
	public boolean isTransaviaLogoVisible (){
		boolean B= TransaviaLogo.isDisplayed();
		return B;
	}
	
	public void clickSearchButton() {
		SearchButton.click();
	}
	
	public void clickWhoIsTravellingInputBox() {
		NoOfPassengersInputBox.click();
		util.waitForElement();
	}
	
	public boolean isPassengerPopupDisplayed() {
		boolean y = false;
		NoOfPassengersPopup.isDisplayed();
		return y;
	}
	
	

	public void clickAddAdultPassengers() {
		AddAdultPassengersButton.click();
		util.waitForElement(5000);
		
		}
	
	public void clickSaveNoOfPassengers() {
		SaveButtonNoOfPassengers.click();
		util.waitForElement(5000);
		}
	
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

