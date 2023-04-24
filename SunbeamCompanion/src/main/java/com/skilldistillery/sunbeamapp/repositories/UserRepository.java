package com.skilldistillery.sunbeamapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.sunbeamapp.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsername(String username);

	User findById(int id);

//	User findUserByUserComment(User userComment);

}
