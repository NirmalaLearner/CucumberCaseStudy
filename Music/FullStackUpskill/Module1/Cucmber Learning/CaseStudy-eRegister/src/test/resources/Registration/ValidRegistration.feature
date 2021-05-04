Feature: Valid Registration features
This feature includes scenarios to validate the entire registration process as follows and Teach courses
1) Register as Follow courses with valid details
2) Register as Follow courses with valid details

Background:
Given User navigated to signUp page from login page

@FollowCourse @ValidScenario
Scenario: Register as Follow courses with valid details
When I click in SignUp link
And I select the role Follow course
And Fill valid details
Then I should see Registration successful
Then I close my browser

@TeachCourse @ValidScenario
Scenario: Register as Teach courses with valid details
When I click in SignUp link
And I select the role Tech course
And Fill valid details
Then I should see Registration successful
Then I close my browser