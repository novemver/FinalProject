package com.skilldistillery.sunbeamapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.sunbeamapp.services.MessageService;

@RestController
@CrossOrigin({ "*", "http://localhost/" })
public class MessageController {

	@Autowired
	private MessageService messageService;
}
