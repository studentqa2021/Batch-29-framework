package com.generic;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import com.drivermanager.DriverManager;
import com.selenium.pagefactory.SeleniumPageFactory;
import com.util.Constants;
import com.util.HighLighter;
import com.util.ScreenShot;
import com.util.SeleniumWait;

public class CostcoAutomation {
	
	public static void productHandle() throws InterruptedException{
		//1)	Go to https://www.costco.com/
		WebDriver driver =DriverManager.getBrowser("chrome");
		driver.manage().window().maximize();
		driver.navigate().to(Constants.COSTCO_URL);
		SeleniumWait.getImplicitWait(driver, 5);//==> HTML
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));//== GUI =wait until all web element loaded in page
		//Get the page name=>title>> getTitle()
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
		//Get the page name
		System.out.println("Login page title/name = "+ driver.getTitle());
		ScreenShot.getScreenShot(driver, "Costco Sign In page");
		//6 =Go back to the home page>> navigate().back()
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		while(true) {//true==> infinite loop
			if(pf.getCostcoSingInBtn().size()>0) {
				break;
			}else {
				driver.navigate().back();
				Thread.sleep(3000);
			}
		}
	
		//7==> Read all options and count options below the login button
			//pf.getCostcoMenuBtn()=list = all ==> loop =for
		
		System.out.println("Menu count = "+pf.getCostcoMenuBtn().size());
		for(int i=0;i<pf.getCostcoMenuBtn().size();i++) {
			HighLighter.getColor(driver, pf.getCostcoMenuBtn().get(i), "white");
			System.out.println(pf.getCostcoMenuBtn().get(i).getText());
			
		}
		//8 >If the deal was there, then mouse over it and read all options

		//mouse hover= Actions class= moveToElement()
		for(int i=0;i<pf.getCostcoMenuBtn().size();i++) {//1st loop
			if(pf.getCostcoMenuBtn().get(i).getText().contains("Deals")) {//true
				HighLighter.getColor(driver, pf.getCostcoMenuBtn().get(i), "red");
				Actions ac = new Actions(driver);
				ac.moveToElement(pf.getCostcoMenuBtn().get(i)).perform();
				Thread.sleep(2000);
				System.out.println("Deal options count = "+pf.getDealOptions().size());
				//Read name of All deal options==> loop
				for(int j=0;j<pf.getDealOptions().size();j++) {//2nd loop
					HighLighter.getColor(driver, pf.getDealOptions().get(j), "green");
					System.out.println(pf.getDealOptions().get(j).getText());
					
				}
				break;
			}
			
		}
//		9)	If the computer section was there inside the deal, then click it	
		for(int i=0;i<pf.getCostcoMenuBtn().size();i++) {//1st loop
			if(pf.getCostcoMenuBtn().get(i).getText().contains("Deals")) {//true
				HighLighter.getColor(driver, pf.getCostcoMenuBtn().get(i), "red");
				pf.getCostcoMenuBtn().get(i).click();
		
			}
		}
		
		sf.assertAll();
	}
	
	public static void main(String[] args) throws InterruptedException {
		CostcoAutomation.productHandle();
		
	}

}
