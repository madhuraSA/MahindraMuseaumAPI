package com.mahindra.museum.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mahindra.museum.model.OtpRecord;



public interface OtpRecordRepository extends MongoRepository<OtpRecord,String>{

	OtpRecord findByUserMobile(String phone);
}
