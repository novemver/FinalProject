package com.skilldistillery.sunbeamapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.sunbeamapp.entities.FamilyMember;
import com.skilldistillery.sunbeamapp.entities.FamilyMemberId;

public interface FamilyMemberRepository extends JpaRepository<FamilyMember, FamilyMemberId> {

	public FamilyMember findByElder_IdAndUser_Id(int elderId, int userId);
}
