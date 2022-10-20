package com.bank.services;

import java.util.List;

import com.bank.models.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();
	public Customer getCustomer(Long customerId);
	public Customer addCustomer(Customer customer);
	public String delCustomer(Long customerId);
	public Customer updateCustomer(Long CustomerId,Customer customer);
	

}
