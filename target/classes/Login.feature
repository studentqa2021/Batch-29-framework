@SmokeTest
Feature: Login function Test

@TC_1233
Scenario: As a Luma application user, must do successfull login with valid credential.
Given open any browser
And go to application URL
When click sign in button
And put email
And put password
And click secod sign button
Then validate login was successful 