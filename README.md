# Book Service

This is a Spring Boot RESTful microservice for managing a library's book collection. It provides endpoints to create, retrieve, update, and delete books.

## Architecture

The application follows a three-layer architecture:

- **Presentation Layer:** Exposes the RESTful endpoints using Spring Web MVC.
- **Service Layer:** Contains the business logic for managing books.
- **Data Access Layer:** Handles database operations using Spring Data JPA.

## Database Schema

The database schema is defined in the `mysql/books.sql` file. It includes the following tables:

- `book`
- `author`
- `author_book_relationship`
- `library`
- `library_book_collection`
- `user`
- `order_status_type`
- `book_order`

## Endpoints

The following endpoints are available:

| Method | Path         | Description              |
|--------|--------------|--------------------------|
| `GET`    | `/book/{id}` | Retrieves a book by its ID. |
| `POST`   | `/book`      | Creates a new book.      |
| `PATCH`  | `/book/{id}` | Updates an existing book.|
| `DELETE` | `/book/{id}` | Deletes a book by its ID.  |

## How to Run

1. **Clone the repository.**
2. **Set up the database:**
   - Make sure you have a MySQL database running.
   - Create a database named `library`.
   - The `mysql/books.sql` file contains the DDL for all the tables.
   - Create a file at `src/main/resources/application.properties` with your database credentials. You can use the following template:
     ```
     spring.datasource.url=jdbc:mysql://localhost:3306/library
     spring.datasource.username=YOUR_DB_USERNAME
     spring.datasource.password=YOUR_DB_PASSWORD
     spring.jpa.hibernate.ddl-auto=update
     ```
     Replace `YOUR_DB_USERNAME` and `YOUR_DB_PASSWORD` with your actual MySQL credentials.
3. **Run the application:**
   ```bash
   mvn spring-boot:run
   ```

The application will be available at `http://localhost:8080`.
