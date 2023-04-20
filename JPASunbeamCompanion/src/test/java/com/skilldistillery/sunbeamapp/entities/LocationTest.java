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

class LocationTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Location location; 
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
		location = em.find(Location.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}

	@Test
	void test_name_address_city_state_zipcode() {
		assertNotNull(location);
		assertEquals("St. Francis Cardiology", location.getName());
		assertEquals("123 Seasme St", location.getAddress());
		assertEquals("Denver", location.getCity());
		assertEquals("CO", location.getState());
		assertEquals("80002", location.getZipcode());
	}
	@Test
	void test_MTO_appointment_location() {
		assertNotNull(location);
		assertTrue(location.getAppointmentLocations().size() > 0);
	}
}
