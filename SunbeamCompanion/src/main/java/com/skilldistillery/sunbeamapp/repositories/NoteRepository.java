package com.skilldistillery.sunbeamapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.sunbeamapp.entities.Note;

public interface NoteRepository extends JpaRepository<Note, Integer>{

}
