Feature: Search for a lesson on Nagwa Website

  Scenario: Search for lesson
    Given Open Home page
    And Choose "English" language
    When search for "addition" lesson
    Then all lessons in nagwa that match "addition" name will appear
    When click on lesson number 2
    And click on preview button
    Then Worksheet home page will open
    And count number of questions is displayed
    And print the questions cunts

