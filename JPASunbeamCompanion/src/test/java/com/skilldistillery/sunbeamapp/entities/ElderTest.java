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

class ElderTest {

	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Elder elder; 
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
		elder = em.find(Elder.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}

	@Test
	void test_client_firstname_lastname_weight_height_others() {
		assertNotNull(elder);
		assertEquals("Bert", elder.getFirstName());
		assertEquals("Johson", elder.getLastName());
		assertEquals("180", elder.getWeight());
		assertEquals("6" , elder.getHeight());
		assertNotNull(elder.getBirthDate());
		assertNotNull(elder.getElderOverview());
		assertEquals("Male", elder.getGender());
		assertNotNull(elder.getCreateDate());
		assertNotNull(elder.getImageUrl());
	}
	
	@Test
	void test_MTO_client_note() {
		assertTrue(elder.getElderNotes().size() >= 0);
	}
	
	@Test
	void test_OTM_client_appointment() {
		assertEquals("Bert", elder.getFirstName());
	}

}
