package com.bank.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.models.Bank;
import com.bank.models.Branch;
import com.bank.models.Loan;
import com.bank.repository.BankRepository;
import com.bank.repository.BranchRepository;
import com.bank.repository.LoanReposiratory;

@Service
public class LoanServiceImpl implements LoanService {
	@Autowired
	private BankRepository bankRepository;
	@Autowired
	private BranchRepository branchRepository;
	
	@Autowired
	private LoanReposiratory loanReposiratory;

	@Override
	public List<Loan> getAllLoan(Long bankCode, Long branchId) {
		
		Bank bank;
		List<Branch> branchs=new ArrayList<Branch>();
		List<Loan> loan=new ArrayList<Loan>();
		bank=this.bankRepository.findByCode(bankCode);
		branchs=bank.getBranch();
		for (Branch branch :branchs) {
			if(branch.getBranchId()==branchId) {
				loan=branch.getLoan();
			}
			
		}
		return loan;
	}

	@Override
	public Loan getLoan(Long bankCode, Long branchId, Long loanId) {
		Bank bank;
		List<Branch> branchs=new ArrayList<Branch>();
		List<Loan> loans=new ArrayList<Loan>();
		Loan loan=new Loan();
		
		bank=this.bankRepository.findByCode(bankCode);
		branchs=bank.getBranch();
		for (Branch branch : branchs) {
			if(branch.getBranchId()==branchId) {
				loans=branch.getLoan();
				for (Loan loan1 : loans) {
					if(loan1.getLoanId()==loanId) {
						loan=loan1;
					}
				}
			}
			
		}

		
		return loan;
	}

	@Override
	public Loan addLoan(Long bankCode, Long branchId, Loan loan) {
		Bank bank;
		List<Branch> branchs=new ArrayList<Branch>();
		Loan resultloan=new Loan();
		
		bank=this.bankRepository.findByCode(bankCode);
		branchs=bank.getBranch();
		for (Branch branch: branchs) {
			if(branch.getBranchId()==branchId) {
				loan.setBranch1(branch);
				branch.getLoan().add(loan);
				this.branchRepository.save(branch);
				resultloan=loan;
				
			}
			
		}
		
		
		
		return resultloan;
	}

	@Override
	public String delLoan(Long bankCode, Long branchId, Long loanId) {
		Bank bank;
		List<Branch> branchs=new ArrayList<Branch>();
		List<Loan> loans=new ArrayList<Loan>();
		bank=this.bankRepository.findByCode(bankCode);
		String message="";
		branchs=bank.getBranch();
		for (Branch branch : branchs) {
			if(branch.getBranchId()==branchId) {
				loans=branch.getLoan();
				for (Loan loan : loans) {
					if(loan.getLoanId()==loanId) {
						loan.getBranch1().setLoan(null);
						this.loanReposiratory.delete(loan);
						message="Successfully deleted particular loan"+loanId;
						
					}
					
				}
				
			}
		}
		
		
		
		return message;
	}

	@Override
	public Loan updateLoan(Long bankCode, Long branchId, Long loanId, Loan loan) {
		Bank bank;
		List<Branch> branchs=new ArrayList<Branch>();
		List<Loan> loans=new ArrayList<Loan>();
		Loan loan1=new Loan();
		bank=this.bankRepository.findByCode(bankCode);
		branchs=bank.getBranch();
		for (Branch branch : branchs) {
			if(branch.getBranchId()==branchId) {
				loans=branch.getLoan();
				for (Loan loan2 : loans) {
					if(loan2.getLoanId()==loanId) {
						loan2.setLoanId(loan.getLoanId());
						loan2.setLoan_type(loan.getLoan_type());
						loan2.setAmount(loan.getAmount());
						loan2.setBranch1(loan.getBranch1());
						loan2.setCustomer(loan.getCustomer());
						this.loanReposiratory.save(loan2);
						loan1=loan2;
						
					}
				}
			}
			
		}
		
		
		return loan1;
	}
	
	
	

}
