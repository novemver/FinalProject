package com.skilldistillery.sunbeamapp.entities;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String description;

	@Column(name = "appointment_date")
	private LocalDate apptDate;

	@Column(name = "appointment_time")
	private LocalDate apptTime;

	private String title;

	@Column(name = "create_date")
	private LocalDate createDate;

	@Column(name = "update_date")
	private LocalDate updateDate;

	private boolean enabled;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User userAppointments;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private Elder clientsAppointments;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	///// Methods /////

	public Appointment() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public LocalDate getApptDate() {
		return apptDate;
	}

	public void setApptDate(LocalDate apptDate) {
		this.apptDate = apptDate;
	}

	public LocalDate getApptTime() {
		return apptTime;
	}

	public void setApptTime(LocalDate apptTime) {
		this.apptTime = apptTime;
	}

	public Elder getClientsAppointments() {
		return clientsAppointments;
	}

	public void setClientsAppointments(Elder clientsAppointments) {
		this.clientsAppointments = clientsAppointments;
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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", description=" + description + ", apptDate=" + apptDate + ", apptTime="
				+ apptTime + ", title=" + title + ", createDate=" + createDate + ", updateDate=" + updateDate
				+ ", enabled=" + enabled + "]";
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
