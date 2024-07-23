package com.library.demo.Controller;

import com.library.demo.Entity.Book;
import com.library.demo.Entity.Loan;
import com.library.demo.Entity.User.Admin;
import com.library.demo.Entity.User.Reader;
import com.library.demo.Repository.BookRepository;
import com.library.demo.Repository.LoanRepository;
import com.library.demo.Repository.User.AdminRepository;
import com.library.demo.Repository.User.ReaderRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/loans")
public class LoanController {
    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;
    private final AdminRepository adminRepository;
    private final ReaderRepository readerRepository;


    public LoanController(LoanRepository loanRepository, BookRepository bookRepository, AdminRepository adminRepository, ReaderRepository readerRepository) {
        this.loanRepository = loanRepository;
        this.bookRepository = bookRepository;
        this.adminRepository = adminRepository;
        this.readerRepository = readerRepository;
    }

    @GetMapping
    public List<Loan> getLoans(){
        return loanRepository.findAll();
    }

    @GetMapping("{loanId}")
    public Loan getLoan(@PathVariable("loanId") Integer id){
        Optional nloan = loanRepository.findById(id);
        if (nloan.isPresent()){
            return (Loan) nloan.get();
        } else {
            return new Loan();
        }
    }

    record NewLoanRequest(
       Integer bookId,
       Integer readerId,
       Integer adminId,
       Long startTime
    ){}

    @PostMapping
    public List<Loan> addLoan(@RequestBody LoanController.NewLoanRequest request){
        Optional nbook = bookRepository.findById(request.bookId());
        Optional nreader = readerRepository.findById(request.readerId());
        Optional nadmin = adminRepository.findById(request.adminId());
        if (nbook.isPresent() && nreader.isPresent() && nadmin.isPresent()){
            Book book = (Book) nbook.get();
            Reader reader = (Reader) nreader.get();
            Admin admin = (Admin) nadmin.get();
            Loan loan = new Loan(reader,admin,book, new Date(), false);
            loanRepository.save(loan);
        }
        return loanRepository.findAll();
    }

    @PutMapping("{loanId}")
    public List<Loan> returnBook(@PathVariable("loanId") Integer id){
        Optional nloan = loanRepository.findById(id);
        if (nloan.isPresent()){
            Loan loan = (Loan) nloan.get();
            loan.setReturned(true);
            loanRepository.save(loan);
        }
        return loanRepository.findAll();
    }



}
