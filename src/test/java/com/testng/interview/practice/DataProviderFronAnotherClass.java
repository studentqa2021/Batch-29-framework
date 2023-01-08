package com.testng.interview.practice;

import org.testng.annotations.Test;

public class DataProviderFronAnotherClass {
	
	
	  @Test (dataProvider = "loginCredential",dataProviderClass = DataProviderFromSameClass.class)
	  public void testCase3(String a,int b) {
	        System.out.println("Test 3 "+a+","+b);
	    }

}
