# Book Service

This is a Spring Boot RESTful microservice for managing a library's book collection. It provides endpoints to create, retrieve, update, and delete books and authors.

## Architecture

The application follows a three-layer architecture:

- **Presentation Layer:** Exposes the RESTful endpoints using Spring Web MVC.
- **Service Layer:** Contains the business logic for managing books and authors.
- **Data Access Layer:** Handles database operations using Spring Data JPA.

## Endpoints

### Book Endpoints

| Method | Path         | Description              |
|--------|--------------|--------------------------|
| `GET`    | `/book/{id}` | Retrieves a book by its ID. |
| `POST`   | `/book`      | Creates a new book.      |
| `PATCH`  | `/book/{id}` | Updates an existing book.|
| `DELETE` | `/book/{id}` | Deletes a book by its ID.  |
| `POST`   | `/book/{bookId}/author/{authorId}` | Associates an author with a book. |

### Author Endpoints

| Method | Path         | Description              |
|--------|--------------|--------------------------|
| `GET`    | `/author/{id}` | Retrieves an author by their ID. |
| `POST`   | `/author`      | Creates a new author.      |
| `DELETE` | `/author/{id}` | Deletes an author by their ID.  |

## How to Run

1. **Clone the repository.**
2. **Set up the database:**
   - Make sure you have a MySQL database running.
   - Create a database named `library`.
   - Update the database credentials in `src/main/resources/application.properties`.
3. **Run the application:**
   ```bash
   mvn spring-boot:run
   ```

The application will be available at `http://localhost:8080`.
