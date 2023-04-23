package com.skilldistillery.sunbeamapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.sunbeamapp.entities.Elder;
import com.skilldistillery.sunbeamapp.entities.Medication;
import com.skilldistillery.sunbeamapp.entities.User;
import com.skilldistillery.sunbeamapp.repositories.ElderRepository;

@Service
public class ElderServiceImpl implements ElderService {


	@Autowired
	private ElderRepository elderRepo;
//	list users 
	
	@Override
	public List<Elder> findAllElders() {
		// TODO Auto-generated method stub
		return elderRepo.findAll();
	}

	@Override
	public Elder getByElderId(int elderId) {
		// TODO Auto-generated method stub
		return elderRepo.findById(elderId);
	}

	@Override
	public Elder getByElderName(String name) {
		return elderRepo.findByFirstName(name);
	}
	
	@Override
	public Elder addElder(Elder elder) {
		// TODO Auto-generated method stub
		return elderRepo.saveAndFlush(elder);
	}
	
	@Override
	public Elder updateElder(int elderId, Elder elder) {
		Elder existingElder = elderRepo.findById(elderId);
		if(existingElder != null) {
			existingElder.setFirstName(elder.getFirstName());
			existingElder.setLastName(elder.getLastName());
			existingElder.setWeight(elder.getWeight());
			existingElder.setHeight(elder.getHeight());
			existingElder.setImageUrl(elder.getImageUrl());
			existingElder.setBirthdate(elder.getBirthdate());
			existingElder.setAccessCode(elder.getAccessCode());
			existingElder.setGender(elder.getGender());
			existingElder.setElderBio(elder.getElderBio());
			existingElder.setElderOverview(elder.getElderOverview());
			
			
			
			return elderRepo.saveAndFlush(existingElder);
			
		}
		return null;
	}


	@Override
	public boolean archiveElder(int elderId) {
		Elder elderToBeArchived = elderRepo.findById(elderId);
		if (elderToBeArchived != null) {
			elderToBeArchived.setEnabled(false);
			elderRepo.saveAndFlush(elderToBeArchived);
		}
		return elderToBeArchived.isEnabled();
		
	}

	@Override
	public boolean unarchiveElder(int elderId) {
		boolean unarchived = true;
		Elder elderUnArchived = elderRepo.findById(elderId);
		if (elderUnArchived != null) {
			elderUnArchived.setEnabled(unarchived);
			elderRepo.saveAndFlush(elderUnArchived);
		}
		return elderUnArchived.isEnabled();
		
	}

	@Override
	public List<Elder> getAllMedication(int elderId) {
		// TODO Auto-generated method stub
		return elderRepo.findMedicationsByElderId(elderId);
	}

 
}
