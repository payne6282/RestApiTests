package com.RESTapiTests.RestApiTests;

import static org.junit.Assert.assertEquals;

import java.util.List;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

public class HelperMethods {

	//Verify the http response status returned. Check Status Code is 200.
	public static void checkStatus200(Response res) {
		assertEquals("Status Check Failed!", 200, res.getStatusCode());
	}

	//Check wrong value response. Example - Wrong path sent
	public static void checkStatus404(Response res, JsonPath jp) {
		//404 should be expected for not found
		assertEquals("Expected wrong params", 404, res.getStatusCode());
	}

	//400 not found check
	public static void checkStatus400(Response res, JsonPath jp) {
		//400 should be expected for not found
		assertEquals("Expected wrong params", 400, res.getStatusCode());
	}

	//Checking the correctness of the title for the first book returned
	public static void checkCorrectTitle(JsonPath jp) {
		List<String> title = jp.get("Title"); //Adding the Title in a list
		String TitleCheck = title.get(0); //
		assertEquals("The title is not correct", "Book 1", TitleCheck); //asserting the title = Book 1 for the first book returned
	}

	//checking whether the book returned from a particular id has the correct page count
	public static void checkPageCountForParticularID(JsonPath jp) {
		int pageCount = jp.get("PageCount"); //Adding the page count to a string
		assertEquals("The page count is incorrect for that particular id", 1000, pageCount); //asserting the page count for the id
	}



}
