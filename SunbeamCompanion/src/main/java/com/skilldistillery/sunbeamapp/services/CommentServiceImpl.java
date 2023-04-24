package com.skilldistillery.sunbeamapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.sunbeamapp.entities.Comment;
import com.skilldistillery.sunbeamapp.repositories.CommentRepository;
import com.skilldistillery.sunbeamapp.repositories.ElderRepository;
import com.skilldistillery.sunbeamapp.repositories.UserRepository;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository comRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private ElderRepository elderRepo;
	
//	   @Override
//	    public Comment findById(String username, int comId) {
//	        return comRepo.findById(comId).orElse(null);
//	    }
	@Override
	public Comment findById(String username, int comId) {
	    Comment comment = comRepo.findByIdAndUser_Username(comId, username);
	    return comment;
	}

	    @Override
	    public List<Comment> findAll(String username, int elderId) {
	        return comRepo.findByUser_UsernameAndElder_Id(username, elderId);
	    }

	    @Override
	    public Comment create(String username, Comment comment) {
	        return comRepo.save(comment);
	    }

	    @Override
	    public Comment update(String username, int comId, Comment comment) {
	        Comment existingComment = findById(username, comId);
	    	if (existingComment != null) {
				existingComment.setTitle(comment.getTitle());
				existingComment.setDescription(comment.getDescription());
				return comRepo.saveAndFlush(existingComment);
			}
	        return null;
	    }

	    @Override
	    public boolean delete(String username, int comId) {
	        Comment existingComment = findById(username, comId);
	        if (existingComment != null) {
	        	comRepo.delete(existingComment);
	            return true;
	        }
	        return false;
	    }

//	    @Override
//	    public List<Comment> findByUserUsername(String username) {
//	        return comRepo.findByUsername(username);
//	    }


}
