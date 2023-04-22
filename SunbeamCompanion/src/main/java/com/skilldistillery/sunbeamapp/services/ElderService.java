package com.skilldistillery.sunbeamapp.services;

import java.util.List;

import com.skilldistillery.sunbeamapp.entities.Elder;

public interface ElderService {

	public List<Elder> findAllElders();

	public Elder getByElderId(int elderId);

	public Elder getByElderName(String Name);

	public Elder updateElder(int elderId, Elder elder);

//	public Elder adminUpdateElder(int elderId, Elder elder);
//
	public boolean archiveElder(int elderId);

	public void unarchiveElder(int elderId);

}
