package com.bank.response;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class responseHandler {

	public static ResponseEntity<Object> generateResponse(String message,HttpStatus httpStatus,Object responseBody){
	Map<String, Object> map= new HashMap<String,Object>();
map.put("message", message);
map.put("status_code",httpStatus.value());
map.put("responseData",responseBody);
return new ResponseEntity<Object>(map,httpStatus);

		
		
	}
}

