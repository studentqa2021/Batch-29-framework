package com.testng.interview.practice;

import org.testng.annotations.Test;

public class EnableOrDisableTest {

	
	@Test(enabled=false)
	public void firstTest() {
		System.out.println("This is First Test");
	}
	@Test()
	public void secondTest() {
		System.out.println("This is Second Test");
	}
	@Test()
	public void thirdtest() {
		System.out.println("This is Third Test");
	}
}
