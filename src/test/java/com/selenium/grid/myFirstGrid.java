package com.selenium.grid;
/*package com.usa.ttech.practicecode;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class myFirstGrid {

	@Test
	public void mytest() throws MalformedURLException, Throwable {
		WebDriver driver;

		DesiredCapabilities capability = DesiredCapabilities.firefox();
		capability.setBrowserName("firefox");

		capability.setPlatform(Platform.WINDOWS);
		URL url = new URL("http://localhost:4444/wd/hub");
		driver = new RemoteWebDriver(url, capability);
		// Put an Implicit wait,
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Launch the URL
		driver.get("http://toolsqa.wpengine.com/automation-practice-form");
		System.out.println(driver.getTitle());
		// Step 3: Select 'Continents' Drop down ( Use Id to identify the element )
		// Find Select element of "Single selection" using ID locator.
		Select select = new Select(driver.findElement(By.id("continents")));

		// Step 4:) Select option 'Europe' (Use selectByIndex)

		select.selectByVisibleText("Europe");

		// Using sleep command so that changes can be noticed
		Thread.sleep(2000);

		// Step 5: Select option 'Africa' now (Use selectByVisibleText)
		select.selectByIndex(2);
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
			
			 * if(sValue.equals("Africa")){ select.selectByIndex(i); break; }
			 
		}
		// Kill the browser
		driver.quit();
	}

}
*/