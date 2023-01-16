package com.generic;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import com.excelFactory.ExcelColumn;
import com.util.HighLighter;

public class LumaProduct {
	
	public static  Map<String, String> getLumaProduct(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//*[text()='Women']")).click();
		Thread.sleep(3000);
		
		List<WebElement> productName =driver.findElements(By.xpath("//*[@class='product-item-name']"));
		List<WebElement> productPrice =driver.findElements(By.xpath("//*[@class='price-wrapper ']"));
		Actions ac = new Actions(driver);
		ac.moveToElement(productPrice.get(0)).build().perform();
		
		Map<String,String> product = new LinkedHashMap<>();
		for(int i=0;i<productName.size();i++) {
//			System.out.println(productName.get(i).getText());
//			System.out.println(productPrice.get(i).getText());
			product.put(productName.get(i).getText(), productPrice.get(i).getText());
			HighLighter.getColor(driver, productName.get(i));
			HighLighter.getColor(driver, productPrice.get(i),"blue");
		}
		
		
		return product;
		
		
	}

	public static void main(String[] args) throws Throwable {
		BaseLogin obj = new BaseLogin();
		WebDriver driver =obj.getLogin();
		Map<String,String> productMap =getLumaProduct(driver);
		System.out.println(productMap);
		String path = "./src/test/resources/Manual test cases.xlsx";
		List<String> excleProduct =ExcelColumn.columnValue(path,0);
		System.out.println("Excel product       = "+excleProduct);
		System.out.println("Application product = "+productMap.keySet());
		List<String> excelPrice =ExcelColumn.columnValue(path,1);
		System.out.println("Excel price       = "+excelPrice);
		System.out.println("Application price = "+productMap.values());
		
		SoftAssert sf = new SoftAssert();
		sf.assertTrue(productMap.keySet().equals(excleProduct));
		sf.assertTrue(productMap.values().equals(excelPrice));
	}

}
