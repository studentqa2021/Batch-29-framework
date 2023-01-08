package com.regression;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class PracticeParameterAnnotationTestNG {
	
	@Test
	@Parameters({"URL","user","password"})
	public void test(String URL,String user,String password) {
		System.out.println(URL);
		System.out.println(user);
		System.out.println(password);
	}

}
// must run test from xml , not from code