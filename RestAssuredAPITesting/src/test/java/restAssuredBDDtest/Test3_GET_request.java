package restAssuredBDDtest;

import javax.annotation.meta.When;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Test3_GET_request {
		
	@Test(groups = "rest-assured")
	public void getWeatherDetails() {
		given()
		 .when()
		 .get("https://fcc-weather-api.glitch.me/api/current?lat=48&lon=11")
		 .then()
		 .statusCode(200)
		 .assertThat().body("coord.lon", equalTo(11))
		 .assertThat().body("coord.lat", equalTo(48))
		 .assertThat().body("name", equalTo("Upper Bavaria"))
		 .header("Content-Type", "application/json; charset=utf-8");
	}
}
