package com.bank.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.models.Customer;
import com.bank.repository.CustomerReposiratory;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerReposiratory customerReposiratory;

	
	public List<Customer> getCustomers() {
		List<Customer> customerList;
		
			customerList=customerReposiratory.findAll();
			return customerList;
			
		}


	@Override
	public Customer getCustomer(Long customerId) {
		Customer customer;
		customer=customerReposiratory.findByCustomerId(customerId);
		
	
	return customer;
	}


	@Override
	public Customer addCustomer(Customer customer) {
		Customer c;
		c=customerReposiratory.save(customer);
		
		return c;
		
	}


	@Override
	public String delCustomer(Long customerId) {
		String message;
		Customer customer=customerReposiratory.findByCustomerId(customerId);
		customerReposiratory.delete(customer);
		message="Successfully deleted customer"+customerId;
		
		
		return message;
	}


	@Override
	public Customer updateCustomer(Long CustomerId, Customer customer) {
		Customer oldCustomer=customerReposiratory.findByCustomerId(CustomerId);
		customerReposiratory.delete(oldCustomer);
		Customer newCustomer=customerReposiratory.save(customer);
		
		return newCustomer ;
	}
	
	
	

}
