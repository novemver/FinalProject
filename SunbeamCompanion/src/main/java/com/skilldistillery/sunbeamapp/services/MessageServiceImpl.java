package com.skilldistillery.sunbeamapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.sunbeamapp.entities.Message;
import com.skilldistillery.sunbeamapp.entities.User;
import com.skilldistillery.sunbeamapp.repositories.MessageRepository;
import com.skilldistillery.sunbeamapp.repositories.UserRepository;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageRepository messageRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public Message findMessageById(int id) {
		return messageRepo.findById(id);
	}

	@Override
	public List<Message> findAll() {
		return messageRepo.findAll();
	}

	@Override
	public List<Message> findMessagesBetweenUsers(String username, int receiverId) {
		User loggedInUser = userRepo.findByUsername(username);
		User receiver = userRepo.findById(receiverId);
		if(loggedInUser != null && receiver != null) {
			System.out.println(username);
			System.out.println(receiverId+"*******************************************");
			
			return messageRepo.messagesBetweenUsers(
					username, 
				 receiverId,
				 username, 
				 receiverId);
		}
		return null;
	}

	@Override
	public Message createMessage(Message message, String username, int receiverId) {
		User loggedInUser = userRepo.findByUsername(username);
		User receiver = userRepo.findById(receiverId);
		if(loggedInUser != null && receiver != null) {
			message.setReceiver(receiver);
			message.setSender(loggedInUser);
			return messageRepo.saveAndFlush(message);
		}
		
		return null;
	}

	@Override
	public Message updateMessage(Message message) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message deleteMessage(int messageId) {
//		boolean deleted = false;
//		Message messToDelete = messageRepo.findById(messageId);
//		return deleted;
		return null;
	}
	
}
