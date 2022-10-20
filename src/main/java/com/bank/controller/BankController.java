package com.bank.controller;

import java.util.ArrayList;
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

import com.bank.models.Bank;
import com.bank.response.responseHandler;
import com.bank.services.BankService;

@RestController
public class BankController {
	@Autowired
	private BankService bankService;
	
	
	
	@GetMapping("/banks")
	public ResponseEntity<Object> getBanks(){
		try {
		List<Bank> bankList=new ArrayList<Bank>();
		bankList=bankService.getBanks();
		 return responseHandler.generateResponse("Successfully Retrieved!!",HttpStatus.OK, bankList);
		
		}catch(Exception e) {
			return responseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS, null);

			
		}
		
		
	
		
	}
	
	@GetMapping("/banks/{code}")
	public ResponseEntity<Object> getBank(@PathVariable("code")Long code ) {
		
		try {
		Bank bank=new Bank();
		
		bank=bankService.getBank(code);
		return responseHandler.generateResponse("successfully retrieved data of a particular person",HttpStatus.OK , bank);
		}catch(Exception e) {
			return responseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS, null);

		}
		
	}
	
	@PostMapping("/banks")
	public ResponseEntity<Object> addBank(@RequestBody Bank bank) {
		try {
		Bank b=null;
			b=bankService.addBank(bank);
			return responseHandler.generateResponse("successfully created a bank",HttpStatus.CREATED, b);
	}catch(Exception e) {
		return responseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
	}
	}
	
	@DeleteMapping("/banks/{code}")
	public ResponseEntity<Object> delBank(@PathVariable("code")Long code) {
		try {
		 String message=bankService.delBank(code);
		 return responseHandler.generateResponse("Deleted successfully!!", HttpStatus.OK,message);
		
		
		}catch (Exception e) {
			return responseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
		}
		
		
	}
	
	@PutMapping("/banks/{code}")
	public ResponseEntity<Object> updateBank(@PathVariable("code")Long code,@RequestBody Bank bank) {
		
		try {
		Bank b=new Bank();
		b=bankService.updateBank(code, bank);
		return responseHandler.generateResponse("Successfully updated",HttpStatus.OK, b);
		}catch(Exception e) {
			return responseHandler.generateResponse(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,null);
		}
	}
	
	

}
