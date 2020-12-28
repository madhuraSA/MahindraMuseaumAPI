package com.mahindra.museum.configuration;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mahindra.museum.model.ResponseModel;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

//	private static final long serialVersionUID = -7858869558953243875L;
//	@Override
//	public void commence(HttpServletRequest request, HttpServletResponse response,
//	AuthenticationException authException) throws IOException {
//	ResponseModel resp = new ResponseModel();
//	resp.setResponseDescription("Unauthorized");
//	resp.setResponseCode(HttpStatus.UNAUTHORIZED.toString());
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {

		ResponseModel res = new ResponseModel();
/*
		String userStatus = (String) request.getAttribute("userStatus");

		if ("Inactive".equals(userStatus)) {
			res.setResponseCode("403");
			res.setResponseDescription("User is not Active User");
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		} else {
			res.setResponseCode("401");
			res.setResponseDescription("Authorization error");
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		}
*/		
		res.setResponseCode("401");
		res.setResponseDescription("Authorization error");
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		
		response.setContentType("application/json");
		final ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(response.getOutputStream(), res);

	}

}
