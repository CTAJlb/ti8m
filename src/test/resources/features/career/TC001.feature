@ui @functional @001
Feature: Search career

  Scenario: [Functional] Check that job results are shown with entered search criteria
    Given [Career page] open
    When [Career page] set "Senior Software Engineer" text in the search field
    Then [Career page] validate that relevant results is shown as "Senior Software Engineer" in job list title
    When [Career page] remember jobs counter
    When [Career page] set professional field check box with data "Security"
    Then [Career page] validate that jobs counter reduced
    When [Career page] remove professional field check box with data "Security"
    Then [Career page] validate that jobs counter increased



