package com.mahindra.museum.model;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class OtpRecord {


	
	@Id
	private String userMobile;
	
	private String otp;
	
	@Indexed(name="otpGeneratedTimeIndex", expireAfterSeconds=900)
	private DateTime otpGeneratedTime;

	public String getUserMobile() {
		return userMobile;
	}

	public OtpRecord userMobile(String userMobile) {
		this.userMobile = userMobile;
		return this;
	}

	public String getOtp() {
		return otp;
	}

	public OtpRecord otp(String otp) {
		this.otp = otp;
		return this;
	}

	public DateTime getOtpGeneratedTime() {
		return otpGeneratedTime;
	}

	public OtpRecord otpGeneratedTime(DateTime otpGeneratedTime) {
		this.otpGeneratedTime = otpGeneratedTime;
		return this;
	}
	
	


}
