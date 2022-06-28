Feature: Login
    In order to manage the employee records
    As a Admin
    I want to access the Oranage HRM portal

  Scenario: Valid Credential
    Given I have browser with OrangeHRM application
    When I Enter username as "Admin"
    And I Enter password as "admin123"
    And I Click on Login button
    Then I should get access to the portal with content as "welcome"

  Scenario Outline: Invalid Credential
    Given I have browser with OrangeHRM application
    When I Enter username as '<username>'
    And I Enter password as '<password>'
    And I Click on Login button
    Then I should get error message as "Invalid credentials"
    Examples:
      | username | password |
      | admin    | abc123   |
      | vinutha  | vinutha1 |
