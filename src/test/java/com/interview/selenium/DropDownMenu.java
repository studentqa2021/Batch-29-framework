package com.interview.selenium;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownMenu {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();// upcasting
		driver.manage().window().maximize(); //
		// Put an Implicit wait,
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Launch the URL
		driver.get("https://demo.guru99.com/test/newtours/");
		driver.findElement(By.xpath("//*[contains(text(),'REGISTER')]")).click();

		Select select = new Select(driver.findElement(By.name("country")));
		select.selectByVisibleText("BANGLADESH");

		// Using sleep command so that changes can be noticed
		Thread.sleep(2000);

		// Step 5: Select option 'Australia' now (Use selectByVisibleText)
		select.selectByIndex(12);

		Thread.sleep(2000);
		select.selectByValue("CHINA");

		Thread.sleep(2000);
		// Step 6: Print all the options for the selected drop down and select one
		// option of your choice
		// Get the size of the Select element
		List<WebElement> dropDownOptions = select.getOptions();

		int OptionsCount = dropDownOptions.size();

		// Setting up the loop to print all the options
		for (int i = 0; i < OptionsCount; i++) {
			// Storing the value of the option
			String value = select.getOptions().get(i).getText();
			// Printing the stored value
			System.out.println(value);
			// Putting a check on each option that if any of the option is equal to 'Africa"
			// then select it

			if (value.equals("UNITED STATES")) {
				select.selectByIndex(i);
				break;
			}

		}
		// Kill the browser
		driver.quit();

	}

}
