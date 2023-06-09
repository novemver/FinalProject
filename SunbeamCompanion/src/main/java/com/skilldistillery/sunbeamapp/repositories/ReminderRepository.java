package com.skilldistillery.sunbeamapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skilldistillery.sunbeamapp.entities.Reminder;

public interface ReminderRepository extends JpaRepository<Reminder, Integer>{

	Reminder findById(int reminderId);
	
	Reminder findByTitle(String title);
	
}
