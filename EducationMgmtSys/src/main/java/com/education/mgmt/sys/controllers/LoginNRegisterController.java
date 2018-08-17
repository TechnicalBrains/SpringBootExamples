/**
 * 
 */
package com.education.mgmt.sys.controllers;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.education.mgmt.sys.dto.LoginNRegisterDTO;

/**
 * @author 611163
 *
 */
@CrossOrigin(methods={RequestMethod.POST,RequestMethod.GET}, origins="http://localhost:4200")
@RestController
public class LoginNRegisterController {
	
	private static ConcurrentHashMap<String, String> registrationDetails = new ConcurrentHashMap<>();

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody LoginNRegisterDTO register) {
		if(!registrationDetails.containsKey(register.getCode())) {
			registrationDetails.put(register.getCode(), register.getPassword());
			return ResponseEntity.status(HttpStatus.OK).body("Successfully Registered.");
		}
		return ResponseEntity.badRequest().body("User Already Registered.Please login.");
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginNRegisterDTO login) {
		if(registrationDetails.containsKey(login.getCode())) {
			if(registrationDetails.get(login.getCode()).equals(login.getPassword()))
				return ResponseEntity.status(HttpStatus.OK).build();
		}
		return ResponseEntity.badRequest().body("Invalid Code or Password.");
	}
	
}
