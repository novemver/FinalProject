package com.skilldistillery.sunbeamapp.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Medication {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="medication_name")
	private String medicationName;

	@Column(name="health_condition")
	private String healthCondition;
	
	private String description;
	
	private String dose;
	
	private String frequency;
	
	@ManyToOne
	@JoinColumn(name = "elder_id")
	private Elder medicatedElder;  

	///// Methods /////
	
	public Medication() {
		super();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHealthCondition() {
		return healthCondition;
	}

	public void setHealthCondition(String healthCondition) {
		this.healthCondition = healthCondition;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDose() {
		return dose;
	}

	public void setDose(String dose) {
		this.dose = dose;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public Elder getMedicatedElder() {
		return medicatedElder;
	}

	public void setMedicatedElder(Elder medicatedElder) {
		this.medicatedElder = medicatedElder;
	}

	public String getMedicationName() {
		return medicationName;
	}

	public void setMedicationName(String medicationName) {
		this.medicationName = medicationName;
	}

	@Override
	public String toString() {
		return "Medication [id=" + id + ", medicationName=" + medicationName + ", healthCondition=" + healthCondition
				+ ", description=" + description + ", dose=" + dose + ", frequency=" + frequency + ", medicatedElder="
				+ medicatedElder + "]";
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
		Medication other = (Medication) obj;
		return id == other.id;
	}
	

}
