package com.skilldistillery.sunbeamapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.sunbeamapp.entities.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {

}
