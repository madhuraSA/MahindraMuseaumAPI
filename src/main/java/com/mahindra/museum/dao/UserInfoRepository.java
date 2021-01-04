package com.mahindra.museum.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.Query;

import com.mahindra.museum.model.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, String>{

	@Query("select u from User u where u.email = ?1" )
	UserInfo findByEmailId(String emailId);
	
	@Query("select u from User u where u.phone = ?1 ")
	UserInfo findByPhone(String phone);
	
	
}
