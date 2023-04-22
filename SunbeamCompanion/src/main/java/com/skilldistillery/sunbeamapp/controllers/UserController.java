package com.skilldistillery.sunbeamapp.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.sunbeamapp.entities.User;
import com.skilldistillery.sunbeamapp.services.UserService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost/" })
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("users")
	public List<User> getListOfUser(){
		
		return userService.findAll();
	}
	
	@GetMapping("users/{userId}")
	public User findUserById(@PathVariable int userId, HttpServletResponse res ) {
		return userService.getUserById(userId);
	}
//	LOGGED IN USER 
	@PutMapping("users")
	public User updateUser(@RequestBody User user, HttpServletRequest req,
			HttpServletResponse res, Principal principal) {
		try {
//			principal allows us to verify that the user is updating themselves
			user =	userService.updateUser(principal.getName(), user);
			if 	(user == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			user = null;
		}
		return	user;
	}
//	ADMIN
	@PutMapping("users/admin/{userId}")
	public User adminUpdateUser(@RequestBody User user, @PathVariable int userId, HttpServletRequest req,
			HttpServletResponse res) {
		try {
//principal allows us to verify that the user is updating themselves
			user =	userService.adminUpdateUser(userId, user);
			if 	(user == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			user = null;
		}
		return	user;
	}
	
	@DeleteMapping("users/admin/{userId}")
	public User archiveUser(@PathVariable int userId, HttpServletResponse res) {
			User archived = userService.getUserById(userId);
			if(userService.archiveUser(userId)) {
				res.setStatus(200);
			} else {
				res.setStatus(404);
			}
			return archived;
		}
	
	@PatchMapping("users/admin/{userId}")
	public User unarchiveUser(@PathVariable int userId, HttpServletResponse res) {
		User unArchive = userService.getUserById(userId);
		if(userService.unarchiveUser(userId)) {
			res.setStatus(200);
		} else {
			res.setStatus(404);
		}
		return unArchive;
	    
	}

		
}
