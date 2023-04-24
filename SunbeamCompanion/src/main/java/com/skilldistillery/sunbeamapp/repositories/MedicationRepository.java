package com.skilldistillery.sunbeamapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.sunbeamapp.entities.Elder;
import com.skilldistillery.sunbeamapp.entities.Medication;

public interface MedicationRepository extends JpaRepository<Medication, Integer> {

	Medication findById_AndMedicatedElderId(int medId, int elderId);

	Medication findById(int id);
	
	List<Medication> findByMedicatedElderId(int elderId); 

}
