package com.testng.interview.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.generic.BaseLogin;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowsertesting {
	WebDriver driver;

	@Test
	@Parameters("browser")
	public void getbrowser(String browser) throws Throwable {
		// Check if parameter passed from TestNG is 'firefox'
		if (browser.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.google.com");
//			  WebDriverManager.chromedriver().setup();
//			  ChromeOptions chromeOptions = new ChromeOptions();
//			  chromeOptions.addArguments("--headless");
//			   driver = new ChromeDriver(chromeOptions);

		} else if (browser.contains("edge")) {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.costco.com/");
		} else if (browser.contains("safari")) {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			driver.manage().window().maximize();
			driver.get("https://www.amazon.com");
		}

		else {
			// If no browser passed throw exception
			throw new Exception("No driver found");
		}

		// driver.get("http://www.amazon.com/");
		System.out.println("Opened Browser::" + browser);
		
	}

}
