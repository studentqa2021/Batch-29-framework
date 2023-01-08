package com.testng.interview.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenerTest.class)
public class TestNGListeners {
	WebDriver driver;					
	// Test to pass as to verify listeners .		
	@Test		
	public void Login() throws Throwable				
	{		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.gcrit.com/build3/");
		WebElement myaccountbtn = driver.findElement(By.xpath("//*[contains(text(),'My Account')]"));
		myaccountbtn.click();
		Thread.sleep(4000);
		WebElement loginpageTitle = driver.findElement(By.xpath("//*[contains(text(),'Welcome, Please Sign In')]"));
		if (loginpageTitle.getText().equalsIgnoreCase("Welcome, Please Sign In")) {
			System.out.println("Got the login page::" + loginpageTitle.getText());
		} else {
			System.out.println("Test Failed>>>> Page Title::" + loginpageTitle.getText());
		}
		WebElement email = driver.findElement(By.xpath("(//*[contains(text(),'')]//following::input)[2]"));
		email.sendKeys("sarowerny@gmail.com");
		Thread.sleep(3000);
		WebElement password = driver.findElement(By.xpath("(//*[contains(text(),'')]//following::input)[3]"));
		password.sendKeys("student ");
		Thread.sleep(3000);
		WebElement loginbtn = driver.findElement(By.xpath("//*[starts-with(text(),'Sign In')]"));
		loginbtn.click();
		Thread.sleep(4000);
		WebElement myaccountPage = driver.findElement(By.xpath("//*[contains(text(),'My Account Information')]"));

		if (myaccountPage.getText().equalsIgnoreCase("My Account Information")) {
			System.out.println("Got the My Account Page::" + myaccountPage.getText());
		} else {
			System.out.println("Test Failed>>>> Page Title::" + myaccountPage.getText());
		}
		
		

		// validation
		Assert.assertEquals("GCR Shop", driver.getTitle(), "Test Passed");
		// verification

		if (driver.getTitle().equalsIgnoreCase("GCR Shop")) {
			System.out.println("Test Passed>>>> Page Title::" + driver.getTitle());
		} 
		
		
		else {
			System.out.println("Test Failed>>>> Page Title::" + driver.getTitle());
		}

	

	}
	
	
	// Forcefully failed this test as to verify listener.		
	@Test		
	public void validationData()				
	{						
	    Assert.assertEquals("sarower", "ahmmed");		
	}	
	
	
}
