package com.skilldistillery.sunbeamapp.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private User user; 
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
		user = em.find(User.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}

	@Test
	void test_username_and_id_and_password_and_role() {
		assertNotNull(user);
		assertEquals("admin", user.getUsername());
		assertEquals(1, user.getId());
		assertEquals("$2a$10$nShOi5/f0bKNvHB8x0u3qOpeivazbuN0NE4TO0LGvQiTMafaBxLJS", user.getPassword());
		assertEquals("ADMIN", user.getRole());
	}

	@Test
	void test_OTM_user_messages_mapping() {
		assertNotNull(user);
		assertTrue(user.getReceiveMessages().size() >= 0);
		assertTrue(user.getSenderMessages().size() >= 0);
		
	}
	
	@Test
	void test_OTM_user_notes_mapping() {
		assertNotNull(user);
		assertTrue(user.getNotes().size() >= 0);
		
	}
	
	@Test
	void test_OTM_appointments_user() {
		assertNotNull(user);
		assertTrue(user.getAppointments().size() >= 0);
	}
	

		
}
