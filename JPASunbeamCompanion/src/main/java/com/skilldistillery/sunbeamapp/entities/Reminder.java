package com.skilldistillery.sunbeamapp.entities;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Reminder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="reminder_date")
	private LocalDateTime reminderDate;

	@Column(name="reminder_time")
	private LocalTime reminderTime;
	
	private String title;
	
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "appointment_id")
	private Appointment apptReminder;
	
	@JsonIgnore
	@ManyToMany
	  @JoinTable(name="user_has_reminder",
	    joinColumns=@JoinColumn(name="user_id"),
	    inverseJoinColumns=@JoinColumn(name="reminder_id")
	  )
	  private List<User> userReminders;
	
	
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

	public LocalDateTime getReminderDate() {
		return reminderDate;
	}

	public void setReminderDate(LocalDateTime reminderDate) {
		this.reminderDate = reminderDate;
	}

	public LocalTime getReminderTime() {
		return reminderTime;
	}

	public void setReminderTime(LocalTime reminderTime) {
		this.reminderTime = reminderTime;
	}

	public Appointment getApptReminder() {
		return apptReminder;
	}

	public void setApptReminder(Appointment apptReminder) {
		this.apptReminder = apptReminder;
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

	public List<User> getUserReminders() {
		return userReminders;
	}

	public void setUserReminders(List<User> userReminders) {
		this.userReminders = userReminders;
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
