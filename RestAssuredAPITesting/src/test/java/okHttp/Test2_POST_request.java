package okHttp;

import org.json.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import java.util.HashMap;
import static org.testng.Assert.assertEquals;

public class Test2_POST_request {

	private static final String URL = System.getProperty("baseUrl");

	@Test(groups = "okhttp")
	void registration() throws Exception {

		final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
		final OkHttpClient client = new OkHttpClient();
		
		// create data for post request
		final HashMap postData = new HashMap();
		postData.put("firstname", "test");
		postData.put("lastname", "user");
		postData.put("email", "test.user@gmail.com");
		postData.put("age", 25);
		postData.put("city", "Zurich");
		final JSONObject json = new JSONObject(postData);
        final RequestBody requestBody = RequestBody.create(json.toString(), JSON);

        final Request request = new Request.Builder().url(URL + "/employee/create")
            .addHeader("Content-Type", "application/json;charset=utf-8")
            .post(requestBody)
            .build();

        final Response response = client.newCall(request).execute();

        final int statusCode = response.code();
        final String responseBody = response.body().string();
		System.out.println("resp body is: " + responseBody);

        final JSONObject jsonResponse = new JSONObject(responseBody);
		assertEquals(statusCode, 200);
		final String successMessage = "Employee record successfully created.";
		Assert.assertEquals(jsonResponse.getString("status"), successMessage);
	}

}
