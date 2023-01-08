package com.testng.interview.practice;

import org.testng.annotations.Test;

public class GroupTest2 {
	   String message = ".com";
	 

	   @Test(groups = { "Smoke",})
	   
	   public void test1() {
	      System.out.println("This is smoke 2");
	     
	   }

	   @Test(groups = { "Regression" })
	   
	   public void test2() {
	      System.out.println("This is Regression 2");
	    
	   }

	   @Test(groups = { "Functional" })
	   
	   public void test3() {
	      System.out.println("this is Functional test 2");
	     
	   }  
	}