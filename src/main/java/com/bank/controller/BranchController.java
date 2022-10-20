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

import com.bank.models.Branch;
import com.bank.response.responseHandler;
import com.bank.services.BranchService;

@RestController
public class BranchController {
	@Autowired
	private BranchService branchService;
	
	@GetMapping("/banks/{code}/branch")
	public ResponseEntity<Object> getAllBranch(@PathVariable("code")Long code){
		List<Branch> branch;
		try {
			branch=branchService.getAllBranch(code);
			return responseHandler.generateResponse("Successfully retrieved all branch of particular branch",HttpStatus.OK, branch);
			
			
			
		}catch(Exception e) {
			return responseHandler.generateResponse(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR, null);
			
		}
		
	}
	@GetMapping("/banks/{bankCode}/branch/{branchId}")
	public ResponseEntity<Object> getBranch(@PathVariable("bankCode")Long bankCode,@PathVariable("branchId")Long branchId){
		Branch branch;
		try {
			branch=branchService.getBranch(bankCode, branchId);
			return responseHandler.generateResponse("successfully retrieved particular branch",HttpStatus.OK, branch);
		}catch(Exception e) {
			return responseHandler.generateResponse(e.getMessage(),HttpStatus.OK,null);
		}
	}
	
	@PostMapping("/banks/{bankCode}/branch")
	public ResponseEntity<Object> addBranch(@PathVariable("bankCode")Long bankCode,@RequestBody Branch branch){
		Branch branch1;
		
		try 
		{
		branch1=branchService.addBranch(bankCode, branch);
		if(branch!=null) {
			return responseHandler.generateResponse("successfully added branch",HttpStatus.OK, branch1);
		}
		else {
			return responseHandler.generateResponse("No branch has been added",HttpStatus.INTERNAL_SERVER_ERROR,null);
		}
			
		}catch(Exception e) {
			return responseHandler.generateResponse(e.getMessage(),HttpStatus.BAD_REQUEST,null);
		}
	}
	
	@DeleteMapping("/banks/{bankCode}/branch/{branchId}")
	public ResponseEntity<Object> delBranch(@PathVariable("bankCode")Long bankCode,@PathVariable("branchId")Long branchId){
		String message="";
		try {
			message=branchService.delBranch(bankCode, branchId);
			return responseHandler.generateResponse("deleted!!",HttpStatus.OK, message);
			
		}catch(Exception e) {
			return responseHandler.generateResponse(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,null);
		}
	}
	
	@PutMapping("/banks/{bankCode}/branch/{branchId}")
	public ResponseEntity<Object> updateBranch(@PathVariable("bankCode")Long bankCode,@PathVariable("branchId")Long branchId,@RequestBody Branch branch)
	{
		Branch newBranch;
		try {
			newBranch=branchService.updateBranch(bankCode, branchId,branch);
			System.out.print(newBranch);
			
			return responseHandler.generateResponse("successfully update particular branch",HttpStatus.OK, newBranch);
			
		}catch(Exception e) {
		
			return responseHandler.generateResponse(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,null);
			
		}
		
	}

}
