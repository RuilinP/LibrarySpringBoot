package com.library.demo.Repository;

import com.library.demo.Entity.Book;
import com.library.demo.Entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Integer> {
}
