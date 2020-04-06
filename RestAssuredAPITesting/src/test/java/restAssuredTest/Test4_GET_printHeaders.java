package restAssuredTest;
import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Test4_GET_printHeaders {

	// printing all headers
	@Test
	void getWeatherDetails() {

		// specify base URI
		RestAssured.baseURI = "https://maps.googleapis.com";

		// request object
		RequestSpecification httpRequest = RestAssured.given();

		// response object
		Response response = httpRequest.request(Method.GET,
				"/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");

		// print response in console window
		String responseBody = response.getBody().asString();
		System.out.println("Response body is: " + responseBody);

		// capture all headers returned from response.
		Headers allHeaders = response.headers();
		
		for(Header header: allHeaders) {
			System.out.println(header.getName() + "  :  " + header.getValue());
		}
		
	}

}
