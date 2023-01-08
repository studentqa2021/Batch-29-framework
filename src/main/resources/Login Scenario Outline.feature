@SmokeTest
Feature: Login function Test

@TC_1233
Scenario Outline: As a Luma application user, must do successfull login with valid credential.
Given User able to open any browser
And go to application URL "<URL>" and go to login page
When User able to click sign in button
And User able to put email "<Email>"
And User able to put password "<Password>"
And User able to click secod sign button
Then User able to validate login test status 

#Example table
Examples:
|URL																			|Email              |Password   |
|https://magento.softwaretestingboard.com/|sarowerny@gmail.com|Student123$|
|https://magento.softwaretestingboard.com/|batch29@gmail.com  |password123$|
|https://magento.softwaretestingboard.com/|batch29@gmail.com  |password123$|

# single or multiple test data