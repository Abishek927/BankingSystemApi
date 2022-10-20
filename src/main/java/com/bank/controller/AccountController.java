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

import com.bank.models.Account;
import com.bank.response.responseHandler;
import com.bank.services.AccountService;


@RestController
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	
	@GetMapping("/banks/{bankCode}/branch/{branchId}/account")
	public ResponseEntity<Object> getAllAccount(@PathVariable("bankCode")Long bankCode,@PathVariable("branchId")Long branchId){
		List<Account> accounts=new ArrayList<Account>();
		try {
			accounts=this.accountService.getAllAccount(bankCode, branchId);
			return responseHandler.generateResponse("successfully retrieved list of account",HttpStatus.OK, accounts);
			
			
		}catch(Exception e) {
			return responseHandler.generateResponse(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
		
	}
	
	@GetMapping("/banks/{bankCode}/branch/{branchId}/account/{accountNo}")
	public ResponseEntity<Object> getAccount(@PathVariable("bankCode")Long bankCode,@PathVariable("branchId")Long branchId,@PathVariable("accountNo")Long accountNo){
		Account account=new Account();	
		try {
			account=this.accountService.getAccount(bankCode, branchId, accountNo);
			return responseHandler.generateResponse("successfully retrieved particular account",HttpStatus.OK, account);
	
				}catch(Exception e) {
					return responseHandler.generateResponse(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR, null);
					
				}
		
		
	}
	
	
	
	
	@PostMapping("/banks/{bankCode}/branch/{branchId}/account/{accountNo}")
	public ResponseEntity<Object> addAccount(@PathVariable("bankCode")Long bankCode,@PathVariable("branchId")Long branchId,@PathVariable("accountNo")Long accountNo,@RequestBody Account account){
		Account account2=new Account();
		
		try {
			account2=this.accountService.addAccount(bankCode, branchId, account);
			return responseHandler.generateResponse("successfully added account", HttpStatus.OK, account2);
			
		}catch(Exception e) {
			return responseHandler.generateResponse(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR, null);
			
		}
	}
	
	
	
	@DeleteMapping("/banks/{bankCode}/branch/{branchId}/account/{accountNo}")
	public ResponseEntity<Object> delAccount(@PathVariable("bankCode")Long bankCode,@PathVariable("branchId")Long branchId,@PathVariable("accountNo")Long accountNo){
		String message;
		try {
			message=this.accountService.delAccount(bankCode, branchId, accountNo);
			return responseHandler.generateResponse("deleted",HttpStatus.OK, message);
			
		}catch(Exception e) {
			return responseHandler.generateResponse(e.getMessage(), HttpStatus.OK, null);
		}
		
	}
	
	@PutMapping("/banks/{bankCode}/branch/{branchId}/account/{accountNo}")
	public ResponseEntity<Object> updateAccount(@PathVariable("bankCode")Long bankCode,@PathVariable("branchId")Long branchId,@PathVariable("accountNo")Long accountNo,@RequestBody Account account){
		Account account1=new Account();
		
		try {
			account1=this.accountService.updateAccount(bankCode, branchId, accountNo, account);
			return responseHandler.generateResponse("updated successfully ",HttpStatus.OK, account1);
			
		}catch(Exception e) {
			return responseHandler.generateResponse(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
		
	}
	
}
