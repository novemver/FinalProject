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

import com.skilldistillery.sunbeamapp.entities.Message;
import com.skilldistillery.sunbeamapp.services.MessageService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost/" })
public class MessageController {

	@Autowired
	private MessageService messageService;
	
	
	@GetMapping("messages")
	public List<Message> getListOfMessages(){
		return messageService.findAll();
	}
	
	@GetMapping("messages/{messId}")
	public Message findApptById(@PathVariable Integer messId) {
		return messageService.findMessageById(messId);
	}
	@GetMapping("users/{recieverId}/messages")
	public List<Message> getMessagesBetweenUsers(@PathVariable Integer recieverId, 
			Principal principal){
		return messageService.findMessagesBetweenUsers(principal.getName(), recieverId);
	}
	
	@PostMapping("users/{receiverId}/messages")
	public Message addMessage(@RequestBody Message message , 
			@PathVariable Integer receiverId, HttpServletResponse res,
			HttpServletRequest req, Principal principal) {
		try {
			message = messageService.createMessage(message, principal.getName(), receiverId);
			System.out.println("******************************"+ message);
			res.setStatus(201);
			StringBuffer url = req.getRequestURL();
			url.append("/").append(message.getId());
			res.setHeader("Location", url.toString());
		}catch(Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			message = null;
			
		}
		return message;
	}
	
	@PutMapping("users/{userId}/messages/{messageId}")
	public Message updateMessage(@PathVariable Integer messageId, 
			@PathVariable Integer userId,
			@RequestBody Message message, 
			HttpServletResponse res, Principal principal) {
		Message messageToUpdate = null;
		try {
			messageToUpdate = messageService.updateMessage(
					principal.getName(), messageId, message);
			if (message == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			message = null;
		}
		return message;
	}
	
	@DeleteMapping("users/messages/{messageId}")
	public void deleteMessage(@PathVariable Integer messageId, 
			HttpServletResponse res, Principal principal) {
		try { 
			if(messageService.deleteMessage(principal.getName(), messageId)) {
				res.setStatus(204);
			} else {
				res.setStatus(404);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
		
	}
	
	
}
