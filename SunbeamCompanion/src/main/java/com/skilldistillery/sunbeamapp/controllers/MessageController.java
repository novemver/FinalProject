package com.skilldistillery.sunbeamapp.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping("users/messages/{receiverId}")
	public Message addMessage(@RequestBody Message message , 
			@PathVariable Integer recieverId, HttpServletResponse res,
			HttpServletRequest req, Principal principal) {
		try {
			message = messageService.createMessage(message, principal.getName(), recieverId);
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
}
