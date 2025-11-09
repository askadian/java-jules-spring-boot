package com.library.service;

import com.library.model.LibraryBookCollection;
import com.library.model.LibraryBookCollectionId;
import com.library.repository.LibraryBookCollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryBookCollectionServiceImpl implements LibraryBookCollectionService {

    @Autowired
    private LibraryBookCollectionRepository libraryBookCollectionRepository;

    @Override
    public LibraryBookCollection saveLibraryBookCollection(LibraryBookCollection libraryBookCollection) {
        return libraryBookCollectionRepository.save(libraryBookCollection);
    }

    @Override
    public List<LibraryBookCollection> getAllLibraryBookCollections() {
        return libraryBookCollectionRepository.findAll();
    }

    @Override
    public Optional<LibraryBookCollection> getLibraryBookCollectionById(LibraryBookCollectionId id) {
        return libraryBookCollectionRepository.findById(id);
    }

    @Override
    public void deleteLibraryBookCollection(LibraryBookCollectionId id) {
        libraryBookCollectionRepository.deleteById(id);
    }
}
