package com.skilldistillery.sunbeamapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.sunbeamapp.entities.Elder;
import com.skilldistillery.sunbeamapp.entities.Medication;

public interface ElderRepository extends JpaRepository<Elder, Integer> {

	Elder findByFirstName(String fname);
	Elder findById(int elderId);
	List<Elder> findMedicationsByElderId(int elderId);
}
 