package com.library.service;

import com.library.model.LibraryBookCollection;
import com.library.model.LibraryBookCollectionId;

import java.util.List;
import java.util.Optional;

public interface LibraryBookCollectionService {
    LibraryBookCollection saveLibraryBookCollection(LibraryBookCollection libraryBookCollection);
    List<LibraryBookCollection> getAllLibraryBookCollections();
    Optional<LibraryBookCollection> getLibraryBookCollectionById(LibraryBookCollectionId id);
    void deleteLibraryBookCollection(LibraryBookCollectionId id);
}
