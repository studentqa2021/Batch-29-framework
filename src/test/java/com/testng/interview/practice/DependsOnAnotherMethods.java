package com.testng.interview.practice;


import org.testng.annotations.Test;

public class DependsOnAnotherMethods {
	 
		@Test 
		public void setupMethod() {
		 System.out.println("This is setupMethod"); 
		//Assert.assertTrue(false);
		
		}
		 @Test(dependsOnMethods = { "setupMethod" })
		
		 public void method2() {
		 System.out.println("This is login test"); 
		 } 
		} 


