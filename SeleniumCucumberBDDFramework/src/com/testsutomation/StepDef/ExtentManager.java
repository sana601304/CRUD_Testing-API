package com.testsutomation.StepDef;
import com.cucumber.listener.Reporter;
import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

	private static ExtentReports extent;
	
	public static ExtentReports getInstance() {
		if(extent == null)
			extent = new ExtentReports("D:\\Myreport.html");
		
		extent.loadConfig(new File("Config/report.xml"));
		return extent;
	}
}
