package com.mahindra.museum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mahindra.museum.model.ResponseModel;
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
	
}
