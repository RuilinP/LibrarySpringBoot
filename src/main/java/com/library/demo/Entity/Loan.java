package com.library.demo.Entity;

import com.library.demo.Entity.User.Admin;
import com.library.demo.Entity.User.Reader;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Loan {
    @Id
    @SequenceGenerator(
            name = "loan_id_sequence",
            sequenceName = "loan_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "loan_id_sequence"
    )
    private Integer id;
    private Reader reader;
    private Admin admin;
    private Book book;
    private Date startDate;

    public Loan(Integer id, Reader reader, Admin admin, Book book, Date startDate) {
        this.id = id;
        this.reader = reader;
        this.admin = admin;
        this.book = book;
        this.startDate = startDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
