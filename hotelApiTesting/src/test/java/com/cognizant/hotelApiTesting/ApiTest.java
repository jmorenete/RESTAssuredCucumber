package com.cognizant.hotelApiTesting;

import org.json.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class ApiTest {
	private RequestSpecification request;
	private Response response;
	private ValidatableResponse json;
	
	@Test
	public void getTest() {
		request = RestAssured.given().contentType(ContentType.JSON);
		response = request.when().get("http://localhost:8090/example/v1/hotels");
		json = response.then().statusCode(200);
	}
	@Test
	public void postTest() {
		request = RestAssured.given().contentType(ContentType.JSON);
		request.header("Content-Type", "application/json");
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "Grand hotel");
		jsonObject.put("city", "Barcelona");
		jsonObject.put("rating", 100);
		jsonObject.put("description", "Grand");

		
		request.body(jsonObject.toString());
		
		response = request.post("http://localhost:8090/example/v1/hotels");
		json = response.then().statusCode(201);
	}
	@Test
	public void putTest() {
		request = RestAssured.given().contentType(ContentType.JSON);
		request.header("Content-Type", "application/json");
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "Grand hotel kiki");
		jsonObject.put("city", "Madrid");
		jsonObject.put("rating", 100);
		jsonObject.put("description", "Grand");
		jsonObject.put("id", 5);

		
		request.body(jsonObject.toString());
		response = request.put("http://localhost:8090/example/v1/hotels/5");
		json = response.then().statusCode(204);
		
	}
	
	@Test
	public void deleteTest() {
		request = RestAssured.given().contentType(ContentType.JSON);
		request.header("Content-Type", "application/json");
		
		response = request.delete("http://localhost:8090/example/v1/hotels/2");
		json = response.then().statusCode(204);
		
	}
}
