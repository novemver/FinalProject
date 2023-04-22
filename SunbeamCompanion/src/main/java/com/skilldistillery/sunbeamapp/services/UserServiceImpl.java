package com.skilldistillery.sunbeamapp.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.sunbeamapp.entities.User;
import com.skilldistillery.sunbeamapp.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
//	list users 

	@Override
	public List<User> findAll() {

		return userRepo.findAll();
	}

//	find a user by id
	@Override
	public User getUserById(int userId) {
		return userRepo.findById(userId);
	}



//	update user 
	@Override
	public User updateUser(String username, User user) {
		User existingUser = userRepo.findByUsername(username);
		if(existingUser != null) {
			existingUser.setEmail(user.getEmail());
			existingUser.setPhoneNumber(user.getPhoneNumber());
			existingUser.setFirstName(user.getFirstName());
			existingUser.setLastName(user.getLastName());
			existingUser.setImageUrl(user.getImageUrl());
			existingUser.setUserBio(user.getUserBio());
			return userRepo.saveAndFlush(existingUser);
			
		}
		return null;
	}
//	admin updates user 
	@Override
	public User adminUpdateUser(int userId, User user) {
		User existingUser = userRepo.findById(userId);
		if(existingUser != null) {
			existingUser.setEmail(user.getEmail());
			existingUser.setPhoneNumber(user.getPhoneNumber());
			existingUser.setFirstName(user.getFirstName());
			existingUser.setLastName(user.getLastName());
			existingUser.setImageUrl(user.getImageUrl());
			existingUser.setUserBio(user.getUserBio());
			
			return userRepo.saveAndFlush(existingUser);
			
		}
		return null;
	}

//	archive user - enabled
	@Override
	public boolean archiveUser(int userId) {
		
		User userToBeArchived = userRepo.findById(userId);
		if (userToBeArchived != null) {
			userToBeArchived.setEnabled(false);
			userRepo.saveAndFlush(userToBeArchived);
		}
		return userToBeArchived.isEnabled();
		
	}
//	archive user - enabled
	@Override
	public boolean unarchiveUser(int userId) {
		boolean unarchived = true;
		User userToUnArchived = userRepo.findById(userId);
		if (userToUnArchived != null) {
			userToUnArchived.setEnabled(unarchived);
			userRepo.saveAndFlush(userToUnArchived);
		}
		return userToUnArchived.isEnabled();
	
	}

//	
	@Override
	public User getByUsername(String username) {
		return userRepo.findByUsername(username);
	}

}
