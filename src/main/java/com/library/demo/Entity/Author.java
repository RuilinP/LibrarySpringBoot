package com.library.demo.Entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Author {
    @Id
    @SequenceGenerator(
            name = "author_id_sequence",
            sequenceName = "author_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "author_id_sequence"
    )
    private Integer author_id;
    private String name;
    private String note;
    @ManyToMany
    @JoinTable(
            name="AuthorBook",
            joinColumns = @JoinColumn(name="author_id"),
            inverseJoinColumns = @JoinColumn(name="book_id")
    )
    Set<Book> writtenBooks;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Set<Book> getWrittenBooks() {
        return writtenBooks;
    }

    public void setWrittenBooks(Set<Book> writtenBooks) {
        this.writtenBooks = writtenBooks;
    }
}
