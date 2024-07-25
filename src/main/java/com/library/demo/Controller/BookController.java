package com.library.demo.Controller;
import com.library.demo.Entity.Author;
import com.library.demo.Repository.AuthorRepository;
import com.library.demo.Repository.BookRepository;
import com.library.demo.Entity.Book;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookController(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @GetMapping
    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    @GetMapping("{bookId}")
    public Book getBook(@PathVariable("bookId") Integer id){
        Optional nbook = bookRepository.findById(id);
        if (nbook.isPresent()){
            return (Book) nbook.get();
        } else {
            return new Book();
        }
    }

    @GetMapping("{bookId}/authors")
    public List<Author> getAuthorsByBook(@PathVariable("bookId") Integer book_id){
        return authorRepository.findAuthorsByBookId(book_id);
    }


    record NewBookRequest(
            String title,
            String isbn,
            Integer year
    ){}


    @PostMapping
    public List<Book> addBooks(@RequestBody NewBookRequest request){
        Book newbook = new Book();
        newbook.setTitle(request.title());
        newbook.setIsbn(request.isbn());
        newbook.setYear(request.year());
        newbook.setStatus(false);
        bookRepository.save(newbook);

        return bookRepository.findAll();
    }

    @DeleteMapping("{bookId}")
    public void removeBook(@PathVariable("bookId") Integer id){
        bookRepository.deleteById(id);
    }

    @PutMapping("{bookId}")
    public void borrowBook(@PathVariable("bookId") Integer id){
        Optional nbook = bookRepository.findById(id);
        if (nbook.isPresent()){
            Book book = (Book) nbook.get();
            book.setStatus(true);
            bookRepository.save(book);
        }
    }
}
