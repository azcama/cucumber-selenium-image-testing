Feature: Mouse hover actions

  Scenario: Differences in map with hover actions
    Given The Porsche home page
    And The user logins into the site
    When The user makes a checkpoint
    And The user moves the mouse to "Russia" in the map
    Then The page is different to the previous checkpoint

  Scenario: Differences in list with hover actions
    Given The Porsche home page
    And The user logins into the site
    When The user makes a checkpoint
    And The user moves the mouse to "Canada" in the list
    Then The page is different to the previous checkpoint

  Scenario: Same images with map and list interactions
    Given The Porsche home page
    And The user logins into the site
    When The user moves the mouse to "Australia" in the list
    And The user makes a checkpoint
    And The user moves the mouse to "Brazil" in the map
    And The user moves the mouse to "Australia" in the map
    Then The page is the same to the previous checkpoint