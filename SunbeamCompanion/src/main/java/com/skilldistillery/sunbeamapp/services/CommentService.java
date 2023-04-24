package com.skilldistillery.sunbeamapp.services;

import java.util.List;

import com.skilldistillery.sunbeamapp.entities.Comment;
import com.skilldistillery.sunbeamapp.entities.User;

public interface CommentService {

	  Comment findById( int comId);
	  Comment findByIdandUsername(String username, int comId);

	    List<Comment> findAll(String username, int elderId);

	    Comment create(String username, Comment comment);

	    Comment update(String username, int comId, Comment comment);

	    boolean delete(String username, int comId);

//	    List<Comment> findByUserUsername(String username);

}
