import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Test5_GET_validateJSONresponse {

	
	@Test
	public void getWeatherDetails() {

		// specify base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		// request object
		RequestSpecification httpRequest = RestAssured.given();

		// response object
		Response response = httpRequest.request(Method.GET, "/Delhi");

		// print response in console window
		String responseBody = response.getBody().asString();
		System.out.println("Response body is: " + responseBody);
		
		JsonPath jsonPath = response.jsonPath();
		String city = jsonPath.get("City");
		String temp = jsonPath.get("Temperature");
		String humidity = jsonPath.get("Humidity");
		String weatherDesc = jsonPath.get("WeatherDescription");
		String windSpeed = jsonPath.get("WindSpeed");
		String windDirectionDegree = jsonPath.get("WindDirectionDegree");
		
		System.out.println(city + ", " + temp + ", " + humidity);
		System.out.println(weatherDesc + ", " + windSpeed + ", " + windDirectionDegree);
		
		// Validation on data received from response. 
		Assert.assertEquals(responseBody.contains("Delhi"), true);
		
	}

}
