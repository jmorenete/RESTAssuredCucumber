package com.cognizant.cucumberRestasured;

import static org.junit.Assert.fail;

import org.json.JSONObject;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Step {
	private RequestSpecification request;
	private Response response;

	
	@Given("^a film exists with the Title Guardians of the Galaxy Two$")
	public void a_film_exists_with_the_Title_Guardians_of_the_Galaxy_Two() throws Throwable {
		request = RestAssured.given().contentType(ContentType.JSON);
	}

	@When("^a user retrieves the film by the title Guardians of the Galaxy Two$")
	public void a_user_retrieves_the_film_by_the_title_Guardians_of_the_Galaxy_Two() throws Throwable {
		response = request.when().get("http://www.omdbapi.com/?i=tt3896198&apikey=5e886466");
	}

	@Then("^the status code reads (\\d+)$")
	public void the_status_code_reads(int arg1) throws Throwable {
		ValidatableResponse json = response.then().statusCode(200);
	}

	@Given("^a film exists with the Title IT$")
	public void a_film_exists_with_the_Title_IT() throws Throwable {
		request = RestAssured.given().contentType(ContentType.JSON);
	}

	@When("^a user retrieves the film by the title IT$")
	public void a_user_retrieves_the_film_by_the_title_IT() throws Throwable {
		response = request.when().get("http://www.omdbapi.com/?apikey=5e886466&t=IT");
	}

	@Then("^the Rated Field is equal to R$")
	public void the_Rated_Field_is_equal_to_R() throws Throwable {
		String responseBody = response.getBody().asString();
		JSONObject responseBodyJSON = new JSONObject(responseBody);
		
		boolean ratedCheck  = responseBodyJSON.get("Rated").equals("R");
		
		
		if(ratedCheck) {
			ValidatableResponse json = response.then().statusCode(200);
		}
		else {
			fail();
		}
	}

	@Given("^a film exists with the Title \"([^\"]*)\"$")
	public void a_film_exists_with_the_Title(String arg1) throws Throwable {
		request = RestAssured.given().contentType(ContentType.JSON);
	}

	@When("^a user retrieves the film by the title \"([^\"]*)\"$")
	public void a_user_retrieves_the_film_by_the_title(String arg1) throws Throwable {
		response = request.when().get("http://www.omdbapi.com/?apikey=5e886466&t=" +arg1);
	}

	@Then("^the Rated Field is equal to \"([^\"]*)\"$")
	public void the_Rated_Field_is_equal_to(String arg1) throws Throwable {
		String responseBody = response.getBody().asString();
		JSONObject responseBodyJSON = new JSONObject(responseBody);
		
		boolean ratedCheck  = responseBodyJSON.get("Rated").equals(arg1);
		
		
		if(ratedCheck) {
			ValidatableResponse json = response.then().statusCode(200);
		}
		else {
			fail();
		}
	}

}
