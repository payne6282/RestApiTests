package com.RESTapiTests.RestApiTests;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.JsonObject;
import com.jayway.restassured.RestAssured;
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
		
		// Create new JSON Object with user properties for Id, username and password
        JsonObject addUsers = new JsonObject();
        addUsers.addProperty("ID", 15);
        addUsers.addProperty("UserName", "TestUser");
        addUsers.addProperty("Password", "Test123");
        
        httpRequest.body(addUsers.toString()); //convert the json object to string
        
        //do the Post request
        response = httpRequest.post("/api/Users");
        
		
	}
	
	//checking the 200 response if the user gets added and check the json returned
			@Test
			public void T01_StatusCodeTest() {
				int statusCode = response.getStatusCode(); //getting the response code
		        System.out.println("Status code for post:" +statusCode);
		        String json = response.asString(); //printing the json returned after adding the new user after converting it to a string
				System.out.println("Json results: " +json);
			}

}
