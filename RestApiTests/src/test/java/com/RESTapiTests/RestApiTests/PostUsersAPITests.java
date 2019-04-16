package com.RESTapiTests.RestApiTests;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.JsonObject;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class PostUsersAPITests {
	
	Response response;

	//Setup operations
	@Before
	public void setup() {
		
		RestAssured.baseURI = URLConstants.BASE_URL; //Setup Base URI
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.header("Content-Type", "application/json");
		
		// Create new JSON Object
        JsonObject addUsers = new JsonObject();
        addUsers.addProperty("ID", 15);
        addUsers.addProperty("UserName", "TestUser");
        addUsers.addProperty("Password", "Test123");
        
        httpRequest.body(addUsers.toString());
        response = httpRequest.post("/api/Users");
        
		
	}
	
	//checking the 200 response with all correct parameters
			@Test
			public void T01_StatusCodeTest() {
				int statusCode = response.getStatusCode();
		        System.out.println("Status code for post:" +statusCode);
		        String json = response.asString();
				System.out.println("Json results: " +json);
			}

	

}
