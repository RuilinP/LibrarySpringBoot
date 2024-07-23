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
    private Integer loan_id;
    @ManyToOne
    @JoinColumn(name = "reader_id",referencedColumnName = "user_id", nullable = false)
    private Reader reader;
    @ManyToOne
    @JoinColumn(name = "admin_id",referencedColumnName = "user_id", nullable = false)
    private Admin admin;
    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;
    private Date startDate;
    private Boolean returned;

    public Loan(Reader reader, Admin admin, Book book, Date startDate, Boolean returned) {
        this.reader = reader;
        this.admin = admin;
        this.book = book;
        this.startDate = startDate;
        this.returned = returned;
    }

    public Loan() {
    }

    public Integer getId() {
        return loan_id;
    }

    public void setId(Integer id) {
        this.loan_id = id;
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

    public Boolean getReturned() {
        return returned;
    }

    public void setReturned(Boolean returned) {
        this.returned = returned;
    }
}
