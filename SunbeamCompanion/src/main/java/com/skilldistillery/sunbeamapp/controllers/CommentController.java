package com.skilldistillery.sunbeamapp.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.sunbeamapp.entities.Comment;
import com.skilldistillery.sunbeamapp.services.CommentService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost/" })
public class CommentController {

	@Autowired
	private CommentService comService;
	
	@GetMapping("comment/{comId}")
	public Comment show(Principal principal, HttpServletRequest req, HttpServletResponse res, @PathVariable int comId) {
		Comment seeComment = comService.findById(principal.getName(), comId);
		if (seeComment == null) {
			res.setStatus(404);
		}
		return seeComment;
	}
	
	@GetMapping("comment/elder/{elderId}")
	public List<Comment> index(Principal principal, HttpServletRequest req, HttpServletResponse res, @PathVariable int elderId) {

		return comService.findAll(principal.getName(), elderId);
	}
	
	@PostMapping("comment")
	public Comment create(Principal principal, HttpServletRequest req, HttpServletResponse res, @RequestBody Comment comment) {
		try {
			comment = comService.create(principal.getName(), comment);
			if (comment != null) {
				res.setStatus(201);
				StringBuffer url = req.getRequestURL();
				res.setHeader("Location", url.append("/").append(comment.getId()).toString());
			} else {
				res.setStatus(400);
			}

			return comment;
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			return comment;
		}
	}
	
	@PutMapping("comment/{comId}")
	public Comment update(Principal principal, HttpServletRequest req, HttpServletResponse res, @PathVariable int comId, @RequestBody Comment comment) {
		Comment updateToUpdate = null;
		try {
			updateToUpdate = comService.update(principal.getName(), comId, comment);
			if (updateToUpdate == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			updateToUpdate = null;
		}
		return updateToUpdate;
	}

	@DeleteMapping("comment/{comId}")
	public void destroy(Principal principal, HttpServletRequest req, HttpServletResponse res, @PathVariable int comId) {

		try {
			if (comService.delete(principal.getName(), comId)) {
				res.setStatus(204);
			} else {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}

	}
	
}
