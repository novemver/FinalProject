package com.skilldistillery.sunbeamapp.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "emergency_contact")
public class EmergencyContact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "phone_number")
	private String phoneNumber;

	private String email;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User userContact;
	
	@ManyToOne
	@JoinColumn(name = "elder_id")
	private Elder elderContact;

	///// Methods /////

	public EmergencyContact() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Elder getElderContact() {
		return elderContact;
	}

	public void setElderContact(Elder elderContact) {
		this.elderContact = elderContact;
	}

	public User getUserContact() {
		return userContact;
	}

	public void setUserContact(User userContact) {
		this.userContact = userContact;
	}

	@Override
	public String toString() {
		return "EmergencyContact [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber="
				+ phoneNumber + ", email=" + email + ", userContact=" + userContact + "]";
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
		EmergencyContact other = (EmergencyContact) obj;
		return id == other.id;
	}

}
