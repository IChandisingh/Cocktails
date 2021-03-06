Feature: store glasses
    AS A Customer
    I WANT to store glasses
    SO THAT they can be accessed later

    Scenario: Successfully add new glass to glass database
        Given The app is running
        And I have set a type
        And I have set a volume
        When I add a glass to the database
        Then It should return the glass

Feature: store glasses
    AS A Customer
    I WANT to edit glasses
    SO THAT I can fix incorrect information

    Scenario: Successfully edit a glass in database
        Given The app is running
        And the glass is in the database
        And I have set a type
        And I have set a volume
        When I send a request to edit the glass
        Then It should return a json of the new information

Feature: store glasses
    AS A Customer
    I WANT to delete glasses
    SO THAT they cannot be found in the database

    Scenario: Successfully delete a glass from database
        Given The app is running
        And the glass is in the database
        When I send a request to delete it
        Then it should return deleted

    Scenario: Try to delete a glass that is not in the database
        Given The app is running
        And The glass is not in the database
        When I send a request to delete it
        Then it should return error

