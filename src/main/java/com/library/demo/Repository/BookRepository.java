package com.library.demo.Repository;

import com.library.demo.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer>{
    @Query("SELECT b FROM Book b JOIN b.byAuthors a WHERE a.id = :author_id")
    List<Book> findBookByAuthorId(@Param("author_id") Integer author_id);
}
