import org.json.simple.JSONObject;
import org.omg.PortableInterceptor.SUCCESSFUL;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Test2_POST_Request {

	@Test
	void registration() {

		// specify base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";

		// request object
		RequestSpecification httpRequest = RestAssured.given();

		// request payload sending along with POST request.
		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "John");
		requestParams.put("LastName", "Hena");
		requestParams.put("UserName", "JohnHena");
		requestParams.put("Password", "JohnHena");
		requestParams.put("Email", "jognhena@gmail.com");
		
		httpRequest.header("Contect-Type", "application/json");
		
		// attach above data to the request.
		httpRequest.body(requestParams.toJSONString());
		
		Response response = httpRequest.request(Method.POST,"/register");
	
		// print response in console window
		String responseBody = response.getBody().asString();
		System.out.println("Response body is: " + responseBody);

		// status code validation
		int statusCode = response.getStatusCode();
		System.out.println("Status code is: " + +statusCode);
		Assert.assertEquals(statusCode, 201);
		
		// success code validation
		String successCode = response.jsonPath().get("SuccessCode");
		Assert.assertEquals(successCode, "OPERATION_SUCCESS");

	}

}
