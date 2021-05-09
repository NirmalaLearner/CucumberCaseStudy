Feature: Valid and InRegistration features
This feature includes scenarios to validate the entire registration process as follows and Teach courses
1) Register as Follow courses with valid details and confirm eamil and then compose, send email
2) Register as Teach courses with valid details and confirm eamil and then compose, send email
3) Register using invalid data and observe the errors

Background:
Given User navigated to signUp page from login page

@FollowCourse @ValidScenario
Scenario: Register as Follow courses with valid details
When I click in SignUp link
And I select the role Follow course
And Fill valid details
And I click on register button
And I should see Registration successful
And I click on user image icon
Then confirm registered email
When I click on homepage
And I click on compose
And Type existing username and select a mail
And Type a mail subject
And Type mail content
And I click on send message
Then Verify the message for successfully sending email
Then I close my browser

@TeachCourse @ValidScenario
Scenario: Register as Teach courses with valid details
When I click in SignUp link
And I select the role Teach course
And Fill valid details
And I click on register button
And I should see Registration successful
And I click on user image icon
Then confirm registered email
When I click on homepage
And I click on compose
And Type existing username and select a mail
And Type a mail subject
And Type mail content
And I click on send message
Then Verify the message for successfully sending email
Then I close my browser

@FollowCourse @InValidScenario
Scenario Outline: Register as Follow with invalid details
When I click in SignUp link
And I select the role Follow course
And I fill some invalid Details "<firstname>","<lastname>","<email>","<username>","<password>","<confirmpassword>"
And I click on register button
Then I should see Respective error message on the page
Then I close my browser

Examples:

|firstname| lastname | email						 | username    |password | confirmpassword
|testqa1  | qatest1  | testqa1@gmail.com |Hibiscus985  |testqa123|testqa123
|testqa1  | qatest1  | testqa1@gmail.com |				     |testqa123|testqa123
|testqa1  | qatest1  | testqa1@					 |testqa10     |testqa123|testqa123
|testqa1  | qatest1  | testqa1@gmail.com |testqa10     |testqa123|testqa111

@TeachCourse @InValidScenario
Scenario Outline: Register as Teach with invalid details
When I click in SignUp link
And I select the role Teach course
And I fill some invalid Details "<firstname>","<lastname>","<email>","<username>","<password>","<confirmpassword>"
And I click on register button
Then I should see Respective error message on the page
Then I close my browser


Examples:

|firstname| lastname | email						 | username    |password | confirmpassword3
|testqa1  | qatest1  | testqa1@gmail.com |Hibiscus985  |testqa123|testqa123
|testqa1  | qatest1  | testqa1@gmail.com |				     |testqa123|testqa123
|testqa1  | qatest1  | testqa1@					 |testqa10     |testqa123|testqa123
|testqa1  | qatest1  | testqa1@gmail.com |testqa10     |testqa123|testqa111

