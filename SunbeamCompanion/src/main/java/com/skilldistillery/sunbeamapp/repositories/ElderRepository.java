package com.skilldistillery.sunbeamapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.sunbeamapp.entities.Elder;

public interface ElderRepository extends JpaRepository<Elder, Integer> {

	Elder findByFirstName(String fname);
}
