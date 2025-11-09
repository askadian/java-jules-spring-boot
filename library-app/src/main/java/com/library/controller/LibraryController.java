package com.library.controller;

import com.library.model.Library;
import com.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @PostMapping
    public ResponseEntity<Library> createLibrary(@RequestBody Library library) {
        Library savedLibrary = libraryService.saveLibrary(library);
        return new ResponseEntity<>(savedLibrary, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Library>> getAllLibraries() {
        List<Library> libraries = libraryService.getAllLibraries();
        return new ResponseEntity<>(libraries, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Library> getLibraryById(@PathVariable Long id) {
        Optional<Library> library = libraryService.getLibraryById(id);
        return library.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PatchMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<Library> updateLibrary(@PathVariable Long id, @RequestBody Library libraryDetails) {
        Optional<Library> optionalLibrary = libraryService.getLibraryById(id);
        if (optionalLibrary.isPresent()) {
            Library existingLibrary = optionalLibrary.get();
            if (libraryDetails.getLibraryName() != null) {
                existingLibrary.setLibraryName(libraryDetails.getLibraryName());
            }
            if (libraryDetails.getAddressLine1() != null) {
                existingLibrary.setAddressLine1(libraryDetails.getAddressLine1());
            }
            if (libraryDetails.getAddressLine2() != null) {
                existingLibrary.setAddressLine2(libraryDetails.getAddressLine2());
            }
            if (libraryDetails.getCity() != null) {
                existingLibrary.setCity(libraryDetails.getCity());
            }
            if (libraryDetails.getState() != null) {
                existingLibrary.setState(libraryDetails.getState());
            }
            if (libraryDetails.getZip() != null) {
                existingLibrary.setZip(libraryDetails.getZip());
            }
            if (libraryDetails.getCountry() != null) {
                existingLibrary.setCountry(libraryDetails.getCountry());
            }
            Library updatedLibrary = libraryService.saveLibrary(existingLibrary);
            return new ResponseEntity<>(updatedLibrary, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibrary(@PathVariable Long id) {
        libraryService.deleteLibrary(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
