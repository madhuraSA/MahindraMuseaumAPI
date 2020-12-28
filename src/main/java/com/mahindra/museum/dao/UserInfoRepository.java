package com.mahindra.museum.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.mahindra.museum.model.UserInfo;

public interface UserInfoRepository extends MongoRepository<UserInfo, String>{

	@Query(" { 'emailId' : ?0 } " )
	UserInfo findByEmailId(String emailId);
	
	@Query("{ 'phone' : ?0  }")
	UserInfo findByPhoneNum(String phone);
	
	
}
