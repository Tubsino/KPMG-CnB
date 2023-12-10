Feature: User Management
  The features is for Super admin to be able to manage the users registered on the system

  @Done
  Scenario: Validate that super admin can click on the manage user module
    Given that admin is logged in
    When super admin clicks on the manage user button
    Then the manage user page should display succesfully

  @Done
  Scenario: Validate that super admin can click on the user tab
    Given that admin is logged in
    When super admin clicks on the manage user button
    And clicks on the user tab
    Then the user tab page should open successful

  @Done
  Scenario: Validate that super admin can search for user
    Given that admin is logged in
    When super admin clicks on the manage user button
    And clicks on the user tab
    Then the user tab page should open successful
    And enter user name in the search field
    Then the search result should be successful

  @Done
  Scenario: Validate that super admin can cancel user creation
    Given that admin is logged in
    When super admin clicks on the manage user button
    And clicks on the user tab
    And clicks on the New User button
    Then a new user form in the form of prompt should display
    And clicks on the cancel button from the prompt
    Then the user tab page should open successful

  @Done
  Scenario: Validate that super admin can add new user
    Given that admin is logged in
    When super admin clicks on the manage user button
    And clicks on the user tab
    And clicks on the New User button
    Then a new user form in the form of prompt should display
    And enters first name in the first name field
    And enters last name in the last name field
    And enters email in the email address field
    And select a role for the new user
    And clicks on the Add user button
    Then a new user should be successfully created

  @Done
  Scenario: Validate that super admin can filter user by selecting the deactivate option
    Given that admin is logged in
    When super admin clicks on the manage user button
    And clicks on the user tab
    Then the user tab page should open successful
    And clicks the filter button
    Then the status filter option should display
    And selects the deactivate option
    Then list of deactivated users should display successfully

  @Done
  Scenario: Validate that super admin can filter user by selecting the Activated option
    Given that admin is logged in
    When super admin clicks on the manage user button
    And clicks on the user tab
    Then the user tab page should open successful
    And clicks the filter button
    Then the status filter option should display
    And selects the activate option
    Then list of activated users should display successfully

  @Done
  Scenario: Validate that super admin can filter user by selecting the all option
    Given that admin is logged in
    When super admin clicks on the manage user button
    And clicks on the user tab
    Then the user tab page should open successful
    And clicks the filter button
    Then the status filter option should display
    And selects the all option
    Then list of all users should display successfully

  @Done
  Scenario: Validate that super admin can close filter
    Given that admin is logged in
    When super admin clicks on the manage user button
    And clicks on the user tab
    Then the user tab page should open successful
    And clicks the filter button
    Then clicks the close filter button and it should be successful

  @Done
  Scenario: Validate that super admin can change user role
    Given that admin is logged in
    When super admin clicks on the manage user button
    And clicks on the user tab
    Then the user tab page should open successful
    And enter user name in the search field
    Then the search result should be successful
    And clicks the elipses button of the user to modify
    And clicks on the Change Role button
    And modify the user role from the user role field
    Then click the update role button
    And the role should be successfully updated
    And re-enter user name in the search field
    Then the search result should be successful
    And clicks the elipses button of the user to modify
    And clicks on the Change Role button
    And modify the user role back to it previous role
    Then click the update role button
    And the role should be successfully updated

  @Done
  Scenario: Validate that super admin can view user details
    Given that admin is logged in
    When super admin clicks on the manage user button
    And clicks on the user tab
    Then the user tab page should open successful
    And enter user name in the search field
    Then the search result should be successful
    And clicks the elipses button of the user to modify
    And clicks on the View Details button
    Then the user details should display successfully

  @Done
  Scenario: Validate that user can Deactivate user account button
    Given that admin is logged in
    When super admin clicks on the manage user button
    And clicks on the user tab
    Then the user tab page should open successful
    And enter user name in the search field
    Then the search result should be successful
    And clicks the elipses button of the user to modify
    And click the deactivate button
    And click the deactivate button in the prompt
    Then the account should be deactivated successfully
    And enter user name in the search field
    Then the search result should be successful
    And clicks the elipses button of the user to modify
    And click the reactivate button
    And click the activate button in the prompt
    Then the account should be activated sucessfully

  @Done
  Scenario: Validate that user can cancel the  Deactivation of  user account
    Given that admin is logged in
    When super admin clicks on the manage user button
    And clicks on the user tab
    Then the user tab page should open successful
    And enter user name in the search field
    Then the search result should be successful
    And clicks the elipses button of the user to modify
    And click the deactivate button
    And click the cancel button
    Then the cancel button should be successful

  @Done
  Scenario: Validate that user can Remove user account button
    Given that admin is logged in
    When super admin clicks on the manage user button
    And clicks on the user tab
    Then the user tab page should open successful
    And enter the user name on the search field
    And clicks the elipses button of the user to modify
    And clicks the remove this user button
    And clicks on the delete button
    Then the user should be removed successfully

  @Done
  Scenario: Validate that super admin can click on the role tab
    Given that admin is logged in
    When super admin clicks on the manage user button
    And clicks on the role tab
    Then the role tab should display successfully

  @Done
  Scenario: Validate that super admin can search for role
    Given that admin is logged in
    When super admin clicks on the manage user button
    And clicks on the role tab
    Then the role tab should display successfully
    And enter the role name to search with in the role field
    Then the role with the role name search with should display successfully

  @Done
  Scenario: Validate that super admin can cancel role creation
    Given that admin is logged in
    When super admin clicks on the manage user button
    And clicks on the role tab
    Then the role tab should display successfully
    And clicks on the add role button
    Then clicks on the cancel button
    And the role cancelation should be successful

  @Skip
  Scenario: Validate that super admin can add new role
    Given that admin is logged in
    When super admin clicks on the manage user button
    And clicks on the role tab
    Then the role tab should display successfully
    And clicks on the add role button
    And enter new role name
    And selects  can edit checkbox  as User Management
    And selects the  Head Of Department dropdown
    And select  Head Of Department as super admin optional
    And clicks on the Save button to add new role
    Then the new role should be successfully created

  @Skip
  Scenario: Validate that super admin can delete role
    #Come back to this later
    #I will need to add explicit wait after search the role
    Given that admin is logged in
    When super admin clicks on the manage user button
    And clicks on the role tab
    Then the role tab should display successfully
    And enter role name to search for in the search field
    Then the role name searched for should display successfully
    And click the elipse button to display the options
    And click on the remove role button
    And click the delete role button
    Then role should be deleted successfully
    
