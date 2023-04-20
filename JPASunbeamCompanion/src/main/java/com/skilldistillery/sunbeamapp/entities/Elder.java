package com.skilldistillery.sunbeamapp.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

@Entity
public class Elder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	private String weight;

	private String height;

	private LocalDate birthdate;
	
	@Column(name="access_code")
	private String accessCode;
	
	@Column(name="elder_overview")
	private String elderOverview;
	
	private String gender;
	
	@Column(name="create_date")
	private LocalDateTime createDate;
	
	@Column(name="last_update")
	private LocalDateTime lastUpdate;
	
	@Column(name="image_url")
	private String imageUrl;
		
	@Column(name="biography")
	private String elderBio;
	
	@OneToMany(mappedBy = "elderNote")
	private List<Note> elderNotes;
	
	@OneToMany(mappedBy = "elderAppointments")
	private List<Appointment> appointments;
	
	@OneToMany(mappedBy = "elderComment")
	private List<Comment> comments;
	
	@OneToMany(mappedBy = "elderContact")
	private List<EmergencyContact> contact;
	
	

	///// Methods /////
	
	public Elder() {
		super();
	}
	
	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public String getElderBio() {
		return elderBio;
	}

	public void setElderBio(String elderBio) {
		this.elderBio = elderBio;
	}

	public List<Note> getElderNotes() {
		return elderNotes;
	}

	public void setElderNotes(List<Note> elderNotes) {
		this.elderNotes = elderNotes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<EmergencyContact> getContact() {
		return contact;
	}

	public void setContact(List<EmergencyContact> contact) {
		this.contact = contact;
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

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public LocalDate getBirthDate() {
		return birthdate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthdate = birthDate;
	}

	public String getAccessCode() {
		return accessCode;
	}

	public void setAccessCode(String accessCode) {
		this.accessCode = accessCode;
	}



	public String getElderOverview() {
		return elderOverview;
	}

	public void setElderOverview(String elderOverview) {
		this.elderOverview = elderOverview;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getBio() {
		return elderBio;
	}

	public void setBio(String bio) {
		this.elderBio = bio;
	}


	@Override
	public String toString() {
		return "Elder [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", weight=" + weight
				+ ", height=" + height + ", birthdate=" + birthdate + ", accessCode=" + accessCode + ", elderOverview="
				+ elderOverview + ", gender=" + gender + ", createDate=" + createDate + ", lastUpdate=" + lastUpdate
				+ ", imageUrl=" + imageUrl + ", elderBio=" + elderBio + ", elderNotes=" + elderNotes
				+ ", appointments=" + appointments + "]";
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
		Elder other = (Elder) obj;
		return id == other.id;
	}
	
}
