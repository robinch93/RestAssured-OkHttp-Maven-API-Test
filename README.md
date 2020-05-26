# RestAssured-Testng-Maven-API-Test
This project is an example of API testing with support of testng and maven.  

**Prerequisite** 
- Maven 
- Eclipse
- TestNG
- API documentation

Different API's are tested for different condition as mentioned in the excel sheet:

- Rest API Test : Here, different Rest API's are tested for various validations, like, status line, status code, to print headers, to validate JSON response, etc with GET and POST methods. 

>> [RestAssuredAPITesting/src/test/java/restAssuredTest](https://github.com/robinch93/RestAssured-Testng-Maven-API-Test/tree/master/RestAssuredAPITesting/src/test/java/restAssuredTest)

- Data Driven Test : This test case make use of data provider annotation to extract data form an excel data sheet and create employee data for all the employees 
given in the excel sheet.  

>> [RestAssuredAPITesting/src/test/java/dataDrivenTest](https://github.com/robinch93/RestAssured-Testng-Maven-API-Test/tree/master/RestAssuredAPITesting/src/test/java/dataDrivenTest)

- API BDD Test : These test cases are writeen in BDD(Business Driven Developement) approach for testing API's.  

>> [RestAssuredAPITesting/src/test/java/restAssuredBDDtest](https://github.com/robinch93/RestAssured-Testng-Maven-API-Test/tree/master/RestAssuredAPITesting/src/test/java/restAssuredBDDtest)

- Maven POM.xml : Dependencies like Apache poi, Testng, Rest Assured, JSON simple, Hamcrest are included in the project using pom xml file. 

>> [RestAssuredAPITesting/pom.xml](https://github.com/robinch93/RestAssured-Testng-Maven-API-Test/RestAssuredAPITesting/pom.xml)










