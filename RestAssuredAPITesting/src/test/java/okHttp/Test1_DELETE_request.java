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
import java.util.concurrent.TimeUnit;

public class Test1_DELETE_request {

	private static final String URL = System.getProperty("baseUrl");
	
	@Test(groups = "okhttp")
	void getWeatherStatus() throws Exception{

		final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
		final OkHttpClient client = new OkHttpClient();

        final Request requestDelete = new Request.Builder().url(URL + "/employees")
            .delete()
            .build();

        final Response responseDelete = client.newCall(requestDelete).execute();

		final int statusCode = responseDelete.code();
		assertEquals(statusCode, 204);

		TimeUnit.SECONDS.sleep(3);
		final Request requestGet = new Request.Builder().url(URL + "/employees")
		.get()
		.build();
		final Response responseGet = client.newCall(requestGet).execute();
        final String responseBody = responseGet.body().string();
		
		Assert.assertEquals(JsonPath.read(responseBody, "$.count"), 0);
		Assert.assertEquals(JsonPath.read(responseBody, "$.employee.length()"), 0);
	}
}
