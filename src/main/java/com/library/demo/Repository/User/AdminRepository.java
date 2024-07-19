package com.library.demo.Repository.User;

import com.library.demo.Entity.User.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends UserRepository{
    //custom JPQL query
    @Query("SELECT a FROM Admin a")
    Iterable<User> findAll();
}
