package dataDrivenTest;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataDrivenTest_AddEmployees {

	@Test(dataProvider = "empdataexcel")
	public void postNewEmployees(String ename, String esalary, String eage) {
		
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		// here we created data to send with the post request. 
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", ename);
		requestParams.put("salary", esalary);
		requestParams.put("age", eage);
		
		// added a header saying the data type is json
		httpRequest.header("Content-Type","application/json");
		
		// add json to the body of request. 
		httpRequest.body(requestParams.toJSONString());
		
		// send POST request
		Response response = httpRequest.request(Method.POST,"/create");
		
		// capture response body to perform validations
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is: " + responseBody);
		Assert.assertEquals(responseBody.contains(ename), true);
		Assert.assertEquals(responseBody.contains(esalary), true);
		Assert.assertEquals(responseBody.contains(eage), true);
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
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
	
		return (empdata);
	}
	
	@DataProvider (name = "empdatadirect")
	String [][] getEmpData(){
		String empdata [][] = { {"jack3","200","20"}};
		return (empdata);
	}
}
