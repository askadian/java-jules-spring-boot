package com.library.service;

import com.library.model.Book;

import java.util.Optional;

public interface BookService {
    Book saveBook(Book book);
    Optional<Book> getBookById(Long id);
    void deleteBook(Long id);
}
