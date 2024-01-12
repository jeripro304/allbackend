package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

 

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.RequestSim;
import com.example.demo.repository.RequestSimRepo;
import com.example.demo.service.OtpService;
import lombok.extern.slf4j.Slf4j;

 

@RestController
@RequestMapping
@Slf4j
public class OtpController {
	@Autowired
	private OtpService otpService;
	
	@Autowired
	private RequestSimRepo repo;
	
	
	
	@CrossOrigin(origins="http://localhost:4200/")
	@PostMapping("/requestotp")
	public ResponseEntity<Map<String, Boolean>> requestOTP(@RequestBody Map<String, String> requestBody) {
	    String phoneNumber = requestBody.get("phoneNumber");
	    String email = requestBody.get("email");
	    
	    RequestSim user = repo.findByPhonenumberAndEmailid(phoneNumber, email);

	    if (user == null) {
	        System.out.println("User not found");
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("exists", false);
	        return ResponseEntity.ok(response);
	    } else {
	        // User exists, check status
	        String status = user.getStatus();
	        if ("inactive".equals(status)) {
	            System.out.println("Activate your number");
	            Map<String, Boolean> response = new HashMap<>();
	            response.put("exists", false);
	            return ResponseEntity.ok(response);
	        } else {
	            // Status is not 'inactive', proceed
	            String otp = otpService.generateRandomOTP();
	            if (otpService.sendOtp(phoneNumber, otp) && otpService.sendMail(otp, email)) {
	                Map<String, Boolean> response = new HashMap<>();
	                response.put("exists", true);
	                System.out.println("true");
	                return ResponseEntity.ok(response);
	            } else {
	                return ResponseEntity.status(HttpStatus.SC_INTERNAL_SERVER_ERROR).body(null);
	            }
	        }
	    }
	}

	
	  @CrossOrigin(origins="http://localhost:4200/")
	  @PostMapping("/validateotp")
	    public ResponseEntity<Boolean> validateOtp(@RequestBody Map<String, String> requestBody) {
	        String phoneNumber = requestBody.get("phoneNumber");
	        String userEnteredOtp = requestBody.get("otp");

	        System.out.println("Received OTP: " + userEnteredOtp);
	        System.out.println("Received Phone Number: " + phoneNumber);
	        
	        boolean isOtpValid = otpService.validateOtp(phoneNumber, userEnteredOtp);
	        return ResponseEntity.ok().body(isOtpValid);
//	        if (isOtpValid) {
//	            return ResponseEntity.ok("OTP is valid");
//	        } else {
//	            return ResponseEntity.badRequest().body("Invalid OTP");
//	        }
	    }
	  
	  
	  
	  
	  
	
}

 

