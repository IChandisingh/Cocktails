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

    Scenario: Successfully edit a glass in database
        Given The app is running
        And I have set a type
        And I have set a volume
        When I send a request to edit the glass
        Then It should return a json of the new information

    Scenario: Successfully delete a glass from database
        Given The app is running
        And a glass with the specific id has been added
        When I send a request to delete it
        Then it should return deleted

