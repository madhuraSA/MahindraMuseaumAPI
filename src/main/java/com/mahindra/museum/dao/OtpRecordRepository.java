package com.mahindra.museum.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.Query;

import com.mahindra.museum.model.OtpRecord;



public interface OtpRecordRepository extends JpaRepository<OtpRecord,String>{

	@Query("select p from OtpRecord where p.userMobile = ?1 ")
	OtpRecord findByUserMobile(String phone);
}
