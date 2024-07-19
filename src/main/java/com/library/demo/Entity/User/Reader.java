package com.library.demo.Entity.User;

import jakarta.persistence.Entity;

import java.util.Date;
@Entity
public class Reader extends User{
    private Date expiryDate;
    private String note;

    public Reader() {
    }

    public Reader(String username, String passwd, String email, Date expiryDate, String note) {
        super(username, passwd, email);
        this.expiryDate = expiryDate;
        this.note = note;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
