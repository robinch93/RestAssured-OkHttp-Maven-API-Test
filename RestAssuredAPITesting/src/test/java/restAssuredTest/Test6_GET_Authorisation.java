package restAssuredTest;
import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Test6_GET_Authorisation {

	@Test
	public void authorizationTest() {

		// specify base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";

		// Basic Authentication
		PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
		auth.setUserName("ToolsQA");
		auth.setPassword("TestPassword");
		RestAssured.authentication = auth;
		
		// request object
		RequestSpecification httpRequest = RestAssured.given();

		// response object
		Response response = httpRequest.request(Method.GET, "/");

		// print response body in console window
		String responseBody = response.getBody().asString();
		System.out.println("Response body is: " + responseBody);

		// status code validation
		int statusCode = response.getStatusCode();
		System.out.println("Status code is: " + +statusCode);
		Assert.assertEquals(statusCode, 200);


	}

}
