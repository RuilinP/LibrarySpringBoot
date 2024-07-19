package com.library.demo.Repository;

import com.library.demo.Entity.Author;
import com.library.demo.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
