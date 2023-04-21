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
	
	@Test
	void test_MTO_user_appointments() {
		assertNotNull(appointment);
		assertEquals("Kira", appointment.getUserAppointments().getFirstName());
	}
	
	@Test
	void test_MTO_client_appointments() {
		assertNotNull(appointment);
		assertTrue(appointment.getElderAppointments().getAppointments().size() >= 0);
	}

	@Test
	void test_MTO_category_appointment() {
		assertNotNull(appointment);
		assertEquals("Doctor", appointment.getCategory().getName());
	}
	@Test
	void test_OTM_appointment_location() {
		assertNotNull(appointment);
		assertEquals("Denver", appointment.getLocation().getCity());
	}
	
	@Test
	void test_OTM_appointment_reminders() {
		assertNotNull(appointment);
		assertEquals("Cardiologist", appointment.getElderAppointments());
	}
}

