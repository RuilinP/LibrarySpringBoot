package com.library.demo.Controller;

import com.library.demo.Entity.Author;
import com.library.demo.Entity.Book;
import com.library.demo.Repository.AuthorRepository;
import com.library.demo.Repository.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    record NewAuthorRequest(
            String name,
            String note
    ){}

    @PostMapping
    public List<Author> addAuthor(@RequestBody AuthorController.NewAuthorRequest request){
        Author newauthor = new Author();
        newauthor.setName(request.name());
        newauthor.setNote(request.note());
        authorRepository.save(newauthor);
        return authorRepository.findAll();
    }

    @PostMapping("{authorId}/books/{bookId}")
    public List<Author> addBooksOfAuthors(@PathVariable("authorId") Integer author_id
            ,@PathVariable("bookId") Integer book_id){
        Optional nauthor = authorRepository.findById(author_id);
        Author author = (Author) nauthor.get();
        Optional nbook = bookRepository.findById(book_id);
        Book book = (Book) nbook.get();
        author.getWrittenBooks().add(book);
        authorRepository.save(author);
        return authorRepository.findAll();
    }

}
