package com.library.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "library_book_collection")
public class LibraryBookCollection {

    @EmbeddedId
    private LibraryBookCollectionId id;

    @ManyToOne
    @MapsId("libraryId")
    @JoinColumn(name = "library_id")
    private Library library;

    @ManyToOne
    @MapsId("bookId")
    @JoinColumn(name = "book_id")
    private Book book;

    private int seqNumber;
    private LocalDateTime createDatetime;
    private LocalDateTime updateDatetime;
    private String lastUpdatedBy;

    public LibraryBookCollectionId getId() {
        return id;
    }

    public void setId(LibraryBookCollectionId id) {
        this.id = id;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getSeqNumber() {
        return seqNumber;
    }

    public void setSeqNumber(int seqNumber) {
        this.seqNumber = seqNumber;
    }

    public LocalDateTime getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(LocalDateTime createDatetime) {
        this.createDatetime = createDatetime;
    }

    public LocalDateTime getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(LocalDateTime updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }
}
