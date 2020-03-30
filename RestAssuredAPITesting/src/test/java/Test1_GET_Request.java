import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Test1_GET_Request {

	@Test
	void getWeatherStatus() {

		// specify base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		// request object
		RequestSpecification httpRequest = RestAssured.given();
		
		// response object
		Response response = httpRequest.request(Method.GET, "/Delhi");

		// print response in console window
		String responseBody = response.getBody().asString();
		System.out.println("Response body is: " + responseBody);

		// status code validation
		int statusCode = response.getStatusCode();
		System.out.println("Status code is: " + +statusCode);
		Assert.assertEquals(statusCode, 200);

		// status line validation
		String statusLine = response.getStatusLine();
		System.out.println("Status line is: " + statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

	}

}
