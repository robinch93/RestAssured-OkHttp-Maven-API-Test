package restAssuredBDDtest;

import javax.annotation.meta.When;

import org.junit.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class BDD_Test4_DELETE_request {

	public static HashMap map = new HashMap();

	int emp_id = 11501;
	
	@Test
	public void putData() {
		
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath = "/delete/" + emp_id;
		
		Response response = 
		
		given()
			
		.when()
		
			.delete()
			
		.then()
		
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.log().all()
			.extract().response();
		
		String jsonAsString = response.asString();
		Assert.assertEquals(jsonAsString.contains("successfully! deleted Records"), true);
	
	}
}
