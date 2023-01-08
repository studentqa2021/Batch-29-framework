package com.testng.interview.practice;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class DataProviderAndFactoryTest {
	String a;
	String b;
	
	@Factory(dataProvider = "myLoginDataprovider",dataProviderClass = DataProviderTest.class)
	public  DataProviderAndFactoryTest(String x,String y){//static = no; void = no
		this.a=x;
		this.b=y;
	}
	
	
	
	@BeforeTest
	public void setup() {
		System.out.println("Before Test");
	}
	@Test
	public void getSmoke() {//test =3, run =no
		
		System.out.println("This is 1st test");
		System.out.println(a);
		System.out.println(b);

	}
	@Test

	public void getRegression() {//test =2
		
		System.out.println("This is 2nd test");
		System.out.println(a);
		System.out.println(b);
	}

	@AfterTest
	public void teardown() {
		System.out.println("After test");
	}

	

	
	
	 
	 
}
