package com.skilldistillery.sunbeamapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.sunbeamapp.entities.Reminder;
import com.skilldistillery.sunbeamapp.repositories.ReminderRepository;

@Service
public class ReminderServiceImpl implements ReminderService {

	@Autowired
	private ReminderRepository reminderRepo;

	@Override
	public List<Reminder> findAllReminder() {
		// TODO Auto-generated method stub
		return reminderRepo.findAll();
	}

	@Override
	public Reminder getById(int reminderId) {
		// TODO Auto-generated method stub
		return reminderRepo.findById(reminderId);
	}

	@Override
	public Reminder updateReminder(String title, Reminder reminder) {
		Reminder existingReminder = reminderRepo.findByTitle(title);
		if (existingReminder != null) {
			existingReminder.setReminderDate(reminder.getReminderDate());
			existingReminder.setReminderTime(reminder.getReminderTime());
			existingReminder.setTitle(reminder.getTitle());
			existingReminder.setDescription(reminder.getDescription());
			existingReminder.setApptReminder(reminder.getApptReminder());
			return reminderRepo.saveAndFlush(existingReminder);

		}
		return null;
	}

	

	
}