package restAssuredBDDtest;

import javax.annotation.meta.When;
import org.testng.annotations.*;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;

public class Test2_POST_request {

	public static HashMap map = new HashMap();

	@BeforeClass(groups = "rest-assured")
	public void postData() {
		map.put("firstname", RestUtils.getFirstName());
		map.put("lastname", RestUtils.getLastName());
		map.put("email", RestUtils.getEmail());
		map.put("age", RestUtils.getEmpAge());
		map.put("city", RestUtils.getEmpCity());
		}

	@Test(groups = "rest-assured")
	public void testPost() {
		given()
		.contentType("application/json")
		.with().body(map)	
		.when()
		.post(System.getProperty("baseUrl") + "/employee/create")	
		.then()
		.statusCode(200)	
		.body("status", equalTo("Employee record successfully created."));	
	}
}
