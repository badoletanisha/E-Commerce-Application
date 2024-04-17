package com.retail.ECommerceApplication.service;

import org.springframework.http.ResponseEntity;

import com.retail.ECommerceApplication.requestdto.OtpRequest;
import com.retail.ECommerceApplication.requestdto.UserRequest;
import com.retail.ECommerceApplication.responsedto.UserResponse;
import com.retail.ECommerceApplication.utility.ResponseStructure;
import com.retail.ECommerceApplication.utility.SimpleResponseStructure;

public interface UserService {

	ResponseEntity<SimpleResponseStructure> userRegistration(UserRequest userReqeust);

	ResponseEntity<ResponseStructure<UserResponse>> verifyOTP(OtpRequest otpRequest);

}
