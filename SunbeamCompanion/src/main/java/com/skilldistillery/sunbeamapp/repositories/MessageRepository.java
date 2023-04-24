package com.skilldistillery.sunbeamapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skilldistillery.sunbeamapp.entities.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {
	
	Message findById(int id);
	@Query("FROM Message m WHERE (sender.username LIKE ?1 AND receiver.id = ?2) OR (receiver.username LIKE ?3 AND sender.id = ?4)")
	List<Message> messagesBetweenUsers(
			@Param("1") String username,
			@Param("2")int receiver,
			@Param("3")String receiverUsername,
			@Param("4")int sender);
	
}
