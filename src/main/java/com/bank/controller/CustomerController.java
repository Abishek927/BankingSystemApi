package com.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.models.Customer;
import com.bank.response.responseHandler;
import com.bank.services.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	
	
	@GetMapping("/customers")
	public ResponseEntity<Object> getCustomers(){
		List<Customer> customer;
		try {
			customer=customerService.getCustomers();
			 return responseHandler.generateResponse("successfully retrieved all customer",HttpStatus.OK, customer);
			
		}catch(Exception e) {
			return responseHandler.generateResponse(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}
	
	@GetMapping("/customers/{customerId}")
	public ResponseEntity<Object> getCustomer(@PathVariable("customerId") Long customerId){
		Customer customer=new Customer();
		
		try {
			customer=customerService.getCustomer(customerId);
			return responseHandler.generateResponse("successfully retrieved a particular customer",HttpStatus.OK, customer);
			
		}catch(Exception e) {
			return responseHandler.generateResponse(e.getMessage(),HttpStatus.BAD_REQUEST,null);
			
		}
		
		
	}
	
	@PostMapping("/customers")
	public ResponseEntity<Object> addCustomer(@RequestBody Customer customer){
		Customer customer1=new Customer();
		try {
			customer1=customerService.addCustomer(customer);
			return responseHandler.generateResponse("successfully added customer",HttpStatus.OK, customer1);
			
		}catch(Exception e) {
			return responseHandler.generateResponse(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
		
	}
	
	@DeleteMapping("/customers/{customerId}")
	public ResponseEntity<Object> delCustomer(@PathVariable("customerId")Long customerId){
		String message;
		
		try {
			message=customerService.delCustomer(customerId);
			return responseHandler.generateResponse("Deleted!!", HttpStatus.OK, message);
			
			
		}catch(Exception e) {
			return responseHandler.generateResponse(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,null);
		}
	}
	@PutMapping("/customers/{customerId}")
	public ResponseEntity<Object> updateCustomer(@PathVariable("customerId")Long customerId,@RequestBody Customer customer){
		Customer customer1=new Customer();
		
		try {
		customer1=customerService.updateCustomer(customerId, customer1);
		return responseHandler.generateResponse("Successfully update particular customer according to their customerId",HttpStatus.OK, customer1);
			
		}catch(Exception e) {
			return responseHandler.generateResponse(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,null);
			
		}
	}
	
	
	
}
