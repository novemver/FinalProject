package com.skilldistillery.sunbeamapp.entities;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reminder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="reminder_date")
	private LocalDate reminderDate;

	@Column(name="reminder_time")
	private LocalDate reminderTime;
	
	private String title;
	
	private String description;
	
	// TODO decide if enabled needed here
	
	///// Methods /////
	
	public Reminder() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getReminderDate() {
		return reminderDate;
	}

	public void setReminderDate(LocalDate reminderDate) {
		this.reminderDate = reminderDate;
	}

	public LocalDate getReminderTime() {
		return reminderTime;
	}

	public void setReminderTime(LocalDate reminderTime) {
		this.reminderTime = reminderTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Reminder [id=" + id + ", reminderDate=" + reminderDate + ", reminderTime=" + reminderTime + ", title="
				+ title + ", description=" + description + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reminder other = (Reminder) obj;
		return id == other.id;
	}
	
	

}
