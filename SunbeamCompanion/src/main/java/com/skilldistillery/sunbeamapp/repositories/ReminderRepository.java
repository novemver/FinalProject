package com.skilldistillery.sunbeamapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.sunbeamapp.entities.Reminder;

public interface ReminderRepository extends JpaRepository<Reminder, Integer>{

}
