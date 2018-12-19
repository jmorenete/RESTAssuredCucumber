Feature: Testing Hotel API

Scenario: Adding a hotel successfully
  Given the website is up and running
  When a user adds a hotel with name (Grand Hotel Madrid)
  Then the status code reads 201
  
Scenario: Adding a hotel successfully
  Given the website is up and running
  When a user adds a hotel with name (Grand Hotel Barcelona)
  Then the status code reads 201
  
 
Scenario: Retrieving information on a hotel
  Given a hotel exists with ID 1
  When a user retrieves the hotel by ID 1
  Then the status code reads 200
  And the name field includes hotel
  
Scenario: Updating information on a hotel
  Given a hotel exists with ID 1
  When a user updates the information
  Then the status code reads 204
  And the name field includes hotel
  
  
     Scenario Outline: Testing the API using a table
   Given a hotel exists with the Name "<name>"
   When a user retrieves the hotel by the name "<name>"
   Then the status code reads 200
   And the ID Field is equal to "<id>"
   
Examples:
    | name   | id |
    | Grand Hotel Madrid | 1 |
    | Grand Hotel Barcelona | 2 |
   
    
    
    
    
  