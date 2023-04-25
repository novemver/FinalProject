package com.skilldistillery.sunbeamapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.sunbeamapp.entities.FamilyMember;
import com.skilldistillery.sunbeamapp.entities.Message;
import com.skilldistillery.sunbeamapp.entities.User;
import com.skilldistillery.sunbeamapp.repositories.FamilyMemberRepository;
import com.skilldistillery.sunbeamapp.repositories.MessageRepository;
import com.skilldistillery.sunbeamapp.repositories.UserRepository;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageRepository messageRepo;
	
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private FamilyMemberRepository familyRepo;
	
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
			return messageRepo.messagesBetweenUsers(username, receiverId,
				 username, receiverId);
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
	public Message updateMessage(String username, int messId, Message message) {
		User loggedInUser = userRepo.findByUsername(username);
		Message existingMessage = messageRepo.findById(messId);

		if(existingMessage != null && loggedInUser!= null
				&& existingMessage.getSender().getId() == loggedInUser.getId()) {
			existingMessage.setDescription(message.getDescription());
			return messageRepo.saveAndFlush(existingMessage);
		}
		return null;
	}

	@Override
	public boolean deleteMessage(String username, int messageId) {
		boolean deleted = false;
		User loggedInUser = userRepo.findByUsername(username);
		Message messToDelete = messageRepo.findById(messageId);
		if(loggedInUser != null) {
			messageRepo.delete(messToDelete);
			deleted = true;
		}
		return deleted;
		
	}
	
}
