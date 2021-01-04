package com.mahindra.museum.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.joda.time.DateTime;


@Entity
public class OtpRecord {

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	//private Integer id;
	
	private String userMobile;
	
	private String otp;
	
//	@Indexed(name="otpGeneratedTimeIndex", expireAfterSeconds=900)
	private DateTime otpGeneratedTime;

//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public DateTime getOtpGeneratedTime() {
		return otpGeneratedTime;
	}

	public void setOtpGeneratedTime(DateTime otpGeneratedTime) {
		this.otpGeneratedTime = otpGeneratedTime;
	}


}
