Feature: store glasses
    AS AN employee at a bar
    I WANT to store glasses
    SO THAT they can be accessed later

    Scenario: Successfully add new glass to glass database
        Given I have inputted a type
        And I have inputted a volume
        When I add the glass
        Then Saved should be returned
        And the glass should be added to the database