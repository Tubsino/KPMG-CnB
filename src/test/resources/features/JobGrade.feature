Feature: Job Grade features
  The features is for Super admin to be able to configure Job grade
  
 @Done
    Scenario: Validate that super admin can click on job grade button
    Given that admin is logged in
    When Super Admin clicks on the job grade module  button
    Then job grade page should display successfully