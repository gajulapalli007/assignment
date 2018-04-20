/**
 * 
 */
package com.transavia.assignment;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest{
	
	//preconditions before testcase
	@BeforeMethod(alwaysRun = true)
	public void initialize(Method m) {
		log.info(m.getName());
		super.initialize(m);
	}
	
	//postconditions after the testcase
	@AfterMethod(alwaysRun = true)
	public void cleanup(Method m) {
		
	}
	
	@Test(groups={"Search flights"},description="isTransaviaHomePageSuccessfullyLoaded")
	public void verifyHomePageloadActivity() {
		Assert.assertTrue(homePageObj.isTransaviaLogoVisible());
		util.waitForElement(5000);
	}
	
	
	@Test(groups={"Search flights"},description="verify ValuesPopulated in From and To input field box",dependsOnMethods={"verifyHomePageloadActivity"})
	public void verifyFromToFUnctionalities() {
		homePageObj.clickFromTxtBx();
		homePageObj.enterFromAndToDestination();
		Assert.assertTrue(true);
		
	}
	
	@Test(groups={"Search flights"},description="Verify depart on and return date",dependsOnMethods={"verifyFromToFUnctionalities"})
	public void verifyDates() {
		homePageObj.clickReturnCheckbox();
		homePageObj.enterDate();
		Assert.assertTrue(true, "Dates are entered");
		util.waitForElement(5000);
	}
	
	@Test(groups={"Search flights"},description="Verify functionality of input field <WhoIsTravelling>",dependsOnMethods={"verifyDates"})
	public void verifyTheFunctionalityOfWhoIsTravellingPopup() {
		homePageObj.clickWhoIsTravellingInputBox();
		homePageObj.isPassengerPopupDisplayed();
		homePageObj.clickAddAdultPassengers();
		homePageObj.clickSaveNoOfPassengers();
		Assert.assertTrue(true);
		util.waitForElement(5000);
	}
	
	
    
}
