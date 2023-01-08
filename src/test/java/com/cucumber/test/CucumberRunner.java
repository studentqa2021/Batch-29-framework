package com.cucumber.test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		plugin={"json:target/cucumber.json"},
		features ={"src/main/resources/Login.feature"},
		glue={"com.cucumber.test"},
		
		//other options
		monochrome = true,
		dryRun = false,
		strict = true,
		tags = {"@Functional_Test","@SmokeTest"}// 1
		
		)
public class CucumberRunner extends AbstractTestNGCucumberTests{
	@BeforeTest//cucumber hook
	public void setup() {
		//set up code
	}
	@Test //cucumber hook
	public void test1() {
		//test code
	}
	@AfterTest//cucumber hook
	public void teardown() {
		//close any connection
	}
}
