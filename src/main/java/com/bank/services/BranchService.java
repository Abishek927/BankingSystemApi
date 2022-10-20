package com.bank.services;

import java.util.List;


import com.bank.models.Branch;

public interface BranchService {
	public List<Branch> getAllBranch(Long code);
	public Branch getBranch(Long bankCode,Long branchId);
	public Branch addBranch(Long bankCode,Branch branch);
	public String delBranch(Long bankCode,Long branchId);
	public Branch updateBranch(Long bankCode,Long branchId,Branch branch);
	

}
