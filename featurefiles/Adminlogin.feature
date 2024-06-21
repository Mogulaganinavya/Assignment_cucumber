@tag
Feature: Admin Login
  I want to use this template to check Admin Login

  @tag1
  Scenario: AdminLogin with valid Inputs
    Given i open browser with url "http://orangehrm.qedgetech.com"
    Then i should see login page
    When i enter username as "Admin"
    And i enter password as "Qedge123!@#"
    And i click login
    When i should see Admin Module
    And i click logout
    Then i should see login page
    When i close Browser

  @tag2
  Scenario Outline: AdminLogin with Invalid Credentials
    Given i open browser with url "http://orangehrm.qedgetech.com"
    Then i should see login page
    When i enter username as "<usename>"
    And i enter password as "<password>"
    And i click login
    Then i should see err message
    When i close Browser

    Examples: 
      | Username | Password |
      | Admin    | Xyz      |
      | XYZ      | Qedge123 |
      | xyz      | Admin    |
