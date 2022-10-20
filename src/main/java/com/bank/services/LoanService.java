package com.bank.services;

import java.util.List;

import com.bank.models.Loan;

public interface LoanService {
	public List<Loan> getAllLoan(Long bankCode,Long branchId);
	public Loan getLoan(Long bankCode,Long branchId,Long loanId);
	public Loan addLoan(Long bankCode,Long branchId,Loan loan);
	public String delLoan(Long bankCode,Long branchId,Long loanId);
	public Loan updateLoan(Long bankCode,Long branchId,Long loanId,Loan loan);

}
