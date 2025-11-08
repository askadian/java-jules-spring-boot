package com.library.service;

import com.library.model.Library;
import java.util.List;
import java.util.Optional;

public interface LibraryService {
    Library saveLibrary(Library library);
    List<Library> getAllLibraries();
    Optional<Library> getLibraryById(Long id);
    void deleteLibrary(Long id);
}
