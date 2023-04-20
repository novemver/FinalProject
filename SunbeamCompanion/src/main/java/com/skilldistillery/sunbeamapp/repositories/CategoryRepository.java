package com.skilldistillery.sunbeamapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.sunbeamapp.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

	
}
