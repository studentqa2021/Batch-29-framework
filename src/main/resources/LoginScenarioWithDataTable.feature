@SmokeTest
Feature: Login function Test

@TC_1233
Scenario: As a Luma application user, must do successfull login with valid credential.
Given open any browser
And go to application URL "<URL>" # parameter
|URL																			|# datatable
|https://magento.softwaretestingboard.com/|
When click sign in button
And put email "<Email>"
|Email|
|sarowerny@gmail.com|
#|fahim@gmail.com| # no
And put password "<Password>"
|Password|
|Student123$|
#|Fahim123$|#No
And click secod sign button
Then validate login was successful 
#limitation = single test data ==> scenario outline