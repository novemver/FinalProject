package com.skilldistillery.sunbeamapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.sunbeamapp.entities.Comment;
import com.skilldistillery.sunbeamapp.entities.User;
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
	public Comment findById(int comId) {
		Comment seeComment = comRepo.findById(comId);
		return seeComment;
	}

	@Override
	public Comment findByIdandUsername(String username, int comId) {
		Comment seeComment = comRepo.findByIdAndUser_Username(username, comId);
		return seeComment;
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
		User loggedInUser = userRepo.findByUsername(username);
		Comment existingComment = comRepo.findById(comId);
		if (loggedInUser != null) {
			existingComment.setTitle(comment.getTitle());
			existingComment.setDescription(comment.getDescription());
			return comRepo.saveAndFlush(existingComment);
		}
		return existingComment;
	}

//	@Override
//	public boolean delete(int comId) {
//		boolean deleted = false;
//		Comment existingComment = comRepo.findById(comId);
//		if (existingComment != null) {
//			comRepo.delete(existingComment);
//			deleted = true;
//		}
//		System.out.println("comment deleted");
//		return deleted;
//	}
	    @Override
	    public boolean delete(String username, int comId) {
	    	boolean deleted = false;
	    	User loggedInUser = userRepo.findByUsername(username);
	    	Comment existingComment = comRepo.findById(comId);
	    	if (loggedInUser != null) {
	    		comRepo.delete(existingComment);
	    		deleted =  true;
	    	}
	    	System.out.println("comment deleted");
	    	return deleted;
	    }

//	    @Override
//	    public List<Comment> findByUserUsername(String username) {
//	        return comRepo.findByUsername(username);
//	    }

}
