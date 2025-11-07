package com.library.controller;

import com.library.model.Author;
import com.library.model.Book;
import com.library.service.AuthorService;
import com.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book savedBook = bookService.saveBook(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Optional<Book> book = bookService.getBookById(id);
        return book.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        Optional<Book> optionalBook = bookService.getBookById(id);
        if (optionalBook.isPresent()) {
            Book existingBook = optionalBook.get();
            if (bookDetails.getTitle() != null) {
                existingBook.setTitle(bookDetails.getTitle());
            }
            if (bookDetails.getIsbn() != null) {
                existingBook.setIsbn(bookDetails.getIsbn());
            }
            if (bookDetails.getPublishedDate() != null) {
                existingBook.setPublishedDate(bookDetails.getPublishedDate());
            }
            Book updatedBook = bookService.saveBook(existingBook);
            return new ResponseEntity<>(updatedBook, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{bookId}/author/{authorId}")
    public ResponseEntity<Book> addAuthorToBook(@PathVariable Long bookId, @PathVariable Long authorId) {
        Optional<Book> optionalBook = bookService.getBookById(bookId);
        Optional<Author> optionalAuthor = authorService.getAuthorById(authorId);

        if (optionalBook.isPresent() && optionalAuthor.isPresent()) {
            Book book = optionalBook.get();
            Author author = optionalAuthor.get();
            book.getAuthors().add(author);
            author.getBooks().add(book);
            bookService.saveBook(book);
            return new ResponseEntity<>(book, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
