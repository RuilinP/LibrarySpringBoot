package com.library.demo.Repository.User;

import com.library.demo.Entity.User.User;
import org.springframework.data.jpa.repository.Query;

public interface ReaderRepository extends UserRepository{
    @Query("SELECT r FROM Reader r")
    Iterable<User> findAll();
}
