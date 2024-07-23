package com.library.demo.Repository.User;

import com.library.demo.Entity.User.User;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ReaderRepository extends UserRepository{
    @Query("SELECT r FROM Reader r")
    List<User> findAll();

    @Query("SELECT a FROM Reader a WHERE a.user_id =:id")
    Optional<User> findById(Integer id);
}
