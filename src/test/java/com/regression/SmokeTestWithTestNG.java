package com.regression;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.drivermanager.DriverManager;
import com.generic.BaseLogin;
import com.generic.ProductTest;
import com.report.ExtentReportAutomation;
import com.selenium.pagefactory.SeleniumPageFactory;
import com.util.Constants;
import com.util.HighLighter;
import com.util.ScreenShot;
import com.util.SeleniumWait;

public class SmokeTestWithTestNG {
	@BeforeTest
	public void setup() {
		System.out.println("Before Test : All Setup code");
	}
	// method name >>alphabetic order= problem
	// priority => ignore alphabetic order
	@Test (priority = 1)
	public void getLogin() {//getLogin=getL=2nd
		System.out.println("First Test = Login");
	}
	
	@Test(priority = 2,enabled =false)
	public void getProduct() {//getProduct=getP=3rd
		System.out.println("Second Test= product");
	}
	
	@Test(priority = 0,enabled =false)
	public void getCartFunction() {//getCartFunction=getC =1st
		System.out.println("Thrid Test= Cart");
	}
	@AfterTest
	public void teardown() {
		System.out.println("After Test: close connection");
	}
}
