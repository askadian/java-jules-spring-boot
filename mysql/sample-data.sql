-- Sample data for the library database

-- Insert Books
INSERT INTO book (title, isbn, published_date, last_updated_by) VALUES ('To Kill a Mockingbird', '978-0-06-112008-4', '1960-07-11', 'admin');
INSERT INTO book (title, isbn, published_date, last_updated_by) VALUES ('1984', '978-0-452-28423-4', '1949-06-08', 'admin');
INSERT INTO book (title, isbn, published_date, last_updated_by) VALUES ('The Great Gatsby', '978-0-7432-7356-5', '1925-04-10', 'admin');

-- Insert Authors
INSERT INTO author (first_name, last_name, last_updated_by) VALUES ('Harper', 'Lee', 'admin');
INSERT INTO author (first_name, last_name, last_updated_by) VALUES ('George', 'Orwell', 'admin');
INSERT INTO author (first_name, last_name, last_updated_by) VALUES ('F. Scott', 'Fitzgerald', 'admin');

-- Insert Author-Book Relationships
INSERT INTO author_book_relationship (book_id, author_id, last_updated_by) VALUES (1, 1, 'admin');
INSERT INTO author_book_relationship (book_id, author_id, last_updated_by) VALUES (2, 2, 'admin');
INSERT INTO author_book_relationship (book_id, author_id, last_updated_by) VALUES (3, 3, 'admin');

-- Insert Libraries
INSERT INTO library_branch (library_name, address_line1, city, state, zip, country, last_updated_by) VALUES ('Main Library', '123 Main St', 'Anytown', 'CA', '12345', 'USA', 'admin');

-- Insert Library Book Collections
INSERT INTO library_book_collection (library_branch_id, book_id, seq_number, last_updated_by) VALUES (1, 1, 1, 'admin');
INSERT INTO library_book_collection (library_branch_id, book_id, seq_number, last_updated_by) VALUES (1, 2, 2, 'admin');
INSERT INTO library_book_collection (library_branch_id, book_id, seq_number, last_updated_by) VALUES (1, 3, 3, 'admin');

-- Insert Users
INSERT INTO user (first_name, last_name, address_line1, city, state, zip, country) VALUES ('John', 'Doe', '456 Oak Ave', 'Anytown', 'CA', '12345', 'USA');

-- Insert Order Status Types
INSERT INTO order_status_type (name, description, last_updated_by) VALUES ('PENDING', 'The order has been placed but not yet fulfilled.', 'admin');
INSERT INTO order_status_type (name, description, last_updated_by) VALUES ('FULFILLED', 'The order has been fulfilled.', 'admin');
INSERT INTO order_status_type (name, description, last_updated_by) VALUES ('CANCELLED', 'The order has been cancelled.', 'admin');

-- Insert Book Orders
INSERT INTO book_order (book_id, user_id, order_datetime, status, last_updated_by) VALUES (1, 1, '2025-11-08 12:00:00', 'PENDING', 'admin');
