@tag
Feature: Employee Registration
  I want to use this to validate new Employee Registration

  @tag1
  Scenario: Check new Employee Registration with valid Inputs
    Given i open browser with url "http://orangehrm.qedgetech.com"
    Then i should see login page
    When i enter username as "Admin"
    And i enter password as "Qedge123!@#"
    And i click login
    Then i should see Admin Module
    When i goto add employee page
    And  i enter firstname as "john"
    And  i enter lastname as "J"
    And  i click save
    Then i should see new employee registed in employee list
    When i click logout
    Then i should see login page
    When i close Browser
