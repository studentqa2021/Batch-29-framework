package com.regression;

import org.testng.annotations.Test;

import com.generic.BaseLogin;
import com.report.ExtentReportAutomation;

public class SmokeTestWithTestNG extends ExtentReportAutomation {
	
	@Test
	public void TestRun() {
		BaseLogin obj = new BaseLogin();
		obj.getLogin();
	}

}
