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

public class Test3_GET_request {

	private static final String URL = System.getProperty("baseUrl");
	
	@Test(groups = "okhttp")
	void getWeatherStatus() throws Exception{

		final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
		final OkHttpClient client = new OkHttpClient();

        final Request request = new Request.Builder().url(URL + "/employees")
            .get()
            .build();

        final Response response = client.newCall(request).execute();

		final int statusCode = response.code();
		assertEquals(statusCode, 200);

        final String responseBody = response.body().string();
		int count = JsonPath.read(responseBody, "$.employee.length()");
		Assert.assertEquals(JsonPath.read(responseBody, "$.count"), count);
	}
}
