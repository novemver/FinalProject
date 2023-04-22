package com.skilldistillery.sunbeamapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.sunbeamapp.entities.Medication;

public interface MedicationRepository extends JpaRepository<Medication, Integer>{

	Medication findByMedicationName(String medName);
	Medication findById(int id);
}
