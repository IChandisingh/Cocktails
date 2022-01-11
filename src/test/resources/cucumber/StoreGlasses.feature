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

    Scenario: Fail to add new glass
        Given The app is running
        And I have set a type
        When I add a glass to the database
        Then it should return error

    Scenario: Successfully edit a glass in database
        Given The app is running
        And The glass is in the database
        When I send a request to edit the glass
        Then It should return a json of the new information