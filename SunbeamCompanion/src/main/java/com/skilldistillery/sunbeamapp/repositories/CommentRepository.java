package com.skilldistillery.sunbeamapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.sunbeamapp.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

	
}
