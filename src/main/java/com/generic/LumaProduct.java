package com.generic;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.excelFactory.ExcelColumn;

public class LumaProduct {
	
	public static  Map<String, String> getLumaProduct(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//*[text()='Women']")).click();
		Thread.sleep(3000);
		
		List<WebElement> productName =driver.findElements(By.xpath("//*[@class='product-item-name']"));
		List<WebElement> productPrice =driver.findElements(By.xpath("//*[@class='price-wrapper ']"));
		
		Map<String,String> product = new LinkedHashMap<>();
		for(int i=0;i<productName.size();i++) {
//			System.out.println(productName.get(i).getText());
//			System.out.println(productPrice.get(i).getText());
			product.put(productName.get(i).getText(), productPrice.get(i).getText());
		}
		
		
		return product;
		
		
	}

	public static void main(String[] args) throws Throwable {
		BaseLogin obj = new BaseLogin();
		WebDriver driver =obj.getLogin();
		Map<String,String> productMap =getLumaProduct(driver);
		System.out.println(productMap);
		List<String> excleProduct =ExcelColumn.columnValue(0);
		System.out.println(excleProduct);
		System.out.println(productMap.keySet());
		List<String> excelPrice =ExcelColumn.columnValue(1);
		System.out.println(excelPrice);
		System.out.println(productMap.values());
		
		SoftAssert sf = new SoftAssert();
		sf.assertTrue(productMap.keySet().equals(excleProduct));
		sf.assertTrue(productMap.values().equals(excelPrice));
	}

}
