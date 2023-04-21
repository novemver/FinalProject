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

class ReminderTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Reminder reminder; 
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
		reminder = em.find(Reminder.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
	} 

	@Test
	void test_variables() {
		assertNotNull(reminder);
		assertNotNull(reminder.getReminderDate());
		assertNotNull(reminder.getReminderDate());
		assertEquals("Get Bert to Cardiologist", reminder.getApptReminder().getTitle());
	}
	
	void test_MTM_reminder_to_user() {
		assertTrue(reminder.getUserReminders().size() > 0);
	}
}
