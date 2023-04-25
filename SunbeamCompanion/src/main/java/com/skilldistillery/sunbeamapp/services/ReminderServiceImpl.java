package com.skilldistillery.sunbeamapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.sunbeamapp.entities.Medication;
import com.skilldistillery.sunbeamapp.entities.Reminder;
import com.skilldistillery.sunbeamapp.entities.User;
import com.skilldistillery.sunbeamapp.repositories.ReminderRepository;
import com.skilldistillery.sunbeamapp.repositories.UserRepository;

@Service
public class ReminderServiceImpl implements ReminderService {

	@Autowired
	private ReminderRepository reminderRepo;

	@Autowired
	private UserRepository userRepo;

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
	public Reminder addReminder(String username, Reminder reminder) {
		User loggedInUser = userRepo.findByUsername(username);
		if (loggedInUser != null) {
			return reminderRepo.saveAndFlush(reminder);
		}
		return null;
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

	@Override
	public boolean deleteReminder(String username, int remId) {
		boolean deleted = false;
		Reminder toDelete = reminderRepo.findById(remId);
		if (toDelete != null) {
			reminderRepo.delete(toDelete);
			deleted = true;
		}
		return deleted;
	}

}