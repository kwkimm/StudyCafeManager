package com.project.scm.member;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, Integer> {

	Optional<MemberEntity> findBymemberId(String memberId);
	MemberEntity findByGrade(int grade);
	Page<MemberEntity> findAll(Pageable pageable);
	
}
