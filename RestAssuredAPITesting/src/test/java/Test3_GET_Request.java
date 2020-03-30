import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Test3_GET_Request {

	@Test
	void getWeatherStatus() {

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

		// validation headers
		String contentType = response.header("Content-Typer");
		System.out.println("Content Type is : " + contentType);
		Assert.assertEquals(contentType, "application/xml; charset=UTF-8");

		String contentEncoding = response.header("Content-Typer");
		System.out.println("Content Encoding is : " + contentEncoding);
		Assert.assertEquals(contentEncoding, "gzip");

	}

}
