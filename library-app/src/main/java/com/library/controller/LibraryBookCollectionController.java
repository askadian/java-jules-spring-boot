package com.library.controller;

import com.library.model.LibraryBookCollection;
import com.library.model.LibraryBookCollectionId;
import com.library.service.LibraryBookCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/library-book-collection")
public class LibraryBookCollectionController {

    @Autowired
    private LibraryBookCollectionService libraryBookCollectionService;

    @PostMapping
    public ResponseEntity<LibraryBookCollection> createLibraryBookCollection(@RequestBody LibraryBookCollection libraryBookCollection) {
        LibraryBookCollection savedLibraryBookCollection = libraryBookCollectionService.saveLibraryBookCollection(libraryBookCollection);
        return new ResponseEntity<>(savedLibraryBookCollection, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<LibraryBookCollection>> getAllLibraryBookCollections() {
        List<LibraryBookCollection> libraryBookCollections = libraryBookCollectionService.getAllLibraryBookCollections();
        return new ResponseEntity<>(libraryBookCollections, HttpStatus.OK);
    }

    @GetMapping("/{libraryId}/{bookId}")
    public ResponseEntity<LibraryBookCollection> getLibraryBookCollectionById(@PathVariable Long libraryId, @PathVariable Long bookId) {
        LibraryBookCollectionId id = new LibraryBookCollectionId(libraryId, bookId);
        Optional<LibraryBookCollection> libraryBookCollection = libraryBookCollectionService.getLibraryBookCollectionById(id);
        return libraryBookCollection.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{libraryId}/{bookId}")
    public ResponseEntity<Void> deleteLibraryBookCollection(@PathVariable Long libraryId, @PathVariable Long bookId) {
        LibraryBookCollectionId id = new LibraryBookCollectionId(libraryId, bookId);
        libraryBookCollectionService.deleteLibraryBookCollection(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
