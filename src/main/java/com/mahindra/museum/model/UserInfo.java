package com.mahindra.museum.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
//@EntityListeners(AuditingEntityListener.class)
public class UserInfo {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private long id;

	@Column(name = "email_id", unique = true)
	private String emailId;

	private String password;

	// @JsonProperty("name")
	private String name = null;

	@JsonProperty("phone")
	private String phone = null;

	private String gender = null;

	private int age = 0;

	private String occupation = null;

	private String organization = null;

	private Boolean active = Boolean.FALSE;

	private String authToken = null;
	/*
	 * private DateTime loginTimeStamp = null;
	 * 
	 * private DateTime logoutTimeStamp = null;
	 * 
	 * private DateTime createdOn = null;
	 */
//	private Blob userImage;


	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	/*
	 * public DateTime getLoginTimeStamp() { return loginTimeStamp; }
	 * 
	 * public void setLoginTimeStamp(DateTime loginTimeStamp) { this.loginTimeStamp
	 * = loginTimeStamp; }
	 * 
	 * public DateTime getLogoutTimeStamp() { return logoutTimeStamp; }
	 * 
	 * public void setLogoutTimeStamp(DateTime logoutTimeStamp) {
	 * this.logoutTimeStamp = logoutTimeStamp; }
	 * 
	 * public DateTime getCreatedOn() { return createdOn; }
	 * 
	 * public void setCreatedOn(DateTime createdOn) { this.createdOn = createdOn; }
	 * 
	 */

}
