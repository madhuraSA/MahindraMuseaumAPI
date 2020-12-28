package com.mahindra.museum.model;

public class ResponseModel {
	


private String responseCode;
	
	private String responseDescription;
	
	private Object responseObject;
	
	public ResponseModel(String responseCode,String responseDescription,Object responseObject) {
		this.responseCode=responseCode;
		this.responseDescription=responseDescription;
		this.responseObject=responseObject;
	}
	
	public ResponseModel(String responseCode, String responseDescription) {
		this.responseCode=responseCode;
		this.responseDescription=responseDescription;
	}
	
	public ResponseModel() {
		// TODO Auto-generated constructor stub
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseDescription() {
		return responseDescription;
	}

	public void setResponseDescription(String responseDescription) {
		this.responseDescription = responseDescription;
	}

	public Object getResponseObject() {
		return responseObject;
	}

	public void setResponseObject(Object responseObject) {
		this.responseObject = responseObject;
	}

	


}
