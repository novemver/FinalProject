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

class FamilyMemberTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private FamilyMember familyMember; 
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
		FamilyMemberId fid = new FamilyMemberId();
		fid.setElderId(1);
		fid.setUserId(3);
		familyMember = em.find(FamilyMember.class, fid);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}
	
	@Test
	void test_family_member_mappings() {
		assertNotNull(familyMember);
		assertEquals("Grandson",familyMember.getRelationship());
		assertEquals(true, familyMember.isEnabled());
	}
	@Test
	void test_family_member_MTO_user_mappings() {
		assertNotNull(familyMember);
		assertEquals("Sebastian",familyMember.getUser().getFirstName());
	}
	@Test
	void test_family_member_MTO_elder_mappings() {
		assertNotNull(familyMember);
		assertEquals("Bert",familyMember.getElder().getFirstName());
	}
	

	

}
