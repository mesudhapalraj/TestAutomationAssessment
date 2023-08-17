Feature: Create a new user, get the details of the same user and delete the user from Petstore API


 
 @PetstoreAPI
  Scenario Outline: Create a new user and get the details of the same user and delete it in Petsore API
  Given I Create a new user <Category> <FirstName> in Petstore <SecondName>
  Then I get the newly created user details
  And I Delete the newly created user
  
  Examples: 
		|Category  |FirstName        	   |SecondName        |
		|'Dog'     |    'APIFirstName'     |'APISecondName'   |
