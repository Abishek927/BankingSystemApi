package com.bank.services;

import java.util.List;

import com.bank.models.Account;

public interface AccountService {
	public List<Account> getAllAccount(Long bankCode,Long branchId);
	public Account getAccount(Long bankCode,Long branchId,Long accountNo);
	public Account addAccount(Long bankCode,Long branchId,Account account); 
	public String delAccount(Long bankCode,Long branchId,Long accountNo);
	public Account updateAccount(Long bankCode,Long branchId,Long accountNo,Account newAccount);

}
