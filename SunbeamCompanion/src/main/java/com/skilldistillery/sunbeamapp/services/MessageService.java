package com.skilldistillery.sunbeamapp.services;

import java.util.List;

import com.skilldistillery.sunbeamapp.entities.Message;

public interface MessageService {
	
	public Message findMessageById(int Id);
	List<Message> findAll();
	List<Message> findMessagesBetweenUsers();
	public Message createMessage(Message message);
	public Message updateMessage(Message message);
	public Message deleteMessage(int Id);
	
	
	
}
