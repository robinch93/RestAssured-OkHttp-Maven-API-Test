package restAssuredBDDtest;

import javax.annotation.meta.When;
import org.testng.annotations.*;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;

public class Test4_PUT_request {

	public static HashMap map = new HashMap();
	public int emp_id = 1;

	@BeforeClass(groups = "rest-assured")
	public void putData() {
		map.put("firstname", RestUtils.getFirstName());
		map.put("lastname", RestUtils.getLastName());
		map.put("age", RestUtils.getEmpAge());
		map.put("city", RestUtils.getEmpCity());
		}

	@Test(groups = "rest-assured")
	public void testPut() {
		given()
		.contentType("application/json")
		.with().body(map)	
		.when()
		.put(System.getProperty("baseUrl") + "/employee/" + emp_id)	
		.then()
		.statusCode(201)	
		.body("status", equalTo("Employee with id " + emp_id + " record successfully updated."));	
	}
}
