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
	@Test(groups={"Search flights"},description="Select From")
	public void isURLConnected(){
		homePageObj.clickFromTxtBx();
		Assert.assertTrue(true);
    }
    
}
