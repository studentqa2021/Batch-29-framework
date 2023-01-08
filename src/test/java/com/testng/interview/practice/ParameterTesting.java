package com.testng.interview.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParameterTesting {
	WebDriver  driver;
	
	@Test
	@Parameters({"Browser"}) // browser =fire,chrom,safari
	public void getbrowser(String browserName) {
		//browserValue=browser
		System.out.println("Browser name found ="+browserName);
		//windows = chrome + edge
		//mac = chrome + safari
		if(browserName.contains("chrome")) {//run
			WebDriverManager.chromedriver().setup();
			  driver = new ChromeDriver();
			  driver.manage().window().maximize();
			  driver.navigate().to("https://www.google.com");
			//login
		}else if(browserName.contains("Edge")) {//run
			WebDriverManager.edgedriver().setup();
			  driver = new EdgeDriver();
			  driver.manage().window().maximize();
			  driver.navigate().to("https://www.google.com");
			//login
		}else if(browserName.contains("Safari")) {
			WebDriverManager.safaridriver().setup();
			  driver = new SafariDriver();
			  driver.manage().window().maximize();
			  driver.navigate().to("https://www.google.com");
			//login
		}else if(browserName.contains("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			  driver = new FirefoxDriver();
			  driver.manage().window().maximize();
			  driver.navigate().to("https://www.google.com");
			//login
		}else {
			System.out.println("Browser name is differet ");
		}
	
	}

}
