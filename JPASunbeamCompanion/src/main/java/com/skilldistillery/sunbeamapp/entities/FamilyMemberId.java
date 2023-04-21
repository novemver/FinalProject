package com.skilldistillery.sunbeamapp.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FamilyMemberId implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "elder_id")
	private int elderId;

	
	//METHODS
	public FamilyMemberId() {
		super();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getElderId() {
		return elderId;
	}

	public void setElderId(int elderId) {
		this.elderId = elderId;
	}

	@Override
	public String toString() {
		return "FamilyMemberId [userId=" + userId + ", elderId=" + elderId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(elderId, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FamilyMemberId other = (FamilyMemberId) obj;
		return elderId == other.elderId && userId == other.userId;
	}

	
	
	
}
