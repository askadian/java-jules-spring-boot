package com.library.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LibraryBookCollectionId implements Serializable {

    private Long libraryId;
    private Long bookId;

    public LibraryBookCollectionId() {
    }

    public LibraryBookCollectionId(Long libraryId, Long bookId) {
        this.libraryId = libraryId;
        this.bookId = bookId;
    }

    public Long getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Long libraryId) {
        this.libraryId = libraryId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LibraryBookCollectionId that = (LibraryBookCollectionId) o;
        return Objects.equals(libraryId, that.libraryId) &&
                Objects.equals(bookId, that.bookId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(libraryId, bookId);
    }
}
