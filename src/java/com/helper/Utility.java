package com.helper;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class Utility {

	private WebDriver driver;
    private long defaultTimeOut = 30000; // milliseconds
    private static long totalTimeSpentWaiting; // used to calculate the wait

    public Logger log = Logger.getLogger(this.getClass().getName());

    public Utility() {
    }

    public Utility(WebDriver driver) {
        this.setDriver(driver);
    }

    public String getProp(String propertyName) {
        String propertyValue = null;
        try {
            Properties prop = new Properties();
            prop.load(getClass().getClassLoader().getResourceAsStream("data.properties"));
            propertyValue = prop.getProperty(propertyName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return propertyValue;
    }

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
    
    public void waitForElement(Object... millis) {
        long timeout = defaultTimeOut;
        if (millis.length > 0) {
            timeout = Long.parseLong(String.valueOf(millis[0]));
            try {
                Thread.sleep(timeout);
            } catch (Exception e) {
            }
        } else {
            try {
                Thread.sleep(timeout);
            } catch (Exception e) {
            }
        }
        totalTimeSpentWaiting += timeout;
    }

}