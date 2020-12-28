package com.mahindra.museum.service;

import org.springframework.http.ResponseEntity;

import com.mahindra.museum.model.ResponseModel;
import com.mahindra.museum.model.UserInfo;


public interface UserService {

	public ResponseEntity<ResponseModel> getSampleResponse();
	public ResponseEntity<ResponseModel> manualSignup(UserInfo userInfo);
	public ResponseEntity<ResponseModel> generateOTP(String phone);
	public ResponseEntity<ResponseModel> validateOTP(String phone,String otp);
}
