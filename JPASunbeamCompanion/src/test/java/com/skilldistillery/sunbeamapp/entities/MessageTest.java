package com.skilldistillery.sunbeamapp.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MessageTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Message message; 
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPASunbeamCompanion");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		message = em.find(Message.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}
 
	@Test
	void test_description_createDate() {
		assertNotNull(message);
		assertEquals("Hey, how is he today?", message.getDescription());
		assertNotNull(message.getCreateDate());

	}
	
	@Test
	void test_MTO_messages() {
		assertNotNull(message);
		assertEquals("Sebastian", message.getReceiver().getFirstName());
	}
}
