package restAssuredBDDtest;

import javax.annotation.meta.When;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class BDD_Test1_GET_request {
		
	@Test
	public void getWeatherDetails() {
		given()
		 .when()
		 .get("http://restapi.demoqa.com/utilities/weather/city/Noida")
		 .then()
		 .statusCode(200)
		 .statusLine("HTTP/1.1 200 OK")
		 .assertThat().body("City", equalTo("Noida"))
		 .header("Content-Type", "application/json");
		
	}
}
