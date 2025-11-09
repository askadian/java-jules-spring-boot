package com.library.repository;

import com.library.model.LibraryBookCollection;
import com.library.model.LibraryBookCollectionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryBookCollectionRepository extends JpaRepository<LibraryBookCollection, LibraryBookCollectionId> {
}
