Feature: store glasses
    AS AN employee at a bar
    I WANT to store glasses
    SO THAT they can be accessed later

    Scenario: Successfully add new glass to glass database
        Given The app is running
        And I have set a type
        And I have set a volume
        When I add a glass to the database
        Then It should return saved

    Scenario: Fail to add a new glass
        Given The app is running
        And I have set a type
        And I have not set a volume
        When I add a glass to the database
        Then It should return error