@SwiggyLocation
Feature: Set Location
  @SwiggyLocationSet
  Scenario Outline: Set location and verify
    Given user navigate to swiggy home page to setlocation
    When user set location "<location>"
    And selet the locaiton from list 
    Then user verify the location as "<locationset>"

    Examples: 
      | location	| locationset |
      | Hyderabad | Hyderabad   |
