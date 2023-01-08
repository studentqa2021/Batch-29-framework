package com.testng.interview.practice;

import org.testng.annotations.DataProvider;

public  class DataProviderTest {
	
	 @DataProvider(name = "myLoginDataprovider")
	    public static Object[][] dataProviderMethod() {
	        
		 return new Object[][] { { "user", "sahmmed"}, {"password", "dsda1234"} };
	    }
	

}
