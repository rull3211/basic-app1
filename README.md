### About the web application

The files in this project is a Java web application that is build with Maven.

- Java 11
- Maven
- Spring Boot
- JUnit
- H2 inMemory database
    - with Crud Repositories
    
- Spring uses frontend-maven-plugin to build and embed the frontend into the springapp
### Initial setup

Install Maven (can be downloaded from <http://maven.apache.org/download.html>).

From the project folder where `pom.xml` is located, you run `mvn spring-boot:run`.
This takes a while the first time, since all dependencies are being downloaded.

Point your browser to <http://localhost:8080/>.

