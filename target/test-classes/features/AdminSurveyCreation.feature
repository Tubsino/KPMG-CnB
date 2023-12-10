Feature: Admin Validation
  This feature file contains survey creation

  @Done
  Scenario: Validate that super admin can create survey from the dashboard page
    Given that admin is logged in
    When super admin clicks on the survey button from the dashboard
    And Input title of survey in the survey field
    And Input age of data in the the age of data field
    And click on the country field
    And select a country from the list of the dropdown menu for country
    And click on the sponsor field
    And select a sponsor
    And select target of industry dropdown
    And select multiple target from the dropdown list
    And click on the continue button
    And select multiple job grades
    And click the save button
    And click the continue button
    And select multiple companies for comparism
    And click the continu button for completion
    And click the submit button
    Then the survey from should be successfully created

  @Skip
  Scenario: Validate that super admin can select job positions in the benchmark level and create a survey
    Given that admin is logged in
    When super admin clicks on the survey button from the dashboard
    And Input title of survey in the survey field
    And Input age of data in the the age of data field
    And click on the country field
    And select a country from the list of the dropdown menu for country
    And click on the sponsor field
    And select a sponsor
    And select target of industry dropdown
    And select multiple target from the dropdown list
    And click on the continue button
    And select multiple job position
    And click the Add Job Position button
    And select a job position
    And click the continue button after selecting a job position
    And click the save button
    And click the continue button
    And select multiple companies for comparism
    And click the continu button for completion
    And click the submit button
    Then the survey from should be successfully created

  @Done
  Scenario: Validate that super admin can edit survey details from the preview page
    Given that admin is logged in
    When super admin clicks on the survey button from the dashboard
    And Input title of survey in the survey field
    And Input age of data in the the age of data field
    And click on the country field
    And select a country from the list of the dropdown menu for country
    And click on the sponsor field
    And select a sponsor
    And select target of industry dropdown
    And select multiple target from the dropdown list
    And click on the continue button
    And select multiple job grades
    And click the save button
    And click the continue button
    And select multiple companies for comparism
    And click the continu button for completion
    And click on the edit survey details
    And edit title of survey

  @Done
  Scenario: Validate that super admin can edit  bendmark level from the preview page
    Given that admin is logged in
    When super admin clicks on the survey button from the dashboard
    And Input title of survey in the survey field
    And Input age of data in the the age of data field
    And click on the country field
    And select a country from the list of the dropdown menu for country
    And click on the sponsor field
    And select a sponsor
    And select target of industry dropdown
    And select multiple target from the dropdown list
    And click on the continue button
    And select multiple job grades
    And click the save button
    And click the continue button
    And select multiple companies for comparism
    And click the continu button for completion
    And click the submit button
    Then the survey from should be successfully created

  #And click on the edit benchmark (issue with similar elements to be fixed later)
  @issue
  Scenario: Validate that super admin can edit  participant from the preview page
    Given that admin is logged in
    When super admin clicks on the survey button from the dashboard
    And Input title of survey in the survey field
    And Input age of data in the the age of data field
    And click on the country field
    And select a country from the list of the dropdown menu for country
    And click on the sponsor field
    And select a sponsor
    And select target of industry dropdown
    And select multiple target from the dropdown list
    And click on the continue button
    And select multiple job grades
    And click the save button
    And click the continue button
    And select multiple companies for comparism
    And click the continu button for completion
    Then click the exit button

  @Done
  Scenario: Validate that super admin can select job family as  benchmark levels at the point of creating survey from the dashboard page
    Given that admin is logged in
    When super admin clicks on the survey button from the dashboard
    And Input title of survey in the survey field
    And Input age of data in the the age of data field
    And click on the country field
    And select a country from the list of the dropdown menu for country
    And click on the sponsor field
    And select a sponsor
    And select target of industry dropdown
    And select multiple target from the dropdown list
    And click on the continue button
    And click on job family
    And select on Add Job Family
    And select technicals and sports directors
    And click the continue button
    And click on the save and continue button
    And select multiple companies for comparism
    And click the continu button for completion
    And click the submit button
    Then the survey from should be successfully created

  @Done
  Scenario: Validate that super admin can edit survey details on the job family  module from the preview page
    Given that admin is logged in
    When super admin clicks on the survey button from the dashboard
    And Input title of survey in the survey field
    And Input age of data in the the age of data field
    And click on the country field
    And select a country from the list of the dropdown menu for country
    And click on the sponsor field
    And select a sponsor
    And select target of industry dropdown
    And select multiple target from the dropdown list
    And click on the continue button
    And click on job family
    And select on Add Job Family
    And select technicals and sports directors
    And click the continue button
    And click on the save and continue button
    And select multiple companies for comparism
    And click the continu button for completion
    And click on the edit survey details
    And edit title of survey

  @Issue
  Scenario: Validate that super admin can edit  bendmark level on the job family  module from the preview page
    # user can not submit survey after successfully editing the family module
    Given that admin is logged in
    When super admin clicks on the survey button from the dashboard
    And Input title of survey in the survey field
    And Input age of data in the the age of data field
    And click on the country field
    And select a country from the list of the dropdown menu for country
    And click on the sponsor field
    And select a sponsor
    And select target of industry dropdown
    And select multiple target from the dropdown list
    And click on the continue button
    And click on job family
    And select on Add Job Family
    And select technicals and sports directors
    And click the continue button
    And click on the save and continue button
    And select multiple companies for comparism
    And click the continu button for completion
    And click on edit benchmark levels
    And click on the edit options
    And click on job family
    And select on Add Job Family
    And select technicals and sports directors
    And click the continue button
    And click on the save and continue button
    And select multiple companies for comparism
    And select a company
    And click the submit button for completion
    And click the submit button
    And click the submit button in the preview page

  #Then the survey from should be successfully created
  @Done
  Scenario: Validate that super admin can click on the  Survey module
    Given that admin is logged in
    When super admin clicks on the survey module button
    Then the following functionalities should display successfully

  @Done
  Scenario: Validate that super admin can search for Survey
    Given that admin is logged in
    When super admin clicks on the survey module button
    Then the following functionalities should display successfully
    And search for a survey by entering the survey name in the survey field
    Then the searched result should display successfully

  @Done
  Scenario: Validate that super admin can view survey details
    Given that admin is logged in
    When super admin clicks on the survey module button
    Then the following functionalities should display successfully
    And search for a survey by entering the survey name in the survey field
    Then the searched result should display successfully
    And clicks on open on the searched survey
    Then the survey details should display successfully
