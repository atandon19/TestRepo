Feature: Create To and Fro Flight Booking from Bangalore to Mumbai
Background: 

Given User opens MMT flight booking site
When User gets title of the application to verify
Then The title should be of Make My Trip

@MMT
Scenario Outline: Verify user is able to successfully create a flight booking 
When User clicks on round trip button  
When User search for to and fro flight from Source <Source>, Destination <Destination>
When User enters current date for going and date plus one for returning
When User clicks on Search to search flights
Then Search Page should be displayed with list of flights
When User selects by zero stops
When User selects departure time duration from Bangalore 
And  User selects departure time duration from Mumbai
When User selects second flight from the list of flights
Then User verifies for the flight selected and flight displayed at bottom
When User selects details for the return flight
And  User selects Fares And Details
And  User clicks on Book
Then User should be navigated to the Booking Page	
  
 
	Examples: 
		|Source   |Destination|
		|Bangalore|Mumbai     |