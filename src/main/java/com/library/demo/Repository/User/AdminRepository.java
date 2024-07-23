package com.library.demo.Repository.User;

import com.library.demo.Entity.User.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdminRepository extends UserRepository{
    //custom JPQL query
    @Query("SELECT a FROM Admin a")
    List<User> findAll();

    @Query("SELECT a FROM Admin a WHERE a.user_id =:id")
    Optional<User> findById(Integer id);
}
