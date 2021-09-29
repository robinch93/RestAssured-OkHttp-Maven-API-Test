package okHttp;

import org.json.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import static org.testng.Assert.assertEquals;
import com.jayway.jsonpath.JsonPath;

public class Test4_GET_request {

	private static final String URL = "https://fcc-weather-api.glitch.me/api";

	@Test(groups = "okhttp")
	void getWeatherStatus() throws Exception {

		final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
		final OkHttpClient client = new OkHttpClient();

        final Request request = new Request.Builder().url(URL + "/current?lat=48&lon=11")
            .get()
            .build();

        final Response response = client.newCall(request).execute();

		final int statusCode = response.code();
		assertEquals(statusCode, 200);
		
		// validate response body
        final String responseBody = response.body().string();
		Assert.assertEquals(JsonPath.read(responseBody, "$.coord.lon"), 11);
		Assert.assertEquals(JsonPath.read(responseBody, "$.coord.lat"), 48);
		Assert.assertEquals(JsonPath.read(responseBody, "$.name"), "Upper Bavaria");
	}

}
