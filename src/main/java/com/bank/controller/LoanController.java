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
import com.bank.models.Branch;
import com.bank.models.Loan;
import com.bank.response.responseHandler;
import com.bank.services.LoanService;

@RestController
public class LoanController {
	@Autowired
	private LoanService loanService;
	
	
	@GetMapping("/banks/{bankCode}/branch/{branchId}/loan")
	public ResponseEntity<Object> getAllLoan(@PathVariable("bankCode")Long bankCode,@PathVariable("branchId")Long branchId)
	{
		List<Loan> loan=new ArrayList<Loan>();
		try {
			loan=this.loanService.getAllLoan(bankCode, branchId);
			return responseHandler.generateResponse("Successfully retrieved all loan",HttpStatus.OK, loan);
			
			
		}catch(Exception e) {
			return responseHandler.generateResponse(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
		
	}
	
	@GetMapping("/banks/{bankCode}/branch/{branchId}/loan/{loanId}")
	public ResponseEntity<Object> getLoan(@PathVariable("bankCode")Long bankCode,@PathVariable("branchId")Long branchId,@PathVariable("loanId")Long loanId){
		Loan loan=new Loan();
		try {
			loan=this.loanService.getLoan(bankCode, branchId, loanId);
			return responseHandler.generateResponse("Successfully retrieved particular loan",HttpStatus.OK, loan);
			
		}catch(Exception e) {
			return responseHandler.generateResponse(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,null);
			
		}
		
		
	}
	
	
	@PostMapping("/banks/{bankCode}/branch/{branchId}/loan")
	public ResponseEntity<Object> addLoan(@PathVariable("bankCode")Long bankCode,@PathVariable("branchId")Long branchId,@RequestBody Loan loan){
		Loan addedLoan=new Loan();
		
		try {
			addedLoan=this.loanService.addLoan(bankCode, branchId,loan);
			return responseHandler.generateResponse("Successfully added loan",HttpStatus.OK, addedLoan);
			
			
			
		}catch(Exception e) {
			return responseHandler.generateResponse(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,null);
		}
	}
	
	
	@DeleteMapping("/banks/{bankCode}/branch/{branchId}/loan/{loanId}")
	public ResponseEntity<Object> delLoan(@PathVariable("bankCode")Long bankCode,@PathVariable("branchId")Long branchId,@PathVariable("loanId")Long loanId){
		String message="";
		try {
			message=this.loanService.delLoan(bankCode, branchId, loanId);
			return responseHandler.generateResponse("deleted", HttpStatus.OK, message);
			
		}catch(Exception e) {
			return responseHandler.generateResponse(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,null);
			
		}
	
	}
	
	
	@PutMapping("/banks/{bankCode}/branch/{branchId}/loan/{loanId}")
	public ResponseEntity<Object> updateLoan(@PathVariable("bankCode")Long bankCode,@PathVariable("branchId")Long branchId,@PathVariable("loanId")Long loanId,@RequestBody Loan loan ){
		Loan newloan=new Loan();
		
		
		try {
			newloan=this.loanService.updateLoan(bankCode, branchId, loanId,loan);
			return responseHandler.generateResponse("Updated successfully",HttpStatus.OK, newloan);
				
			}catch(Exception e) {
				return responseHandler.generateResponse(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,null);
				
				
			}

}
}

