package com.transavia.assignment;

import java.io.File;
import java.lang.reflect.Method;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.helper.Utility;

import org.apache.log4j.Logger;

public class BaseTest {
	
	protected RemoteWebDriver driver;
	public static Utility util = new Utility();

    String chrome_path= util.getProp("WEBDRIVER_LOCATION") + util.getProp("CHROME_DRIVER");
    String ie_path= util.getProp("WEBDRIVER_LOCATION") + util.getProp("IE_DRIVER");
    
    protected HomePage homePageObj;
    
    public Logger log = Logger.getLogger(this.getClass().getName());
    
	public void refreshPage() {
		driver.navigate().refresh();
	}
	
	//before class is executed
	@BeforeClass (alwaysRun=true)
	public void setupSelenium() throws InterruptedException {
		
        String browser = System.getProperty("BROWSER");
        if (browser == null)
        {
            browser = util.getProp("BROWSER");
        }
        
        log.info("Browser Selected is: " + browser);
		if (browser.equalsIgnoreCase("Firefox")) {
			
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("focusmanager.testmode",true);
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			log.info("Firefox driver loaded successfully");
		}
		
		else if (browser.equalsIgnoreCase("Chrome")) {
			log.info("Chrome driver loading.....");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			File file = new File(chrome_path);
			System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
			driver = new ChromeDriver(options);
			driver.manage().window().setPosition(new Point(0,0));
			log.info("Chrome driver loaded successfully");
		}
		else if (browser.equalsIgnoreCase("IE")){
            log.info("IE driver loading....");
            File file = new File(ie_path);
			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
            log.info("IE driver loaded successfully");
		}
		
        util = new Utility(driver);
	}

	@AfterClass (alwaysRun=true)
	public void closeSelenium() {
        try
        {
            driver.close(); 
        }
        catch (Exception e)
        {
        	log.error(e.getMessage());
        }
        finally {
            driver.quit();
        }
	}
		
	@BeforeMethod(alwaysRun = true)
	public void initialize(Method m) {
		log.info("--------------- Start:  " + m.getName() + "  -------------------");
		log.info("");
		log.info("");
		log.info("Before method --::: 'initialize' :::--");

		util.waitForElement();
		
		driver.get(util.getProp("URL"));

		homePageObj = PageFactory.initElements(driver, HomePage.class);
		
	}
	   
    @AfterMethod(alwaysRun = true)
    public void cleanUp(Method m) {
        log.info("After method --::: 'cleanUp' :::--");

		util.waitForElement();
		
        log.info("--------------- End:  " + m.getName() + "  -------------------");
    }

}
