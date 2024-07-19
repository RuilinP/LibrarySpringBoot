package com.library.demo.Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Book {
    @Id
    @SequenceGenerator(
            name = "book_id_sequence",
            sequenceName = "book_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_id_sequence"
    )
    private Integer id;
    private String title;
    private String isbn;
    private Integer year;
    private boolean status;

    public Book(Integer id,
                String title,
                String isbn,
                Integer year,
                boolean status) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.year = year;
        this.status = status;
    }

    public Book() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return status == book.status && Objects.equals(id, book.id) && Objects.equals(title, book.title) && Objects.equals(isbn, book.isbn) && Objects.equals(year, book.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, isbn, year, status);
    }
}
