package com.mahindra.museum.model;


import java.sql.Blob;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.mahindra.museum.utils.MyDateTimeDeserializer;

@Document
public class UserInfo {

	@Id
	@JsonProperty("emailId")
	private String emailId;
	
	@JsonProperty("password")
	private String password;
	
	@JsonProperty("name")
	private String name = null;
	
	@JsonProperty("phone")
	private String phone= null;

	@JsonProperty("gender")
	private String gender = null;
	
	@JsonProperty("age")
	private int age = 0;

	@JsonProperty("occupation")
	private String occupation = null;

	@JsonProperty("organization")
	private String organization = null;

	@JsonProperty("active")
	private Boolean active = Boolean.FALSE; 

	private String authToken = null;
//	private Blob userImage;

	@JsonDeserialize(using = MyDateTimeDeserializer.class)
	private DateTime  loginTimeStamp = null;

	@JsonDeserialize(using = MyDateTimeDeserializer.class)
	private DateTime logoutTimeStamp = null;

	@JsonDeserialize(using = MyDateTimeDeserializer.class)
	private DateTime createdOn = null;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

//	public Blob getUserImage() {
//		return userImage;
//	}
//
//	public void setUserImage(Blob userImage) {
//		this.userImage = userImage;
//	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public DateTime getLoginTimeStamp() {
		return loginTimeStamp;
	}

	public void setLoginTimeStamp(DateTime loginTimeStamp) {
		this.loginTimeStamp = loginTimeStamp;
	}

	public DateTime getLogoutTimeStamp() {
		return logoutTimeStamp;
	}

	public void setLogoutTimeStamp(DateTime logoutTimeStamp) {
		this.logoutTimeStamp = logoutTimeStamp;
	}

	public DateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(DateTime createdOn) {
		this.createdOn = createdOn;
	}
	
	
	
}
