package com.library.demo.Entity.User;

import jakarta.persistence.Entity;

@Entity
public class Admin extends User {
    private String phone;

    public Admin() {
    }

    public Admin(String username, String passwd, String email, String phone) {
        super(username, passwd, email);
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
