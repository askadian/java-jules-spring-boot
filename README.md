# Library Database

This repository contains the SQL scripts for creating and populating a library database.

## Database Schema

The database schema is defined in the `mysql/database-definitions.sql` file. It includes the following tables:

- `book`
- `author`
- `author_book_relationship`
- `library`
- `library_book_collection`
- `user`
- `order_status_type`
- `book_order`

## Sample Data

The `mysql/sample-data.sql` file contains `INSERT` statements to populate the tables with sample data.

## How to Use

1. **Clone the repository.**
2. **Set up the database:**
   - Make sure you have a MySQL database running.
   - Create a database named `library`.
   - Run the `mysql/database-definitions.sql` file to create the tables.
   - Run the `mysql/sample-data.sql` file to populate the tables with sample data.
