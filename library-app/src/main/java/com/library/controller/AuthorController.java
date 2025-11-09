package com.library.controller;

import com.library.model.Author;
import com.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        Author savedAuthor = authorService.saveAuthor(author);
        return new ResponseEntity<>(savedAuthor, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors() {
        List<Author> authors = authorService.getAllAuthors();
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id) {
        Optional<Author> author = authorService.getAuthorById(id);
        return author.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @RequestBody Author authorDetails) {
        Optional<Author> optionalAuthor = authorService.getAuthorById(id);
        if (optionalAuthor.isPresent()) {
            Author existingAuthor = optionalAuthor.get();
            if (authorDetails.getFirstName() != null) {
                existingAuthor.setFirstName(authorDetails.getFirstName());
            }
            if (authorDetails.getMiddleName() != null) {
                existingAuthor.setMiddleName(authorDetails.getMiddleName());
            }
            if (authorDetails.getLastName() != null) {
                existingAuthor.setLastName(authorDetails.getLastName());
            }
            if (authorDetails.getAddressLine1() != null) {
                existingAuthor.setAddressLine1(authorDetails.getAddressLine1());
            }
            if (authorDetails.getAddressLine2() != null) {
                existingAuthor.setAddressLine2(authorDetails.getAddressLine2());
            }
            if (authorDetails.getCity() != null) {
                existingAuthor.setCity(authorDetails.getCity());
            }
            if (authorDetails.getState() != null) {
                existingAuthor.setState(authorDetails.getState());
            }
            if (authorDetails.getZip() != null) {
                existingAuthor.setZip(authorDetails.getZip());
            }
            if (authorDetails.getCountry() != null) {
                existingAuthor.setCountry(authorDetails.getCountry());
            }
            if (authorDetails.getBooks() != null) {
                existingAuthor.setBooks(authorDetails.getBooks());
            }
            Author updatedAuthor = authorService.saveAuthor(existingAuthor);
            return new ResponseEntity<>(updatedAuthor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
