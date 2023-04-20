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

class EmergencyContactTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private EmergencyContact emergencycontact; 
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
		emergencycontact = em.find(EmergencyContact.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}

	@Test
	void test_emergencyContact_firstName_lastName_number() {
		assertNotNull(emergencycontact);
		assertEquals("Shirley", emergencycontact.getFirstName());
		assertEquals("Jacobs", emergencycontact.getLastName());
		assertEquals("5555555510", emergencycontact.getPhoneNumber());
		
	}
}
