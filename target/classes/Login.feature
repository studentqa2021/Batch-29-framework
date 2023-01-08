@SmokeTest @Regression
Feature: Login function Test
# description: requirement >>acceptance criteria
# background: common step = like login

@TC_1233 @Positive_Scenario
Scenario: As a Luma application user, must do successfull login with valid credential.
Given open any browser
And go to application URL
When click sign in button
And put email
And put password
And click secod sign button
Then validate login was successful 

# can we pass test data ? Yes(datatable)

