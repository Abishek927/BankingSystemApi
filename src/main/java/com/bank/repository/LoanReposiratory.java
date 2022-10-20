package com.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.models.Loan;

@Repository
public interface LoanReposiratory extends JpaRepository<Loan, Long> {
	public Loan findByLoanId(Long loanId);
	

}
