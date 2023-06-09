package com.skilldistillery.sunbeamapp.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String description;

	@Column(name = "appointment_date")
	private LocalDate apptDate;

	@Column(name = "appointment_time")
	private LocalTime apptTime;

	private String title;

	@CreationTimestamp
	@Column(name = "create_date")
	private LocalDate createDate;

	@UpdateTimestamp
	@Column(name = "update_date")
	private LocalDate updateDate;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User userAppointments;

	@ManyToOne
	@JoinColumn(name = "elder_id")
	private Elder elderAppointments;
	
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@ManyToOne
	@JoinColumn(name = "location_id")
	private Location location;
	
	@JsonIgnoreProperties({"apptReminder"})
	@OneToMany(mappedBy = "apptReminder")
	private List<Reminder> reminders;
	///// Methods /////

	
	public Appointment() {
		super();
	}
 
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public List<Reminder> getReminders() {
		return reminders;
	}

	public void setReminders(List<Reminder> reminders) {
		this.reminders = reminders;
	}

	public LocalDate getApptDate() {
		return apptDate;
	}

	public void setApptDate(LocalDate apptDate) {
		this.apptDate = apptDate;
	}

	public LocalTime getApptTime() {
		return apptTime;
	}

	public void setApptTime(LocalTime apptTime) {
		this.apptTime = apptTime;
	}


	public Elder getElderAppointments() {
		return elderAppointments;
	}

	public void setElderAppointments(Elder elderAppointments) {
		this.elderAppointments = elderAppointments;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public User getUserAppointments() {
		return userAppointments;
	}

	public void setUserAppointments(User userAppointments) {
		this.userAppointments = userAppointments;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public LocalDate getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDate updateDate) {
		this.updateDate = updateDate;
	}

	


	@Override
	public String toString() {
		return "Appointment [id=" + id + ", description=" + description + ", apptDate=" + apptDate + ", apptTime="
				+ apptTime + ", title=" + title + ", createDate=" + createDate + ", updateDate=" + updateDate
				+ "]";
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
		Appointment other = (Appointment) obj;
		return id == other.id;
	}

}
