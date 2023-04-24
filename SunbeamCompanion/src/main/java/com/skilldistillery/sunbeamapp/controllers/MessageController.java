package com.skilldistillery.sunbeamapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.sunbeamapp.entities.Appointment;
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
	@GetMapping("users/{userId}/messages")
	public List<Message> getMessagesBetweenUsers(){
		return messageService.findMessagesBetweenUsers();
	}
}
