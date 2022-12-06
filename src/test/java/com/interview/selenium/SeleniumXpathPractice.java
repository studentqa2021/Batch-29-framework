package com.interview.selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.util.HighLighter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumXpathPractice {

	public static void main(String[] args) throws Throwable {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();// upcasting
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://www.costco.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		// go to sign in page
		driver.findElement(By.xpath("//*[text()='Sign In / Register']")).click();
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		//go back to home page
		driver.navigate().back();
		driver.navigate().back();
		Thread.sleep(3000);
		//multiple web elements
		List<WebElement> element = driver.findElements(By.xpath("//*[@class='nav-item']//a"));
		System.out.println("Web element count = "+element.size());
		element.forEach(e->{
			System.out.println(e.getText());
			HighLighter.getColor( driver,e,"blue");
			if(e.getText().contains("Deal")) {
				Actions ac = new Actions(driver);
				ac.moveToElement(e).perform();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				List<WebElement> dealOptions = driver.findElements(By.xpath("//*[@class='nav-item']/a//a"));
				dealOptions.forEach(d->{
					HighLighter.getColor( driver,d,"red");
					System.out.println(d.getText());
					if(d.getText().contains("Computers")) {
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						d.click();
				
						
		List<WebElement> computerOptions = driver.findElements(By.xpath("//*[@class='panel-collapse collapse in']//a/label"));
		computerOptions.forEach(c->{
			HighLighter.getColor( driver,c,"red");
			System.out.println(c.getText());
			if(c.getText().contains("Laptop")) {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				c.click();			
					
					
					}
				});
					}
				});
					}
				});	
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		
		

		//element.get(2).click();

	}

	
}
