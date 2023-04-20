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

class MedicationTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Medication medication; 
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
		medication = em.find(Medication.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}

	@Test 
	void test_medicationname_and_id_and_password_and_role() {
		assertNotNull(medication);
		assertEquals("Benazepril (Lotensin)", medication.getMedication());
		assertEquals("Heart murmurs", medication.getHealthCondition());
		assertEquals("He has had a few heart attacks and is on a diet regmine for heart health", medication.getDescription());
		assertEquals("50mg", medication.getDose());
		assertEquals("2 times a day", medication.getFrequency());
	}

}
