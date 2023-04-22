package com.skilldistillery.sunbeamapp.services;

import java.util.List;

import com.skilldistillery.sunbeamapp.entities.Medication;
import com.skilldistillery.sunbeamapp.entities.User;

public interface MedicationService {

	public Medication getMedicaionById(int medId);
	public Medication getByMedicationName(String medName);
	public Medication updateMedication(String name, Medication medication);
	public boolean deleteMedication(int medId);
}
