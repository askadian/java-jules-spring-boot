# Library App

This is a Spring Boot RESTful microservice for managing a library. It provides endpoints to manage books, authors, users, library branches, and orders.

## Architecture

The application follows a three-layer architecture:

- **Presentation Layer:** Exposes the RESTful endpoints using Spring Web MVC.
- **Service Layer:** Contains the business logic.
- **Data Access Layer:** Handles database operations using Spring Data JPA.

## Database Schema

The database schema is defined in the `mysql/database-definitions.sql` file.

## API Endpoints

The following endpoints are available:

### Book

- `GET /book`
- `GET /book/{id}`
- `POST /book`
- `PATCH /book/{id}`
- `DELETE /book/{id}`

### Author

- `GET /author`
- `GET /author/{id}`
- `POST /author`
- `PATCH /author/{id}`
- `DELETE /author/{id}`

### User

- `GET /user`
- `GET /user/{id}`
- `POST /user`
- `PATCH /user/{id}`
- `DELETE /user/{id}`

### Library

- `GET /library`
- `GET /library/{id}`
- `POST /library`
- `PATCH /library/{id}`
- `DELETE /library/{id}`

### Order

- `GET /order`
- `GET /order/{id}`
- `POST /order`
- `PATCH /order/{id}`
- `DELETE /order/{id}`

### Metadata (Order Status Types)

- `GET /metadata`
- `GET /metadata/{name}`
- `POST /metadata`
- `PATCH /metadata/{name}`
- `DELETE /metadata/{name}`

## How to Run

1.  **Clone the repository.**
2.  **Set up the database:**
    *   Make sure you have a MySQL database running.
    *   Create a database named `library`.
    *   Run the `mysql/database-definitions.sql` and `mysql/sample-data.sql` scripts.
    *   Copy the `library-app/src/main/resources/application.properties.template` file to `library-app/src/main/resources/application.properties`.
    *   Update the database credentials in `library-app/src/main/resources/application.properties`.
3.  **Run the application:**

    ```bash
    mvn spring-boot:run -f library-app/pom.xml
    ```

The application will be available at `http://localhost:8080`.
