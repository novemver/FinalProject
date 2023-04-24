package com.skilldistillery.sunbeamapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.sunbeamapp.entities.Elder;
import com.skilldistillery.sunbeamapp.entities.Medication;
import com.skilldistillery.sunbeamapp.entities.User;
import com.skilldistillery.sunbeamapp.repositories.ElderRepository;
import com.skilldistillery.sunbeamapp.repositories.MedicationRepository;
import com.skilldistillery.sunbeamapp.repositories.UserRepository;

@Service
public class MedicationServiceImpl implements MedicationService {

	@Autowired
	private MedicationRepository medRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private ElderRepository elderRepo;

	@Override
	public Medication getMedicationById(int medId) {
		return medRepo.findById(medId);
	}

	@Override
	public Medication getByMedIdAndElderId(int medId, int elderId) {
		return medRepo.findById_AndMedicatedElderId(medId, elderId);
	}
	
	@Override
	public List<Medication> findMedicationsByElderId(int elderId) {
		Elder elder = elderRepo.findById(elderId);
		return medRepo.findByMedicatedElderId(elder.getId());
	}
	
	 
	@Override
	public Medication addMedication(String username, Medication med, Elder medicatedElder) {
	User loggedInUser = userRepo.findByUsername(username);
	if(loggedInUser != null) {
		med.setMedicatedElder(medicatedElder);
		return medRepo.saveAndFlush(med);
	}
	return null;
	}

	@Override
	public Medication updateMedication(String username, int medId, Medication medication, Elder medicatedElder) {
		User loggedInUser = userRepo.findByUsername(username);
		if(loggedInUser == null) {
			return null;
		}
		Elder medElder = elderRepo.findById(medicatedElder.getId());
		Medication existingMedication = medRepo.findById(medId);
		if (existingMedication != null && medElder != null) {
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
	public boolean deleteMedication(String username, int medId) {
		boolean deleted = false;
		Medication toDelete = medRepo.findById(medId);
		if (toDelete != null) {
			medRepo.delete(toDelete);
			deleted = true;
		}
		return deleted;

	}




}
