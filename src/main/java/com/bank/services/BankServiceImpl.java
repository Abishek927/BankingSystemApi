package com.bank.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.models.Bank;
import com.bank.repository.BankRepository;

@Service
public class BankServiceImpl implements BankService {
	@Autowired
	private BankRepository bankRepository;

	@Override
	public List<Bank> getBanks() {
		return bankRepository.findAll();
	}

	@Override
	public Bank getBank(Long code) {
		return bankRepository.findByCode(code);
		
	}

	@Override
	public Bank addBank(Bank bank) {
		Bank b=new Bank();
		b=bankRepository.save(bank);
		return b;
	}

	@Override
	public String delBank(Long code) {
		Bank bank=bankRepository.findByCode(code);
		bankRepository.delete(bank);
		return "Deleted successfully "+code;
	}



	@Override
	public Bank updateBank(Long code, Bank bank) {
		Bank b=new Bank();
		 b=bankRepository.save(bank);
		
		return b;
	}
	

}
