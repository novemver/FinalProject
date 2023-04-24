package com.skilldistillery.sunbeamapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.sunbeamapp.entities.Elder;
import com.skilldistillery.sunbeamapp.entities.Medication;
import com.skilldistillery.sunbeamapp.repositories.MedicationRepository;

@Service
public class MedicationServiceImpl implements MedicationService {

	@Autowired
	private MedicationRepository medRepo;

	@Override
	public Medication getMedicationById(int medId) {
		return medRepo.findById(medId);
	}

	@Override
	public Medication getByMedicationName(String medName) {
		return medRepo.findByMedicationName(medName);
	}
	
	 
	@Override
	public Medication addMedication(Medication med) {
	
		return medRepo.saveAndFlush(med);
	}

	@Override
	public Medication updateMedication(int medId, Medication medication) {
		Medication existingMedication = medRepo.findById(medId);
		if (existingMedication != null) {
			existingMedication.setMedicationName(medication.getMedicationName());
			existingMedication.setHealthCondition(medication.getMedicationName());
			existingMedication.setDescription(medication.getDescription());
			existingMedication.setDose(medication.getDose());
			existingMedication.setFrequency(medication.getFrequency());
			return medRepo.saveAndFlush(existingMedication);

		}
		return null;
	}

	@Override
	public boolean deleteMedication(int medId) {
		boolean deleted = false;
		Medication toDelete = medRepo.findById(medId);
		if (toDelete != null) {
			medRepo.delete(toDelete);
			deleted = true;
		}
		return deleted;

	}




}
