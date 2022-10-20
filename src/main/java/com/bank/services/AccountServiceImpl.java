package com.bank.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.models.Account;
import com.bank.models.Bank;
import com.bank.models.Branch;
import com.bank.repository.AccountRepository;
import com.bank.repository.BankRepository;
import com.bank.repository.BranchRepository;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private BankRepository bankRepository;
	
	@Autowired
	private BranchRepository branchRepository;
	@Autowired
	private AccountRepository accountRepository;
	

	@Override
	public List<Account> getAllAccount(Long bankCode, Long branchId) {
		Bank bank;
		List<Branch> branch;
		List<Account> accounts=new ArrayList<Account>();
		bank=bankRepository.findByCode(bankCode);
		branch=bank.getBranch();
	   for (Branch branch2 : branch) {
			if(branch2.getBranchId()==branchId) {
				accounts=branch2.getAccount();
			}
		}
		
		return accounts;
	}


	@Override
	public Account getAccount(Long bankCode, Long branchId, Long accountNo) {
		Bank bank;
		List<Branch> branchs;
		List<Account> accounts;
		Account account1=new Account();
		bank=bankRepository.findByCode(bankCode);
		branchs=bank.getBranch();
		for (Branch branch : branchs) {
			if(branch.getBranchId()==branchId) {
				accounts=branch.getAccount();
				for (Account account : accounts) {
					if(account.getAccountNo()==accountNo) {
						account1=account;
					}
					
				}
			}
		}
		
		
		
		return account1;
	}


	@Override
	public Account addAccount(Long bankCode, Long branchId, Account account) {
		boolean b;
		Bank bank;
		List<Branch> branch;
		
		bank=bankRepository.findByCode(bankCode);
		branch=bank.getBranch();
		for (Branch branch2 : branch) {
			if(branch2.getBranchId()==branchId) {
				account.setBranch(branch2);
				b=branch2.getAccount().add(account);
				branchRepository.save(branch2);
				
				
			}
		}
		
		
		return account;
	}


	@Override
	public String delAccount(Long bankCode, Long branchId, Long accountNo) {
		String message="";
		Bank bank;
		List<Branch> branchs;
		List<Account> accounts;
		bank=this.bankRepository.findByCode(bankCode);
		branchs=bank.getBranch();
		for (Branch branch:branchs) {
			if(branch.getBranchId()==branchId) {
				accounts=branch.getAccount();
				for (Account account : accounts) {
					if(account.getAccountNo()==accountNo) {
						account.getBranch().setAccount(null);
						this.accountRepository.delete(account);
						message="Successfully deleted particular account"+accountNo;
						
					}
				}
			}
		}
		
		return message;
	}


	@Override
	public Account updateAccount(Long bankCode, Long branchId, Long accountNo, Account newAccount) {
		boolean b=false;
		Bank bank;
		List<Branch> branchs;
		List<Account> account;
		Account Account=new Account();
		bank=this.bankRepository.findByCode(bankCode);
		branchs=bank.getBranch();
		for (Branch branch : branchs) {
			if(branch.getBranchId()==branchId) {
				account=branch.getAccount();
				for(Account eachAccount : account) {
					if(eachAccount.getAccountNo()==accountNo) {
						eachAccount.setAccountNo(newAccount.getAccountNo());
						eachAccount.setAccountType(newAccount.getAccountType());
						eachAccount.setBalance(newAccount.getBalance());
						eachAccount.setCustomer(newAccount.getCustomer());
						b= branch.getAccount().add(eachAccount);
						this.branchRepository.save(branch);
						Account=eachAccount;
					}
					
				}
				
			}
		}
		
		
		return Account;
	}
	
	
	

}
