package restAssuredBDDtest;

import javax.annotation.meta.When;
import org.junit.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;

public class Test1_DELETE_request {

	public static HashMap map = new HashMap();
	
	@Test(groups = "rest-assured")
	public void testPut() {
		given()
		.contentType("application/json")
		.when()
		.delete(System.getProperty("baseUrl") + "/employees")
		.then()
		.statusCode(204);
	}
}
