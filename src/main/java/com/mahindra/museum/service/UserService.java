package com.mahindra.museum.service;

import org.springframework.http.ResponseEntity;

import com.mahindra.museum.model.ResponseModel;


public interface UserService {

	public ResponseEntity<ResponseModel> getSampleResponse();
}
