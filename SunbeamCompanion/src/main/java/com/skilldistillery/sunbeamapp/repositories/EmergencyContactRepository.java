package com.skilldistillery.sunbeamapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.sunbeamapp.entities.EmergencyContact;

public interface EmergencyContactRepository extends JpaRepository<EmergencyContact, Integer> {

 EmergencyContact findEmergencyContactByElderId(int elderId);  
}
