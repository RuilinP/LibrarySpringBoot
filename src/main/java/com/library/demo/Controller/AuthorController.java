package com.library.demo.Controller;

import com.library.demo.Entity.Author;
import com.library.demo.Entity.Book;
import com.library.demo.Repository.AuthorRepository;
import com.library.demo.Repository.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public AuthorController(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @GetMapping("{authorId}/books")
    public List<Book> getBooksByAuthors(@PathVariable("authorId") Integer author_id){
        return bookRepository.findBookByAuthorId(author_id);
    }
}
