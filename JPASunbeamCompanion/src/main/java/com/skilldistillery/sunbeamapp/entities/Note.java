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

@Entity
public class Note {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String title;

	private String description;

	private String flagged;

	@Column(name = "create_date")
	private LocalDate createDate;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User userNote;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client clientNote;
	///// Methods /////

	public Note() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public User getUserNote() {
		return userNote;
	}

	public void setUserNote(User userNote) {
		this.userNote = userNote;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Client getClientNote() {
		return clientNote;
	}

	public void setClientNote(Client clientNote) {
		this.clientNote = clientNote;
	}

	public String getFlagged() {
		return flagged;
	}

	public void setFlagged(String flagged) {
		this.flagged = flagged;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Note [id=" + id + ", title=" + title + ", description=" + description + ", flagged=" + flagged
				+ ", createDate=" + createDate + "]";
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
		Note other = (Note) obj;
		return id == other.id;
	}

}
