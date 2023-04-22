package com.skilldistillery.sunbeamapp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.sunbeamapp.entities.Reminder;
import com.skilldistillery.sunbeamapp.entities.User;


public interface ReminderService {
	public List<Reminder> findAllReminder();

	public Reminder getById(int reminderId);

	public Reminder updateReminder(String title, Reminder reminder);
}
