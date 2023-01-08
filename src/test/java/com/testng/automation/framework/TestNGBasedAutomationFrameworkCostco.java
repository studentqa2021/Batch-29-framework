package com.testng.automation.framework;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.drivermanager.DriverManager;
import com.generic.BaseLogin;
import com.report.ExtentReportAutomation;
import com.selenium.pagefactory.SeleniumPageFactory;
import com.util.Constants;
import com.util.HighLighter;
import com.util.ScreenShot;
import com.util.SeleniumWait;

public class TestNGBasedAutomationFrameworkCostco extends ExtentReportAutomation {
	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		//open a browser
		 driver =DriverManager.getBrowser("chrome");
		driver.manage().window().maximize();
		SeleniumWait.getImplicitWait(driver, 3);
		// go to URL
		driver.navigate().to(Constants.COSTCO_URL);
	}
	
	@Test
	public void TestRun() {
		System.out.println("Home page title/name = "+ driver.getTitle());
		ScreenShot.getScreenShot(driver, "Costco home welcome page");
		//Check=validate current URL is matched or not==> getCurrentURL()
		System.out.println("Current page URl = "+driver.getCurrentUrl());
		//Expectation = Constants.COSTCO_URL , actual =driver.getCurrentUrl()
		SoftAssert sf = new SoftAssert();
		sf.assertEquals(driver.getCurrentUrl(),Constants.COSTCO_URL);
		//Go to sign in page  
		SeleniumPageFactory pf = new SeleniumPageFactory(driver);
		SeleniumWait.getExplicitWait(driver,pf.getCostcoSingInBtn().get(0) , 60);//=> Web element property
		HighLighter.getColor(driver, pf.getCostcoSingInBtn().get(0), "red");
		pf.getCostcoSingInBtn().get(0).click();
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
