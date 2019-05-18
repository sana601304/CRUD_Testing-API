
@UATTesting
Feature: CRUD Testing API 



  Scenario: POST Scenario
  Given Post JSON with employe details 
  Then Employee details should be inserted
	
	Scenario: Update Scenario
   Given Update age of employee 
  Then Employee age should be updated
   	
  Scenario: Get details of Employee Scenario
    Given Get details of employee 
   	Then Employee details should be recieved
   	
   Scenario: Delete details of Employee Scenario
    Given Delete details of employee 
   	Then Employee details should be Deleted