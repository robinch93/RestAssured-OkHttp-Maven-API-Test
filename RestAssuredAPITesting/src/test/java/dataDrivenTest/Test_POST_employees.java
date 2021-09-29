package dataDrivenTest;

import org.json.*;
import org.testng.Assert;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import java.util.HashMap;
import java.io.IOException;
import com.jayway.jsonpath.JsonPath;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import static org.testng.Assert.assertEquals;
import java.util.concurrent.TimeUnit;

public class Test_POST_employees {

	private static final String URL = System.getProperty("baseUrl");

	@Test(dataProvider = "empdataexcel", groups = "data-driven")
	public void postNewEmployees(String firstname, String lastname, String email, String age, String city) throws Exception {
		
		final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
		final OkHttpClient client = new OkHttpClient();
		
		// create data for post request
		final HashMap postData = new HashMap();
		postData.put("firstname", firstname);
		postData.put("lastname", lastname);
		postData.put("email", email);
		postData.put("age", age);
		postData.put("city", city);
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
	
	@DataProvider(name = "empdataexcel")
	String [][] getEmpExcelData() throws IOException {
		
		// Read data from excel
		String path = System.getProperty("user.dir") + "/src/test/java/dataDrivenTest/EmployeeData.xlsx";
		int rowCount = ExcelUtility.getRowCount(path, "EmpData");
		int colCount = ExcelUtility.getCellCount(path, "EmpData", 1);
		
		String empdata [][] = new String[rowCount][colCount];
		
		for(int i=1; i<= rowCount; i++) {
			for(int j=0; j< colCount; j++) {
				empdata[i-1][j] = ExcelUtility.getCellData(path, "EmpData", i, j);
			}
		}
	
		return(empdata);
	}
	
	@DataProvider(name = "empdatadirect")
	String [][] getEmpData(){
		String empdata [][] = { {"jack3","200","20"}};
		return(empdata);
	}

	@AfterClass(groups = "data-driven")
	public void deleteAll() throws Exception{
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
