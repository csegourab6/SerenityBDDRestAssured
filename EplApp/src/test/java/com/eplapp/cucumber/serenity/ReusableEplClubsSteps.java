package com.eplapp.cucumber.serenity;

import java.util.HashMap;

import com.eplapp.model.ClubBuilder;
import com.eplapp.utils.ReusableSpecifications;
import com.eplapp.utils.Utility;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;


public class ReusableEplClubsSteps {
	public static String id = "";
	Utility utility = new Utility();
	
	@Step("Create Club")
	public ValidatableResponse createClub() {
		
		id = utility.getDateTime();
		String clubName = utility.genarateRandomString();
		String key = utility.genarateRandomString();
		
		ClubBuilder cb = new ClubBuilder(id, clubName, key);
		String newClub = cb.createClubBody();
		
		return	SerenityRest.rest().given()
				.spec(ReusableSpecifications.getGenericRequestSpec())
				.when()
				.body(newClub)
				.post()
				.then();
	}
	
	@Step("Get Status code by id of Get Clubs")
	public ValidatableResponse getClubsStatusCode(String id){
		return SerenityRest.rest()
		.given()
		.when()
		.get("?id="+id)
		.then();
		
				
	}
	
	
	@Step("Get Club By Id")
	public HashMap<String,Object> getStudentInfoByFirstName(String id){
		String p1 = "findAll{it.id=='";
		String p2 = "'}.get(0)";
		
	return	SerenityRest.rest().given()
		.when()
		.get("?id="+id)
		.then()
		.log()
		.all()
		.statusCode(200)
		.extract()
		.path(p1+id+p2);
	} 
	
	
	@Step("Delete Club By Id")
	public ValidatableResponse deleteClubByID(String id) {
		
		return SerenityRest.rest()
		.given()
		.when()
		.delete("/"+id)
		.then();	
	}
	
	

}
