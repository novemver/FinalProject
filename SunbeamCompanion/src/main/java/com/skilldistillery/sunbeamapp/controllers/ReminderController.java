package com.skilldistillery.sunbeamapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.sunbeamapp.services.ReminderService;

@RestController
@CrossOrigin({ "*", "http://localhost/" })
public class ReminderController {

	@Autowired
	private ReminderService reminderService;
}
