package com.bank.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.models.Bank;
import com.bank.models.Branch;
import com.bank.repository.BankRepository;
import com.bank.repository.BranchRepository;
@Service
public class BranchServiceImpl implements BranchService {
	@Autowired
	 private BankRepository bankRepository;
	@Autowired
	private BranchRepository branchRepository;

	@Override
	public List<Branch> getAllBranch(Long code) {
		List<Branch> branch;
		Bank bank=new Bank();
		bank=bankRepository.findByCode(code);
		branch=bank.getBranch();
		return branch;
	}

	@Override
	public Branch getBranch(Long bankCode, Long branchId) {
		Bank bank=new Bank();
		Branch branch=new Branch();
		List<Branch> branches;
		bank=bankRepository.findByCode(bankCode);
		branches=bank.getBranch();
		for (Branch branch2 : branches) {
			if(branch2.getBranchId()==branchId) {
				branch=branch2;
			}
			
			
		}
		return branch;
		
		

		
	}


	@Override
	public Branch addBranch(Long bankCode, Branch branch) {
		Boolean b=false;
		Bank bank;
		bank=bankRepository.findByCode(bankCode);
		branch.setBank(bank);
		
		b=bank.getBranch().add(branch);
		bankRepository.save(bank);
		if(b) {
		
		return branch;
	}else {
		return null;
	}
	

}

	@Override
	public String delBranch(Long bankCode, Long branchId) {
		Bank bank;
		Branch b;
		List<Branch> branch;
		String message="";
		bank=bankRepository.findByCode(bankCode);
		branch=bank.getBranch();
		for (Branch branch1 : branch) {
			if(branch1.getBranchId()==branchId) {
				//b=branchRepository.findByBranchId(branchId);
				branch1.getBank().setBranch(null);

				branchRepository.delete(branch1);
				message="Successfully deleted particular branch"+branchId;
			
				
				
			}
			
		}
		
		
		return message;
	}

	@Override
	public Branch updateBranch(Long bankCode, Long branchId, Branch branch) {
		boolean b;
		List<Branch> branches;
		Bank bank;
		bank=bankRepository.findByCode(bankCode);
		branches=bank.getBranch();
		for (Branch branch2 : branches) {
			if(branch2.getBranchId()==branchId) {
				
				
				branch2.setBranchId(branch.getBranchId());
				branch2.setName(branch.getName());
				branch2.setAddress(branch.getAddress());
				branch2.setAccount(branch.getAccount());
				branch2.setLoan(branch.getLoan());
				
				b=bank.getBranch().add(branch2);
				bankRepository.save(bank);
				
			}
			
		}
		
		return branch;
			
	}
}
