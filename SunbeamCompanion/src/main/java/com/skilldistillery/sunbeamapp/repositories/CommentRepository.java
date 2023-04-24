package com.skilldistillery.sunbeamapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.sunbeamapp.entities.Comment;
import com.skilldistillery.sunbeamapp.entities.User;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

	Comment findByIdAndUser_Username(String username, int comId);
	Comment findById(int comId);
	
//	Comment findCommentByUsername(String username);
	
	Comment findCommentById(int comId);
	
//	Comment findByUserComment(User userComment);
	
	List<Comment> findByUser_UsernameAndElder_Id(String username, int elderId);

//	Comment findByIdAndUserUsername(int comId, User username);
	
	
}
