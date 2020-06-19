package com.naresh.userslogin.serviceimpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naresh.userslogin.model.request.UserDetailsRequest;
import com.naresh.userslogin.model.response.UserDetailsResponse;
import com.naresh.userslogin.service.UserService;
import com.naresh.userslogin.shared.Utils;

@Service
public class UserServiceImpl implements UserService {

	Map<String, UserDetailsResponse> users;
	Utils utils;
	
	public UserServiceImpl() {
		
	}
	
	@Autowired
	public UserServiceImpl(Utils utils) {
		this.utils =utils;
	}
	@Override
	public UserDetailsResponse createUser(UserDetailsRequest request) {
		
		UserDetailsResponse response = new UserDetailsResponse();
		
		response.setEmail(request.getEmail());
		response.setFirstName(request.getFirstName());
		response.setLastName(request.getLastName());

		String userId = utils.generateUserId();
		System.out.println(userId);
		response.setUserId(userId);
		
		if(users == null) users = new HashMap<String, UserDetailsResponse>();
		users.put(userId, response);
		return response;
	}

}
