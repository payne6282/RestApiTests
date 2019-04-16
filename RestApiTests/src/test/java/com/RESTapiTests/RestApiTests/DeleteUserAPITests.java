package com.RESTapiTests.RestApiTests;

import org.junit.Before;
import org.junit.Test;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class DeleteUserAPITests {

	Response response;

	//Setup operations
	@Before
	public void setup() {
		
		RestAssured.baseURI = URLConstants.BASE_URL; //Setup Base URI
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.header("Content-Type", "application/json");

        //do the delete request for user id = 3
        response = httpRequest.delete("/api/Users/3");
        
		
	}
	
	//checking the 200 response if the user gets deleted and a 200 response is returned
			@Test
			public void T01_StatusCodeTest() {
				HelperMethods.checkStatus200(response);
			}
			
			

}
