package com.interview.selenium;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandleInSelenium {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();// upcasting
		driver.get("http://demo.guru99.com/popup.php");
		driver.manage().window().maximize();
		
		TimeUnit.SECONDS.sleep(3);
		driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();
		driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();
		driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();
		
		
		String currentWindow = driver.getWindowHandle();
		System.out.println("Current window/Parent ="+currentWindow);
		
		// To handle all new opened window.
		Set<String> mySet = driver.getWindowHandles();//All window =Set(remove duplicate)
		for(String eachWindow : mySet) {
			
			System.out.println("All window/Child ="+eachWindow);
			if(!eachWindow.contains(currentWindow)) {// removing current window
				driver.switchTo().window(eachWindow);
				System.out.println("Get child window after switch ="+eachWindow);
			}
			
		}
		
		
		
		
//		Iterator<String> i1 = mySet.iterator();
//
//		while (i1.hasNext()) {
//			TimeUnit.SECONDS.sleep(2);
//			String ChildWindow = i1.next();
//
//			if (!currentWindow.equalsIgnoreCase(ChildWindow)) {
//				TimeUnit.SECONDS.sleep(2);
//				// Switching to Child window
//				driver.switchTo().window(ChildWindow);
//
//				TimeUnit.SECONDS.sleep(2);
//				driver.findElement(By.name("emailid")).sendKeys("sarowerny@gmail.com");
//
//				driver.findElement(By.name("btnLogin")).click();
//				TimeUnit.SECONDS.sleep(10);
//				// Closing the Child Window.
//				driver.close();
//			}
//		}
//		TimeUnit.SECONDS.sleep(5);
//		// Switching to Parent window i.e Main Window.
//		driver.switchTo().window(MainWindow);
//		
//		
//		TimeUnit.SECONDS.sleep(3);
//		//driver.quit();
	}
}
