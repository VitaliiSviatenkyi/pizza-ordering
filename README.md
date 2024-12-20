# pizza-ordering

This project implements a pizza ordering system, allowing the creation, updating, and deletion of customers and orders.
It is built with Spring Boot and uses an H2 database for data storage.

## Required software

Make sure you know and are able to access installed/extracted software.

- java JDK, [version 17.0.13](https://www.oracle.com/java/technologies/downloads/#java17)
- maven, [version 3.9.8](https://archive.apache.org/dist/maven/maven-3/3.9.8/binaries/)
- git

## Installation & Running

1. Clone the repository:

    - `git clone https://github.com/VitaliiSviatenkyi/pizza-ordering.git`
    - `cd pizza-ordering`

2. Build the project:

    - `mvn clean install`

3. Run the application:

    - `java -jar target/pizza-ordering-0.0.1.jar`

4. Open swagger via link: http://localhost:8080/swagger-ui/index.html

## Swagger UI

Swagger UI allows you to view and interact with the API of your service. You can use it to test available REST API
endpoints.

Open Swagger UI by navigating to the following link:

[Swagger UI](http://localhost:8080/swagger-ui/index.html)

**Note**: By default, the service runs on port `8080`. If you have changed the port configuration, adjust the URL
accordingly.

## H2 Console

The H2 Console allows you to interact with the database via a web interface. It is useful for checking data in the
database or executing SQL queries.

Open H2 Console by navigating to the following link:

[H2 Console](http://localhost:8080/h2)

**Connection settings for H2 Console:**

- **JDBC URL**: `jdbc:h2:mem:memDb`
- **Username**: `sa`
- **Password**: (leave empty)


