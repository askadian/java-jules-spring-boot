CREATE TABLE book (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    isbn VARCHAR(255),
    published_date DATE
);
INSERT INTO book (title, author, isbn, published_date) VALUES ('To Kill a Mockingbird', 'Harper Lee', '978-0-06-112008-4', '1960-07-11');
INSERT INTO book (title, author, isbn, published_date) VALUES ('1984', 'George Orwell', '978-0-452-28423-4', '1949-06-08');
INSERT INTO book (title, author, isbn, published_date) VALUES ('The Great Gatsby', 'F. Scott Fitzgerald', '978-0-7432-7356-5', '1925-04-10');

SELECT * FROM book;
