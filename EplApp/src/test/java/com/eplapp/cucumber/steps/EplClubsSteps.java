package com.eplapp.cucumber.steps;


import static org.hamcrest.Matchers.hasValue;
import static org.junit.Assert.assertThat;

import java.util.HashMap;

import org.hamcrest.Matchers;

import com.eplapp.cucumber.serenity.ReusableEplClubsSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import junit.framework.Assert;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class EplClubsSteps {
	
	@Steps
	ReusableEplClubsSteps steps;
	
	
	@When("^user sends a request to epl clubs endpoint status code 200 is returned$")
	public void user_sends_a_request_to_epl_endpoint_status_code_200_is_returned() {
		SerenityRest.rest()
		.given()
		.when()
		.get()
		.then()
		.statusCode(200);
		
	}
	
	@When("^user sends create club request 201 status code is returned$")
	public void user_sends_create_club_request_201_status_code_is_returned() {
		steps.createClub()
		.statusCode(201);
	}
	
	@Then("^user sends get club request the created club is returned$")
	public void user_sends_get_club_request_201_status_code_is_returned() {
		String id = steps.id;
		HashMap<String,Object> value =steps.getStudentInfoByFirstName(id);
		assertThat(value, hasValue(id));
	}
	
	@Given("^user has created a club$")
	public void user_has_created_a_club(){
		steps.createClub()
		.statusCode(201);
	}
	
	@When("^user deletes the club by id then 200 is returned$")
	public void user_deletes_the_club_by_id_then_200_is_returned() {
		steps.deleteClubByID(steps.id)
		.statusCode(200);
	}
	
	@SuppressWarnings("deprecation")
	@Then("^user sends a get club request by id empty body returned$")
	public void user_sends_a_get_club_request_by_id_empty_body_returned() {
		Response response = steps.getClubsStatusCode(steps.id)
		.statusCode(200).extract()
		.response();
		int size = response.jsonPath().getList("id").size();
		Assert.assertEquals(size, 0);
	}
	
	@When("^user deletes an ivalid club 404 is returned$")
	public void user_deletes_an_ivalid_club_404_is_returned()	{
		steps.deleteClubByID("1234")
		.statusCode(404);
	}
}