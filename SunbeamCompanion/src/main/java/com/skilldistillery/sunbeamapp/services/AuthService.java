package com.skilldistillery.sunbeamapp.services;

import com.skilldistillery.sunbeamapp.entities.User;

public interface AuthService {
	
	public User register(User user);
	public User getUserByUsername(String username);

}
