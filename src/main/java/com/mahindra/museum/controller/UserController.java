package com.mahindra.museum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mahindra.museum.model.ResponseModel;
import com.mahindra.museum.model.UserInfo;
import com.mahindra.museum.service.UserServiceImp;



@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	UserServiceImp userServiceImp;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseModel> sampleResponse(@RequestHeader("Authorization") String authtoken) {
		return userServiceImp.getSampleResponse();
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<ResponseModel> signup(@RequestBody UserInfo userInfo){
		return userServiceImp.manualSignup(userInfo);
	}
	
	@RequestMapping(value = "/generateOTP/{phone}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseModel> generateOTP(@RequestHeader("Authorization") String authtoken,@PathVariable("phone") String phone){
		return userServiceImp.generateOTP(phone);
	}
	
	@RequestMapping(value = "/validateOtp/{phone}", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<ResponseModel> validateOTP(@RequestHeader("Authorization") String authtoken,@RequestParam("phone") String phone,@RequestParam("otp") String providedOtp){
		return userServiceImp.validateOTP(phone,providedOtp);
	}
}
