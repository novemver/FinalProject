package com.skilldistillery.sunbeamapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.sunbeamapp.services.NoteService;

@RestController
@CrossOrigin({ "*", "http://localhost/" })
public class NoteController {

	@Autowired
	private NoteService noteService;
}
