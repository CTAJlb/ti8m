@ui @functional @004
Feature: Search career

  Scenario: [Functional] Check that no results are shown when 3 checkbox filters are used with not relevant search data
    Given [Career page] open
    When  [Career page] submit checkboxes and search input field with next params
      | Location | ProfessionalField | Seniority | SearchInput  |
      | Bern     | Engineering       | Senior    | Junior       |
    Then  [Career page] validate that no results message displayed

