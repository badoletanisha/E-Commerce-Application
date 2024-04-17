package com.retail.ECommerceApplication.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retail.ECommerceApplication.requestdto.OtpRequest;
import com.retail.ECommerceApplication.requestdto.UserRequest;
import com.retail.ECommerceApplication.responsedto.UserResponse;
import com.retail.ECommerceApplication.service.UserService;
import com.retail.ECommerceApplication.utility.ResponseStructure;
import com.retail.ECommerceApplication.utility.SimpleResponseStructure;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class UserController {

	private UserService userService;
	
	@PostMapping("/register")
	public  ResponseEntity<SimpleResponseStructure>  userRegistration(@RequestBody UserRequest userReqeust){
		return userService.userRegistration(userReqeust);
		
	}
	
	@PostMapping("/verifyOTP")
	public ResponseEntity<ResponseStructure<UserResponse>> verifyOTP(@RequestBody OtpRequest otpRequest) {
		return userService.verifyOTP(otpRequest);
		
	}
}
