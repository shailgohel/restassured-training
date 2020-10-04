
Feature: Open reqres.in and check user listing APII 
  I want to check userlinsting API of resqres.in site

  
  Scenario: Check GET request t fetch users
    Given I am in resqres site
		When I use OAUth
    When execute GET method for user listing
    Then total should be tweleve
    And status code should be twohudred