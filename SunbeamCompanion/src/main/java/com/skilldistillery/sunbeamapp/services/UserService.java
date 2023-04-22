package com.skilldistillery.sunbeamapp.services;

import java.util.List;

import com.skilldistillery.sunbeamapp.entities.User;


public interface UserService {

	public List<User> findAll();
	public User getUserById(int userId);
	public User getByUsername(String username);
	public User updateUser(String username, User user);
	public User adminUpdateUser(int userId, User user);
	public boolean archiveUser(int userId);
	public void unarchiveUser(int userId);
}
