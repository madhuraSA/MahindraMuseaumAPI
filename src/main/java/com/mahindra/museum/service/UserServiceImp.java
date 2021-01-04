package com.mahindra.museum.service;

import java.security.SecureRandom;
import java.util.Optional;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.mahindra.museum.configuration.JwtTokenUtil;
import com.mahindra.museum.dao.OtpRecordRepository;
import com.mahindra.museum.dao.UserInfoRepository;
import com.mahindra.museum.model.OtpRecord;
import com.mahindra.museum.model.ResponseModel;
import com.mahindra.museum.model.UserInfo;
import com.mahindra.museum.utility.Utility;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	UserInfoRepository userInfoRepo;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@Autowired
	private OtpRecordRepository otpRecordRepository;

	@Override
	public ResponseEntity<ResponseModel> getSampleResponse() {

		ResponseModel response = new ResponseModel();
		response.setResponseCode(HttpStatus.OK.toString());
		response.setResponseDescription("Response generated successfully");
		response.setResponseObject("Hello World");

		return new ResponseEntity<ResponseModel>(response, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<ResponseModel> manualSignup(UserInfo userInfo) {
		ResponseModel response = new ResponseModel();

		// -- Duplicate EmailId
		Optional<UserInfo> user = userInfoRepo.findById(userInfo.getEmailId());
		if (user.isPresent()) {
			response.setResponseCode(HttpStatus.ALREADY_REPORTED.toString());
			response.setResponseDescription("User with emailId : " + userInfo.getEmailId() + " already exists.");
			return new ResponseEntity<ResponseModel>(response, HttpStatus.ALREADY_REPORTED);
		}
		// -- Duplicate phoneNum
		UserInfo user1 = userInfoRepo.findByEmailId(userInfo.getEmailId());
		if (user1 != null) {
			response.setResponseCode(HttpStatus.ALREADY_REPORTED.toString());
			response.setResponseDescription("USer with phone Number : " + userInfo.getPhone() + " already exists.");
			return new ResponseEntity<ResponseModel>(response, HttpStatus.ALREADY_REPORTED);
		}

		userInfoRepo.save(userInfo);
		generateJWTToken(userInfo);
		response.setResponseCode(HttpStatus.OK.toString());
		response.setResponseDescription("User Registered successfully");
		response.setResponseObject(userInfo);
		return new ResponseEntity<ResponseModel>(response, HttpStatus.OK);
	}

	// -- Generate Auth token
	public UserInfo generateJWTToken(UserInfo user) {
		final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmailId());
		final String token = jwtTokenUtil.generateToken(userDetails);
		user.setAuthToken(token);
		return user;

	}

	@Override
	public ResponseEntity<ResponseModel> generateOTP(String phone) {
		ResponseModel response = new ResponseModel();
		UserInfo user = userInfoRepo.findByPhone(phone);
		if (user != null) {

			// -- Generate 4 digit random number;
			SecureRandom random = new SecureRandom();
			String otp = String.format("%04d", random.nextInt(10000));

			OtpRecord otpRecord = new OtpRecord();
			otpRecord.setUserMobile(phone);
			otpRecord.setOtp(otp);

			otpRecordRepository.save(otpRecord);
			response.setResponseObject(otpRecord);
			response.setResponseCode(HttpStatus.OK.toString());
			response.setResponseDescription("OTP generated successfully");
			return new ResponseEntity<ResponseModel>(response, HttpStatus.OK);
		} else {
			response.setResponseCode(HttpStatus.NOT_FOUND.toString());
			response.setResponseDescription("Mobile number not found");
			return new ResponseEntity<ResponseModel>(response, HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<ResponseModel> validateOTP(String phone, String providedOtp) {
		ResponseModel response = new ResponseModel();
		// -- Check whether user exists with given mobile num

		UserInfo user = userInfoRepo.findByPhone(phone);
		if (user != null) {
			OtpRecord otpRecord = otpRecordRepository.findByUserMobile(phone);
			if (otpRecord != null) {
				String serverOtp = otpRecord.getOtp();
				if ((serverOtp != null) && (providedOtp.equals(serverOtp))) {
					// otpService.clearOTP(userMobile);
					otpRecordRepository.deleteById(phone);
					DateTime loginTime = Utility.getDateWithoutZone(new DateTime()).plusMinutes(330);
			//		user.setLoginTimeStamp(loginTime);
					// user.setLoginTimeStamp(Utility.getDateWithoutZone(new DateTime()));
			//		user.setLogoutTimeStamp(null);
					// -- Make user active once otp is successfully validated
					user.setActive(Boolean.TRUE);
					userInfoRepo.save(user);
					response.setResponseDescription("Entered Otp is valid! Login Successful.");
					response.setResponseCode(HttpStatus.OK.toString());
					return new ResponseEntity<ResponseModel>(response, HttpStatus.OK);
				}
			}
		}

		response.setResponseCode(HttpStatus.FORBIDDEN.toString());
		response.setResponseDescription("User not registered.");
		return new ResponseEntity<ResponseModel>(response, HttpStatus.FORBIDDEN);
	}
}
