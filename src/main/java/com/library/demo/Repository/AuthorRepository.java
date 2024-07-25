package com.library.demo.Repository;

import com.library.demo.Entity.Author;
import com.library.demo.Entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    @Query("SELECT a FROM Author a JOIN a.writtenBooks b WHERE b.id " +
            "= :book_id")
    List<Author> findAuthorsByBookId(@Param("book_id") Integer book_id);
}
