package com.testng.interview.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderFromSameClass {

	 @DataProvider(name = "loginCredential")
	    public static Object[][] dataProviderMethod() {
	        return new Object[][] { { "Sarower", 99999}, {"Sobhan", 88888} };
	    }

	    @Test (dataProvider = "loginCredential")
	    public void testCase3(String a,int b) {
	        System.out.println("Test 3 "+a+","+b);
	    }
	
}
