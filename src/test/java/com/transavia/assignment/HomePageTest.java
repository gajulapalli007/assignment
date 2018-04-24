/**
 * 
 */
package com.transavia.assignment;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.lang.reflect.Method;
import com.transavia.assignment.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

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
		AssertJUnit.assertTrue(homePageObj.isTransaviaLogoVisible());
		util.waitForElement(5000);
	}
	
	
	@Test(groups={"Search flights"},description="verify ValuesPopulated in From and To input field box",dependsOnMethods={"verifyHomePageloadActivity"})
	public void verifyFromToFUnctionalities() {
		homePageObj.clickFromTxtBx();
		homePageObj.enterFromAndToDestination();
		AssertJUnit.assertTrue(true);
		
	}
	
	@Test(groups={"Search flights"},description="Verify depart on and return date",dependsOnMethods={"verifyFromToFUnctionalities"})
	public void verifyDates() {
		homePageObj.clickReturnCheckbox();
		homePageObj.enterDate();
		AssertJUnit.assertTrue("Dates are entered", true);
		util.waitForElement(5000);
	}
	
	@Test(groups={"Search flights"},description="Verify functionality of input field <WhoIsTravelling>",dependsOnMethods={"verifyDates"})
	public void verifyTheFunctionalityOfWhoIsTravellingPopup() {
		homePageObj.clickWhoIsTravellingInputBox();
		homePageObj.isPassengerPopupDisplayed();
		homePageObj.clickAddAdultPassengers();
		homePageObj.clickSaveNoOfPassengers();
		AssertJUnit.assertTrue(true);
		util.waitForElement(5000);
	}
	
	
    
}
