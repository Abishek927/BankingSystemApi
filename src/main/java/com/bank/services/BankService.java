package com.bank.services;

import java.util.List;

import com.bank.models.Bank;

public interface BankService {
	public List<Bank> getBanks();
	public Bank getBank(Long code);
	public Bank addBank(Bank bank);
	public String delBank(Long code);
	public Bank updateBank(Long code,Bank bank);

}
