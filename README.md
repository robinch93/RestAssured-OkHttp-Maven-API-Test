# RestAssured-Testng-Maven-API-Test
This project is an example of API testing with support of testng and maven.  

**Prerequisite** 
- Maven 
- Eclipse
- TestNG
- API documentation

Different API are tested for different condition as mentioned in the excel sheet:

- Rest API Test : Here, different Rest API's are tested for various validations, like, status line, status code, to print headers, to validate JSON response, 
etc with GET and POST methods. 

[RestAssuredAPITesting/src/test/java/](https://github.com/robinch93/RestAssured-Testng-Maven-API-Test/RestAssuredAPITesting/src/test/java)

- Data Driven Test : This test case make use of data provider annotation to extract data form an excel data sheet and create employee data for all the employees 
given in the excel sheet.  

[dataDrivenTest/DataDrivenTest_AddEmployees.java](https://github.com/robinch93/RestAssured-Testng-Maven-API-Test/RestAssuredAPITesting/src/test/java/dataDrivenTest/DataDrivenTest_AddEmployees.java)

An excel utility class is created with mehtods to extract the data from an excel sheet, which uses apache poi library dependency given in maven pom file. 

[dataDrivenTest/Excel_Utility.java](https://github.com/robinch93/RestAssured-Testng-Maven-API-Test/RestAssuredAPITesting/src/test/java/dataDrivenTest/Excel_Utility.java)

- Maven POM.xml : Dependencies like Apache poi, Testng, Rest Assured, JSON simple are included in the project using pom xml file. 

[RestAssuredAPITesting/pom.xml](https://github.com/robinch93/RestAssured-Testng-Maven-API-Test/RestAssuredAPITesting/pom.xml)










