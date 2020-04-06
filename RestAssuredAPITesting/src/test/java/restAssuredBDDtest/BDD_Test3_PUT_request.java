package restAssuredBDDtest;

import javax.annotation.meta.When;

import org.junit.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class BDD_Test3_PUT_request {

	public static HashMap map = new HashMap();

	int emp_id = 11501;
	
	@BeforeClass
	public void putData() {
		map.put("FirstName", RestUtils.getEmpName());
		map.put("LastName", RestUtils.getEmpSal());
		map.put("UserName", RestUtils.getEmpAge());
		
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath = "/update/" + emp_id;
		
		}

	@Test
	public void testPut() {
		given()
			.contentType("application/json")
			.body(map)
			
		.when()
		
			.put()
			
		.then()
		
			.statusCode(200)	
			.log().all();
	
	}
}
