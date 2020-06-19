package com.naresh.userslogin.service;

import com.naresh.userslogin.model.request.UserDetailsRequest;
import com.naresh.userslogin.model.response.UserDetailsResponse;

public interface UserService {

	UserDetailsResponse createUser(UserDetailsRequest request);
		
}
