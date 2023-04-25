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

import com.skilldistillery.sunbeamapp.entities.Elder;
import com.skilldistillery.sunbeamapp.entities.Medication;
import com.skilldistillery.sunbeamapp.entities.Reminder;
import com.skilldistillery.sunbeamapp.services.ReminderService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost/" })
public class ReminderController {

	@Autowired
	private ReminderService reminderService;

	@GetMapping("reminders")
	public List<Reminder> getListOfReminder() {

		return reminderService.findAllReminder();
	}

	@GetMapping("reminders/{reminderId}")
	public Reminder findReminderById(@PathVariable int reminderId, HttpServletResponse res) {
		return reminderService.getById(reminderId);
	}

	@PostMapping("reminders")
	public Reminder addReminder(@RequestBody Reminder reminder, HttpServletResponse res, Principal principal) {
		Reminder newRem = null;
		try {
			newRem = reminderService.addReminder(principal.getName(), reminder);
			res.setStatus(201);
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
		return newRem;
	}

	@PutMapping("reminders")
	public Reminder updateReminder(@RequestBody Reminder reminder, HttpServletRequest req, HttpServletResponse res,
			Principal principal) {
		try {
//			principal allows us to verify that the user is updating themselves
			reminder = reminderService.updateReminder(principal.getName(), reminder);
			if (reminder == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			reminder = null;
		}
		return reminder;
	}
	
	@DeleteMapping("reminders/{remId}")
	public void destroy(HttpServletResponse res, @PathVariable int remId, Principal principal) {

		try {
			if (reminderService.deleteReminder(principal.getName(), remId)) {                                                                                         
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
