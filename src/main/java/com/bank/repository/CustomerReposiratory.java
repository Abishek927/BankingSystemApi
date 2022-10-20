package com.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.models.Customer;


@Repository
public interface CustomerReposiratory extends JpaRepository<Customer,Long> {
	public Customer findByCustomerId(Long customerId);

}
