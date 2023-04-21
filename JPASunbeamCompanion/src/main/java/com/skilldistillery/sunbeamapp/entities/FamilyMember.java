package com.skilldistillery.sunbeamapp.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "family_member")
public class FamilyMember {

	@EmbeddedId
	private FamilyMemberId id;
	
	private String relationship;
	
	private boolean enabled;
	
	@Column(name = "is_emergency_contact")
	private Boolean isEmergencyContact;

	@ManyToOne
	@JoinColumn(name = "user_id") // DB column name
	@MapsId(value = "userId")     // Field in ID class
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "elder_id") // DB column name
	@MapsId(value = "elderId")     // Field in ID class
	private Elder elder;
	
	public FamilyMember() {
		super();
	}

	public FamilyMemberId getId() {
		return id;
	}

	public void setId(FamilyMemberId id) {
		this.id = id;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Boolean getIsEmergencyContact() {
		return isEmergencyContact;
	}

	public void setIsEmergencyContact(Boolean isEmergencyContact) {
		this.isEmergencyContact = isEmergencyContact;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Elder getElder() {
		return elder;
	}

	public void setElder(Elder elder) {
		this.elder = elder;
	}

	@Override
	public String toString() {
		return "FamilyMember [id=" + id + ", relationship=" + relationship + ", enabled=" + enabled
				+ ", isEmergencyContact=" + isEmergencyContact + "]";
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
		FamilyMember other = (FamilyMember) obj;
		return Objects.equals(id, other.id);
	}
	
}
