# RestAssured-OkHttp-API-Test

This project is an example of REST API testing with rest-assured and okhttp rest clients with the support of testng and maven.

**Prerequisite**

- [Docker](https://docs.docker.com/get-docker/)
- Run the rest api server on localhost, by runnning following command.</br>
  `git clone https://github.com/robinch93/rest-api.git && cd rest-api && docker-compose up -d`

**Setup** </br>

- `git clone https://github.com/robinch93/RestAssured-Testng-Maven-API-Test.git`
- `docker-compose up -d`

**Run with Docker** </br>
There are three groups:

- Data Driven Test : This test reads employee data form an excel data sheet and create all employees while validating the responses.</br>
  `docker-compose exec test mvn surefire:test -Dgroups=data-driven`

- OkHttp Test : These tests make use of okhttp rest client to perform crud operations and doing validations.</br>
  `docker-compose exec test mvn surefire:test -Dgroups=okhttp`

- Rest-Assured Test : These tests make api requests using rest-assured and do validations. </br>
  `docker-compose exec test mvn surefire:test -Dgroups=rest-assured`

**Run On Jenkins** </br>

- Access Jenkins instance at: `http://localhost:8085`
- Use `admin` as username and `admin` as password for login.
- Click on the job `rest-api-test`
- Click on `Build Now` button to trigger the job build.
