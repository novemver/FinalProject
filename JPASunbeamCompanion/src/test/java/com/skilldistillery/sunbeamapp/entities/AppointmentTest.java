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

class AppointmentTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Appointment appointment; 
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
		appointment = em.find(Appointment.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}
	
	@Test
	void test_apptdate_appttime_title_createdate() {
		assertNotNull(appointment);
		assertEquals("Cardiologist appt. with Dr.Rob", appointment.getDescription());
		assertNotNull(appointment.getApptDate());
		assertNotNull(appointment.getApptTime());
		assertEquals("Get Bert to Cardiologist", appointment.getTitle());
		assertNotNull(appointment.getCreateDate());
	}

}
