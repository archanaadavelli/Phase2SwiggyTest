@SwiggyLogin
Feature: Login
  @VerifyLogin
  Scenario Outline: Login and verify
    Given user navigate to swiggy home page to login
    When user click on login
    And enter "<phone number>" and click on login
    And enter OTP manually 
    And user click on verify OTP
    Then verify user name as "<user name>"

    Examples: 
      | phone number	| user name |
      | 8008772424	  | Jagan	    |