@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Validate that admin cannot login with invalid credentials
    Given that admin is on login page
    When admin input email address in the email field
    And input password in the password field
    And click on the sign in button
    Then it should not be successful
    
    Scenario: Validate that admin can login with valid credentials
    Given that admin is on login page
    When admin input a valid email address in the email field
    And input a valid password in the password field
    And click on the sign in button
    Then it should be successful

    
