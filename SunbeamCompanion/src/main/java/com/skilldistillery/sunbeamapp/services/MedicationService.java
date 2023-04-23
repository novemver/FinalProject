package com.skilldistillery.sunbeamapp.services;

import java.util.List;

import com.skilldistillery.sunbeamapp.entities.Elder;
import com.skilldistillery.sunbeamapp.entities.Medication;
import com.skilldistillery.sunbeamapp.entities.User;

public interface MedicationService {
 
	public Medication getMedicationById(int medId);

	public Medication getByMedicationName(String medName);
	
	public Medication addMedication(Medication med);
	
//	public List<Medication> findMedicationsByElderId(int elderId);

	public Medication updateMedication(int medId, Medication medication);

	public boolean deleteMedication(int medId);
	
	
}
