Feature: InValid Registration features
This feature covers all invalid scenarios of registration process to be validated as Tech and Follow courses

1) Try to Register as Follow courses with existing username
2) Try to Register as Follow courses with any mandatroy fields missing
3) Try to Register as Follow courses with invalid email format 
4) Try to Register as Follow courses with mismatch password

1) Try to Register as Teach courses with existing username
2) Try to Register as Teach courses with any mandatroy fields missing
3) Try to Register as Teach courses with invalid email format 
4) Try to Register as Teach courses with mismatch password

Background:
Given User navigated to signUp page from login page

@FollowCourse @InValidScenario
Scenario Outline: Register as Follow with invalid details
When I click in SignUp link
And I select the role Follow course
And I enter firstname as "<firstname>"
And I enter lastname as "<lastname>"
And I enter email as "<email>"
And I enter username as "<username>"
And I enter password as "<password>"
And I confirm password as "<confirmpassword>"
And I click on register button
Then I should see Respective error message on the page
Then I close my browser


Examples:

|firstname| lastname | email						 | username |password | confirmpassword
|testqa1  | qatest1  | testqa1@gmail.com |testqa10  |testqa123|testqa123
|testqa1  | qatest1  | testqa1@gmail.com |				  |testqa123|testqa123
|testqa1  | qatest1  | testqa1@					 |testqa10  |testqa123|testqa123
|testqa1  | qatest1  | testqa1@gmail.com |testqa10  |testqa123|testqa111

@TeachCourse @InValidScenario
Scenario Outline: Register as Teach with invalid details
When I click in SignUp link
And I select the role Teach course
And I enter firstname as "<firstname>"
And I enter lastname as "<lastname>"
And I enter email as "<email>"
And I enter username as "<username>"
And I enter password as "<password>"
And I confirm password as "<confirmpassword>"
And I click on register button
Then I should see Respective error message on the page
Then I close my browser


Examples:

|firstname| lastname | email						 | username |password | confirmpassword3
|testqa1  | qatest1  | testqa1@gmail.com |testqa10  |testqa123|testqa123
|testqa1  | qatest1  | testqa1@gmail.com |				  |testqa123|testqa123
|testqa1  | qatest1  | testqa1@					 |testqa10  |testqa123|testqa123
|testqa1  | qatest1  | testqa1@gmail.com |testqa10  |testqa123|testqa111

