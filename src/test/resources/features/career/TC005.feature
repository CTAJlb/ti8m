@ui @functional @005
Feature: Subscribe new jobs

  Scenario: [Functional] Check that user can subscribe with preferable filters
    Given [Career page] open
    When [Career page] click subscribe new jobs button
    When [Career page] set subscription form with next params
      | Profession  | Location    | ProfessionalField | Seniority   | Designation | Email             |
      | QA Engineer | Bern        | Sales             | Senior      | New job     | myEmail@gmail.com |
    Then [Career page] validate that success registration message displayed

