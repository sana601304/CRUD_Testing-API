package com.testsutomation.StepDef;
import java.io.FileNotFoundException;
import com.testsutomation.StepDef.ConfigFileReader;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;


import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.omg.IOP.Encoding;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
//import com.testautomation.Utility.PropertiesFileReader;

import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import java.io.*; 
import java.nio.file.Files;
public class POSTandPUT {

	@Given("^Post JSON with employe details$")
	public void postJSONWithEmployeDetails() throws Throwable {
		try {	
		
	ConfigFileReader configFileReader = new ConfigFileReader();
	// Read post url
    String query_url = configFileReader.geturl();
   // Read json file
    String fileName = "Postdata.json";
  
    ClassLoader classLoader = this.getClass().getClassLoader();
    File configFile=new File(classLoader.getResource(fileName).getFile()); 
    
    FileInputStream  inputStream = null;
    inputStream = new FileInputStream(configFile);
    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
    String json="";
    String postData = "";
    System.out.println("Request POST Json is : ");
    while ((postData = reader.readLine()) != null) {
  
    json=postData;
    System.out.println(json);
    }
    
    URL url = new URL(query_url);
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setConnectTimeout(5000);
    conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
    conn.setDoOutput(true);
    conn.setDoInput(true);
    conn.setRequestMethod("POST");
    
    OutputStream os = conn.getOutputStream();
    OutputStreamWriter osw =  new OutputStreamWriter(os, "UTF-8");
  
    byte[] jsonByte = json.getBytes("UTF-8");
      
    os.write(json.getBytes("UTF-8"));
    os.close(); 
    // read the response
    InputStream in = new BufferedInputStream(conn.getInputStream());
    String result = IOUtils.toString(in, "UTF-8");
    System.out.println("Below Employee successfuly inserted : ");
    System.out.println(result);
    
    JSONObject myResponse = new JSONObject(result);
    System.out.println("jsonrpc- "+myResponse.getString("jsonrpc"));
    System.out.println("id- "+myResponse.getInt("id"));
    System.out.println("result- "+myResponse.getString("result"));
    in.close();
    conn.disconnect();
      
    } catch (Exception e) {
    	//e.printStackTrace();
    }
}
	
	@Then("^Employee details should be inserted$")
	public void Employee_details_should_be_inserted() throws Throwable {
		System.out.println("Employee Details Inserted");
		  System.out.println ("**********************************");
	}
	
	
	@Given("^Update age of employee$")
	public void Updateageofemployee() throws Throwable {
		try {	
		
	ConfigFileReader configFileReader = new ConfigFileReader();
    String query_url = configFileReader.puturl();
   
    String fileName = "Putdata.json";
  
    ClassLoader classLoader = this.getClass().getClassLoader();
    File configFile=new File(classLoader.getResource(fileName).getFile()); 
    
    FileInputStream  inputStream = null;
    inputStream = new FileInputStream(configFile);
    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
    String json="";
    String postData = "";
    System.out.println("Request PUT json is : ");
    while ((postData = reader.readLine()) != null) {
  
    json=postData;
    System.out.println(json);
    }
    
    URL url = new URL(query_url);
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setConnectTimeout(5000);
    conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
    conn.setDoOutput(true);
    conn.setDoInput(true);
    conn.setRequestMethod("PUT");
    
    OutputStream os = conn.getOutputStream();
    OutputStreamWriter osw =  new OutputStreamWriter(os, "UTF-8");
  
    byte[] jsonByte = json.getBytes("UTF-8");
      
    os.write(json.getBytes("UTF-8"));
    os.close(); 
    // read the response
    InputStream in = new BufferedInputStream(conn.getInputStream());
    String result = IOUtils.toString(in, "UTF-8");
    System.out.println("Employee Age successfuly Updated : ");
    System.out.println(result);

    JSONObject myResponse = new JSONObject(result);
    System.out.println("jsonrpc- "+myResponse.getString("jsonrpc"));
    System.out.println("id- "+myResponse.getInt("id"));
    System.out.println("result- "+myResponse.getString("result"));
    in.close();
    conn.disconnect();
      
    } catch (Exception e) {
    	//e.printStackTrace();
    }
}
	@Then("^Employee age should be updated$")
	public void Employeeageshouldbeupdated() throws Throwable {
		System.out.println("Employee Age is updated");
		  System.out.println ("**********************************");
	}
	
	@Given("^Get details of employee$")
	public void Getdetailsofemployee() throws Throwable {
		try {	
		
	ConfigFileReader configFileReader = new ConfigFileReader();
    String query_url = configFileReader.getmethodurl();
   
    URL url = new URL(query_url);
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setConnectTimeout(5000);
    conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
    conn.setDoOutput(true);
    conn.setDoInput(true);
    conn.setRequestMethod("GET");
    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
  
    		String inputLine;
    		while ((inputLine = in.readLine()) != null) {
    		System.out.println(inputLine);
    		} 


    		in.close();
    		
    conn.disconnect();
      
    } catch (Exception e) {
    	e.printStackTrace();
    }
}
	
	@Then("^Employee details should be recieved$")
	public void Employeedetailsshouldberecieved() throws Throwable {
		System.out.println("Employee details are dsipalyed");
		  System.out.println ("**********************************");
	}
	
	
	@Given("^Delete details of employee$")
	public void Deletedetailsofemployee() throws Throwable {
		try {	
		
	ConfigFileReader configFileReader = new ConfigFileReader();
    String query_url = configFileReader.deleteurl();
   
    URL url = new URL(query_url);
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setConnectTimeout(5000);
    conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
    conn.setDoOutput(true);
    conn.setDoInput(true);
    conn.setRequestMethod("DELETE");
    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
  
    		String inputLine;
    		while ((inputLine = in.readLine()) != null) {
    		System.out.println(inputLine);
    		} 


    		in.close();
    		
    conn.disconnect();
      
    } catch (Exception e) {
    	e.printStackTrace();
    }
}
	
	@Then("^Employee details should be Deleted$")
	public void EmployeedetailsshouldbeDeleted() throws Throwable {
		System.out.println("Employee details DELETED");
		  System.out.println ("**********************************");
	}
}

	
		
	
				

		
	
