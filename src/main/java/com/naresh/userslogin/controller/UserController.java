package com.naresh.userslogin.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.naresh.userslogin.exceptions.UserServiceException;
import com.naresh.userslogin.model.request.UserDetailsRequest;
import com.naresh.userslogin.model.response.UserDetailsResponse;
import com.naresh.userslogin.service.UserService;
import com.naresh.userslogin.serviceimpl.UserServiceImpl;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userservice;
	
	Map<String, UserDetailsResponse> users;
	@GetMapping
	public String getUser(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "20") int limit,
			@RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {

		return "getUser called.." + page + "and limit::" + limit + "sort::" + sort;
	}

	@GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserDetailsResponse> getUser(@PathVariable String userId) {

		if(true) throw new UserServiceException("A userservice exception thrown");
		
		if(users.containsKey(userId)) {
			return new ResponseEntity<>(users.get(userId),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserDetailsResponse> createUser(@Valid @RequestBody UserDetailsRequest request) {

		UserDetailsResponse response = userservice.createUser(request);
		return new ResponseEntity<UserDetailsResponse>(response, HttpStatus.OK);
	}

	@PutMapping
	public String updateUser() {

		return "update User called";
	}

	@DeleteMapping(path="/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable String id) {

		users.remove(id);
		return ResponseEntity.noContent().build();
	}
}
