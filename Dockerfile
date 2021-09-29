FROM maven:3.5-jdk-8

COPY ./RestAssuredAPITesting/pom.xml pom.xml

RUN mvn dependency:go-offline -B

COPY ./RestAssuredAPITesting ./script

WORKDIR /script

RUN mvn clean install -DskipTests=true

CMD ["java", "-jar", "target/docker-service-1.0-SNAPSHOT-jar-with-dependencies.jar"]
