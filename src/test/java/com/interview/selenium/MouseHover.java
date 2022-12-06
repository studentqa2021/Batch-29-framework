package com.interview.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Highlighter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.util.HighLighter;
import com.util.ScreenShot;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHover {

	public static void main(String[] args) throws Throwable {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();// upcasting
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.costco.com/");

		

		List<WebElement> element = driver.findElements(By.xpath("//*[@class='nav-item']//a"));
		HighLighter.getColor( driver,element.get(2));
		ScreenShot.getScreenShot(driver, "Amazon home page");
		Thread.sleep(2000);
		Actions action = new Actions(driver);

		action.moveToElement(element.get(2)).build().perform();
		
		

		//element.get(2).click();

	}

}
