package com.testng.interview.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class DataProviderAndFactory {
	
	    private String userName;
	    private String password;

	    @Factory (dataProvider="dataProviderMethod")
	    public DataProviderAndFactory( String firstName, String password){
	        this.userName = firstName;
	        this.password = password;
	       // System.out.println("data number"+campoDni);
	    }

	    @DataProvider
	    public static Object[][] dataProviderMethod() {
	        return new Object[][] { { "Sarower", "SundayStudent123$"}, {"Sobhan", "Student2019#"} };
	    }
	    @Test (priority = 1)
	    public void testCase1(){
	        System.out.println("NO parameter And No Value from DataProvider or factory");  
	    }
	    @Test (priority = 2)
	    public void testCase2() { 
	        System.out.println("Test 2 "+userName);
	    }
	    @Test (priority = 3)
	    public void testCase3() throws InterruptedException {
	        System.out.println("Test 3 "+userName+","+password);
	    }
	   
	}


