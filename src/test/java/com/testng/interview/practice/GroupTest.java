package com.testng.interview.practice;

import org.testng.annotations.Test;

public class GroupTest {
	   String message = ".com";
	 

	   @Test(groups = { "Smoke"})
	   
	   public void test1() {
	      System.out.println("This is smoke");
	     
	   }

	   @Test(groups = { "Regression" })
	   
	   public void test2() {
	      System.out.println("This is Regression");
	    
	   }

	   @Test(groups = { "Functional" })
	   
	   public void test3() {
	      System.out.println("this is Functional test");
	     
	   }  
	}