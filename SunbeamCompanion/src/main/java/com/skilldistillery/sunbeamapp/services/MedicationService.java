package com.skilldistillery.sunbeamapp.services;

import java.util.List;

import com.skilldistillery.sunbeamapp.entities.Elder;
import com.skilldistillery.sunbeamapp.entities.Medication;
import com.skilldistillery.sunbeamapp.entities.User;

public interface MedicationService {
 
	public Medication getMedicationById(int medId);

	public Medication getByMedIdAndElderId(int medId, int elderId);
	
	public Medication addMedication(String username, Medication med, Elder elder);
	
	public List<Medication> findMedicationsByElderId(int elderId);


	public Medication updateMedication(String username, int medId, Medication med, Elder elder);

	public boolean deleteMedication(String username, int medId);
	
	
}
