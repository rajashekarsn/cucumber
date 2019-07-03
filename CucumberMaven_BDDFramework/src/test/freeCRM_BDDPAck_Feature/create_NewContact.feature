#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Create contacts

Scenario Outline: Free CRM Create a New Contact
Given User is logged in
When Title of page is CRM
Then user navigates to create contact page
Then user enters contact details "<firstname>" and "<lastname>" and "<Company>"
Then user clicks on save
#Then Close the browser

Examples:

|	firstname	|	lastname	|	Company	|
|	raj1			|	sn				| abc			|
|	raj2			|	afafa			|	abc2		|
