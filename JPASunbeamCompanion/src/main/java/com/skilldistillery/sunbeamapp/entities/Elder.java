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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Elder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	private String weight;

	private String height;

	private LocalDate birthdate;

	@Column(name = "access_code")
	private String accessCode;

	@Column(name = "elder_overview")
	private String elderOverview;

	private String gender;

	@CreationTimestamp 
	@Column(name = "create_date")
	private LocalDateTime createDate;

	@UpdateTimestamp
	@Column(name = "last_update")
	private LocalDateTime lastUpdate;

	@Column(name = "image_url")
	private String imageUrl;

	@Column(name = "biography")
	private String elderBio;
	
	private boolean enabled;

	@JsonIgnore
	@OneToMany(mappedBy = "elderNote")
	private List<Note> elderNotes;

	@JsonIgnore
	@OneToMany(mappedBy = "elderAppointments")
	private List<Appointment> appointments;

	@JsonIgnore
	@OneToMany(mappedBy = "elder")
	private List<Comment> comments;

	@JsonIgnore
	@OneToMany(mappedBy = "elder")
	private List<FamilyMember> familyMembers;
	
	@JsonIgnore
	@OneToMany(mappedBy = "medicatedElder")
	private List<Medication> medications;
	
	@JsonIgnore
	@ManyToMany(mappedBy="userElders")
	private List<User> elderCaretakers;
	

	///// Methods /////

	
	public List<Medication> getMedications() {
		return medications;
	}

	public void setMedications(List<Medication> medications) {
		this.medications = medications;
	}

	public Elder() {
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

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
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

	public String getElderBio() {
		return elderBio;
	}

	public void setElderBio(String elderBio) {
		this.elderBio = elderBio;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<Note> getElderNotes() {
		return elderNotes;
	}

	public void setElderNotes(List<Note> elderNotes) {
		this.elderNotes = elderNotes;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}


	public List<FamilyMember> getFamilyMembers() {
		return familyMembers;
	}

	public void setFamilyMembers(List<FamilyMember> familyMembers) {
		this.familyMembers = familyMembers;
	}

	public List<User> getElderCaretakers() {
		return elderCaretakers;
	}

	public void setElderCaretakers(List<User> elderCaretakers) {
		this.elderCaretakers = elderCaretakers;
	}



	@Override
	public String toString() {
		return "Elder [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", weight=" + weight
				+ ", height=" + height + ", birthdate=" + birthdate + ", accessCode=" + accessCode + ", elderOverview="
				+ elderOverview + ", gender=" + gender + ", createDate=" + createDate + ", lastUpdate=" + lastUpdate
				+ ", imageUrl=" + imageUrl + ", elderBio=" + elderBio + ", enabled=" + enabled + ", elderNotes="
				+ elderNotes + ", appointments=" + appointments + ", comments=" + comments + ", familyMembers="
				+ familyMembers + ", medications=" + medications + ", elderCaretakers=" + elderCaretakers + "]";
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
