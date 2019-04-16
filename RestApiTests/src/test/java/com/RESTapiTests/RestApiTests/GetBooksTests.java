package com.RESTapiTests.RestApiTests;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;


public class GetBooksTests {

	private static Response res = null; //Response object
	private static JsonPath jp = null; //JsonPath object

	//Setup operations
	@Before
	public void setup() {

		RestUtils.setBaseURI(URLConstants.BASE_URL); //Setup Base URI
		RestUtils.setBasePath(URLConstants.BASE_PATH_BOOKS); //Setup Base Path
		RestUtils.setContentType(ContentType.JSON); //Setup Content Type
		RestUtils.createSearchQueryPathBooksAPI("Books"); //Construct the path
		responsePathSetUp();
	}

	public static void responsePathSetUp() {
		res = RestUtils.getResponse(); //Get response
		jp = RestUtils.getJsonPath(res); //Get JsonPath
	}

	
	//checking the 200 response with all correct parameters
		@Test
		public void T01_StatusCodeTest() {
			HelperMethods.checkStatus200(res);
		}
	
	//Checking 404 status if an incorrect path is sent. Example - Book22 instead of Books	
		@Test
		public void T02_StatusCodeCheckNotFound() {
			RestUtils.createSearchQueryPathBooksAPI("Books22");//Wrong api path passed
			responsePathSetUp();
			HelperMethods.checkStatus404(res, jp);
		}
		
	//Checking the correctness of the data by validating if the first book title returned is as expected	
		@Test
		public void T03_checkTitle() {
			HelperMethods.checkCorrectTitle(jp);
		}
		
		@After
		public void afterTest (){
			//Reset Values
			RestUtils.resetBaseURI();
			RestUtils.resetBasePath();
		}
	
}
