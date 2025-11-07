package com.library.service;

import com.library.model.Author;

import java.util.Optional;

public interface AuthorService {
    Author saveAuthor(Author author);
    Optional<Author> getAuthorById(Long id);
    void deleteAuthor(Long id);
}
