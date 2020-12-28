package com.mahindra.museum.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mahindra.museum.model.ResponseModel;

@Service
public class UserServiceImp implements UserService {

	@Override
	public ResponseEntity<ResponseModel> getSampleResponse() {
		
		ResponseModel response = new ResponseModel();
		response.setResponseCode(HttpStatus.OK.toString());
		response.setResponseDescription("Response generated successfully");
		response.setResponseObject("Hello World");
		
		return new ResponseEntity<ResponseModel>(response, HttpStatus.OK);
		
	}

}
