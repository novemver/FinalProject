package com.skilldistillery.sunbeamapp.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;

	private String username;

	private String password;

	private boolean enabled;

	private String role;

	private String email;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "image_url")
	private String imageUrl;

	@Column(name = "biography")
	private String userBio;

	@Column(name = "create_date")
	private LocalDateTime createDate;

	@UpdateTimestamp
	@Column(name = "update_date")
	private LocalDateTime updateDate;

	@OneToMany(mappedBy = "receiver")
	private List<Message> receiveMessages;

	@OneToMany(mappedBy = "sender")
	private List<Message> senderMessages;

	@OneToMany(mappedBy = "userNote")
	private List<Note> notes;
	///// Methods /////
 
	@OneToMany(mappedBy = "userAppointments")
	private List<Appointment> appointments;
	
	@OneToMany(mappedBy = "userComment")
	private List<Comment> comments;
	
	
	@OneToMany(mappedBy = "userContact")
	private List<EmergencyContact> contactsFromUser;
	
	
	public User() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
 
	public List<EmergencyContact> getContacts() {
		return contactsFromUser;
	}

	public void setContacts(List<EmergencyContact> contact) {
		this.contactsFromUser = contact;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Message> getReceiveMessages() {
		return receiveMessages;
	}

	public void setReceiveMessages(List<Message> receiveMessages) {
		this.receiveMessages = receiveMessages;
	}

	public List<Message> getSenderMessages() {
		return senderMessages;
	}

	public void setSenderMessages(List<Message> senderMessages) {
		this.senderMessages = senderMessages;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<EmergencyContact> getContactsFromUser() {
		return contactsFromUser;
	}

	public void setContactsFromUser(List<EmergencyContact> contactsFromUser) {
		this.contactsFromUser = contactsFromUser;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getUserBio() {
		return userBio;
	}

	public void setUserBio(String userBio) {
		this.userBio = userBio;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public LocalDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", enabled=" + enabled
				+ ", role=" + role + ", email=" + email + ", phoneNumber=" + phoneNumber + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", imageUrl=" + imageUrl + ", userBio=" + userBio + ", createDate="
				+ createDate + ", updateDate=" + updateDate + "]";
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
		User other = (User) obj;
		return id == other.id;
	}

}
