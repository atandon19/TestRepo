package com.mmt.pages;

import java.util.List;

import org.openqa.selenium.support.FindBy;

import com.mmt.common.Keywords;

import net.serenitybdd.core.pages.WebElementFacade;

public class FlightBookingPage extends Keywords {

	@FindBy(id = "hp-widget__sfrom")
	public WebElementFacade from_city;

	@FindBy(xpath = "//div[@class='locationFilter autocomplete_from']//li[2]")
	public WebElementFacade select_from_city;

	@FindBy(id = "hp-widget__sTo")
	public WebElementFacade to_city;

	@FindBy(xpath = "//div[@class='locationFilter autocomplete_to']//li[2]")
	public WebElementFacade select_to_city;

	@FindBy(id = "hp-widget__depart")
	public WebElementFacade from_calendar;

	@FindBy(id = "hp-widget__return")
	public WebElementFacade to_calendar;

	@FindBy(xpath = "//div[contains(@class,'dateFilter')][1]//td[contains(@class,'ui-datepicker-today')]")
	public WebElementFacade currentdate;

	@FindBy(xpath = "//div[contains(@class,'dateFilterReturn')][1]//td[contains(@class,'ui-datepicker-today')]/following-sibling::td[1]/a  | //div[contains(@class,'dateFilterReturn')][1]//td[contains(@class,'ui-datepicker-today')]/parent::tr/following-sibling::tr/td[1]")
	public WebElementFacade currentplusonedate;

	@FindBy(xpath = "//label[@for='switch__input_2']")
	public WebElementFacade round_trip_btn;

	@FindBy(id = "searchBtn")
	public WebElementFacade search_btn;

	@FindBy(xpath = "//div[@class='row wrap-dep']//div[@class='ng-binding ng-scope']")
	public List<WebElementFacade> list_of_flights;

	@FindBy(xpath = "//div[@class='filter_subdivisions stops_info stops-dep']/div/a")
	public List<WebElementFacade> number_of_stops;

	@FindBy(xpath = "//div[@class='filter_subdivisions departure_timings buckets-dep']/div/a")
	public List<WebElementFacade> time_duration_list;

	@FindBy(xpath = "//div[@class='filter_subdivisions departure_timings buckets-ret']/div/a")
	public List<WebElementFacade> dest_time_duration_list;

	@FindBy(xpath = "(//div[@class='col-xs-6 left_pannel']//span[@class='radio_icon'])[2]")
	public WebElementFacade second_flight_left_radio_btn;

	@FindBy(xpath = "(//div[@class='col-xs-6 right_pannel']//span[@class='radio_icon'])[2]")
	public WebElementFacade second_flight_right_radio_btn;

	@FindBy(xpath = "(//div[@class='col-xs-6 left_pannel']//span[@class='block splt_flght_name ng-binding ng-scope'])[2]")
	public WebElementFacade flight_details_left;

	@FindBy(xpath = "(//div[@class='col-xs-6 right_pannel']//span[@class='block splt_flght_name ng-binding ng-scope'])[2]")
	public WebElementFacade flight_details_right;

	@FindBy(xpath = "//div[@class='col-md-3 col-sm-6 text-right']//preceding-sibling::div/span[@class='font-11 pull-left']")
	public WebElementFacade flight_detail1__footer_left;

	@FindBy(xpath = "//div[@class='col-md-3 col-sm-6 text-right fare_baggage_ttOpen']//preceding-sibling::div/span[@class='font-11 pull-left']")
	public WebElementFacade flight_detail1__footer_right;

	@FindBy(xpath = "//div[@class='col-md-3 col-sm-6 text-right fare_baggage_ttOpen']//a[contains(text(),'Details')]")
	public WebElementFacade return_flight_details;

	@FindBy(xpath = "(//a[contains(text(),'FARE DETAILS & RULES')])[2]")
	public WebElementFacade fares_and_Details;

	@FindBy(xpath = "(//div[@class='clearfix main-div first_active']/a)[2]")
	public WebElementFacade close_details;

	@FindBy(xpath = "//a[text()='Book']")
	public WebElementFacade book_link;

	@FindBy(xpath = "//span[@class='pull-left fare_revw_labl']")
	public WebElementFacade fares_summary_txt;

	public void openURL() {

		open();
		getDriver().manage().window().maximize();
	}

	public boolean verifyTitle() {

		String title = getDriver().getTitle();
		if (title.contains("MakeMyTrip"))
			return true;
		else
			return false;

	}

	public void clickOnCurrentDate() {

		clickOn(from_calendar);
		clickOn(currentdate);
	}

	public void clickOnNextDayToCurrentDate() {

		clickOn(to_calendar);
		clickOn(currentplusonedate);
	}

	public void makeMyTripTitle() {

		System.out.println("The title is" + getDriver().getTitle());
	}

	public void clickOnRoundTrip() {

		clickOn(round_trip_btn);
	}

	public void enterFromCity(String source) {

		typeInto(from_city, source);
		waitABit(1000);
		clickOn(select_from_city);
	}

	public void enterToCity(String destination) {

		typeInto(to_city, destination);
		waitABit(1000);
		clickOn(select_to_city);
	}

	public void clickSearchButton() {

		clickOn(search_btn);
	}

	public boolean verifyListOfFlights() {

		waitABit(2000);
		if (list_of_flights.size() >= 2)
			return true;

		else
			return false;
	}

	public void clickOnZeroStops() {

		waitABit(2000);
		for (WebElementFacade ele : number_of_stops) {

			if (ele.getText().contains("0") && ele.isEnabled()) {

				ele.click();
				break;
			}
		}
		waitABit(4000);
	}

	public void clickOnSourceTimeDuration() {
		try {
			for (WebElementFacade ele : time_duration_list) {
				if (ele.getText().contains("6AM-12PM") && ele.isEnabled()) {
					ele.click();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		waitABit(4000);
	}

	public void clickOnDestinationTimeDuration() {
		try {
			for (WebElementFacade ele : dest_time_duration_list) {

				if (ele.getText().contains("After 6PM") && ele.isEnabled()) {
					ele.click();
					break;
				}
			}
			waitABit(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnSecondFlight() {

		clickOn(second_flight_left_radio_btn);
		clickOn(second_flight_right_radio_btn);
	}

	public boolean verifyFlightDetails() {

		String flightDetail = flight_details_left.getText();
		String returnFightDetail = flight_details_right.getText();
		waitABit(1000);
		String flightDetailFooter = flight_detail1__footer_left.getText();
		String flightDetailReturnFooter = flight_detail1__footer_right.getText();

		if (flightDetail.contains(flightDetailFooter) && returnFightDetail.contains(flightDetailReturnFooter))
			return true;
		else
			return false;
	}

	public void clickDetailsReturnFlight() {

		clickOn(return_flight_details);
		waitABit(2000);
	}

	public void selectFaresAndDetails() {

		clickOn(fares_and_Details);
	}

	public void closeDetails() {
		waitABit(2000);
		clickOn(close_details);
	}

	public void clickOnBook() {

		clickOn(book_link);
		waitABit(4000);
	}

	public boolean verifyBookingPage() {

		if (fares_summary_txt.getText().contains("FARE SUMMARY"))
			return true;
		else
			return false;
	}
}