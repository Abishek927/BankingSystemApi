package com.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.models.Branch;
@Repository
public interface BranchRepository extends JpaRepository<Branch,Long> {
	public Branch findByBranchId(Long branchId);

}
