package com.skilldistillery.sunbeamapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.skilldistillery.sunbeamapp.entities.User;
import com.skilldistillery.sunbeamapp.repositories.UserRepository;


@Service
public class AuthoServiceImpl implements AuthService {

	@Autowired
  	private UserRepository userRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public User register(User user) {
//		String encrypted = encoder.encode(user.getPassword());
//		user.setPassword(encrypted);
//		
//		user.setEnabled(true);
//		user.setRole("standard");
 		return userRepo.saveAndFlush(user);
	}

	@Override
	public User getUserByUsername(String username) {

		return userRepo.findByUsername(username);
	}

}
