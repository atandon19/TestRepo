package com.mmt.steps.flightbook;

import org.junit.Assert;

import com.mmt.steps.PageReferences;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FlightBookingStepDefinition extends PageReferences {

	@Given("^User opens MMT flight booking site$")
	public void user_opens_MMT_flight_booking_site() {
	   
		flightPage.openURL();
		
	}
	

	@When("^User gets title of the application to verify$")
	public void user_gets_title_of_the_application_to_verify() {
		Assert.assertTrue(flightPage.verifyTitle());
	}


	@Then("^The title should be of Make My Trip$")
	public void the_title_should_be_of_Make_My_Trip() {
	 
		flightPage.makeMyTripTitle();
	}
	
	@When("^User clicks on round trip button$")
	public void user_clicks_on_round_trip_button() {
	    
		flightPage.clickOnRoundTrip();
	}
	
	@When("^User search for to and fro flight from Source ([^\\\\\\\"]*), Destination ([^\\\\\\\"]*)$")
	public void user_search_for_to_and_fro_flight(String source, String destination) {
	
		flightPage.enterFromCity(source);
		flightPage.enterToCity(destination);
	}

	
	
	@When("^User enters current date for going and date plus one for returning$")
	public void user_enters_current_date_for_going_and_date_plus_one_for_returning() {
	    
		flightPage.clickOnCurrentDate();
	    flightPage.clickOnNextDayToCurrentDate();
	}

	@When("^User clicks on Search to search flights$")
	public void user_clicks_on_Search_to_search_flights() {
	    
		flightPage.clickSearchButton();
	    
	}

	@Then("^Search Page should be displayed with list of flights$")
	public void search_Page_should_be_displayed_with_list_of_flights() {
	    
		Assert.assertTrue(flightPage.verifyListOfFlights());
	}

	@When("^User selects by zero stops$")
	public void user_selects_by_zero_stops() {
	   
		flightPage.clickOnZeroStops();
	    
	}

	@When("^User selects departure time duration from Bangalore$")
	public void user_selects_departure_time_duration_from_Bangalore() {
		flightPage.clickOnSourceTimeDuration();
	}


	@When("^User selects departure time duration from Mumbai$")
	public void user_selects_departure_time_duration_from_Mumbai() {
		flightPage.clickOnDestinationTimeDuration();
	}

	@When("^User selects second flight from the list of flights$")
	public void user_selects_second_flight_from_the_list_of_flights() {
	   	
	    flightPage.clickOnSecondFlight();
	}

	@Then("^User verifies for the flight selected and flight displayed at bottom$")
	public void user_verifies_for_the_flight_selected_and_flight_displayed_at_bottom() {
		Assert.assertTrue(flightPage.verifyFlightDetails());
	}
	
	
	@When("^User selects details for the return flight$")
	public void user_selects_details_for_the_return_flight() {
	    
		flightPage.clickDetailsReturnFlight();
	    
	}

	@When("^User selects Fares And Details$")
	public void user_selects_Fares_And_Details() {
	    
	    flightPage.selectFaresAndDetails();
	    flightPage.closeDetails();
	}

	@When("^User clicks on Book$")
	public void user_clicks_on_Book() {
	    
	    flightPage.clickOnBook();
		
	}

	@Then("^User should be navigated to the Booking Page$")
	public void user_should_be_navigated_to_the_Booking_Page() {
	    
		Assert.assertTrue(flightPage.verifyBookingPage());
	}

}
