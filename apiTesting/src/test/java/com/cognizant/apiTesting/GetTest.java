package com.cognizant.apiTesting;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GetTest{
	private RequestSpecification request;
	private Response response;
	private ValidatableResponse json;
	
	@Test
	public void getRequest() {
		request = RestAssured.given().contentType(ContentType.JSON);
		response = request.when().get("http://localhost:8090/example/v1/hotels");
		json = response.then().statusCode(200);
	}

}
