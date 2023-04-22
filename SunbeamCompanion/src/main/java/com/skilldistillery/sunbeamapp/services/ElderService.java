package com.skilldistillery.sunbeamapp.services;

import java.util.List;

import com.skilldistillery.sunbeamapp.entities.Elder;

public interface ElderService {

	public List<Elder> findAllElders();

	public Elder getByElderId(int elderId);

	public Elder getByElderName(String Name);

	public Elder addElder(Elder elder);

	public Elder updateElder(int elderId, Elder elder);

	public boolean archiveElder(int elderId);

	public boolean unarchiveElder(int elderId);

}
