package com.project.scm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.ColumnDefault;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.scm.member.MemberEntity;
import com.project.scm.member.MemberRepository;
import com.project.scm.member.MemberService;

@SpringBootTest
class StudyCafeManagerApplicationTests {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private MemberService memberService;
	
	@Test
	void testJpa() {
		
		// 회원 더미 데이터 생성 (%02d = 2자리 정수)
//		for(int i=1; i<=20; i++) {
//			
//			String memberId = String.format("TESTID%02d", i);
//			String pw = "1111";
//			String name = String.format("테스트%02d", i);
//			String email = String.format("aa%02d@aa.com", i);
//			String phone = String.format("010-%02d0-1234", i);;
//			String addr = String.format("테스트주소%02d", i);
//			
//			memberService.create(memberId, pw, name, email, phone, addr);
//			
//		}
		
		// 등급으로 조회
//		MemberEntity m = this.memberRepository.findByGrade(2);
//		assertEquals(2, m.getGrade());
		
		// @id로 조회
//		Optional<MemberEntity> om = this.memberRepository.findById(102);
//		if(om.isPresent()) {
//			MemberEntity m = om.get();
//			assertEquals("admin", m.getId());
//		}
		
		// findAll
//		List<MemberEntity> all = this.memberRepository.findAll();
//		assertEquals(2, all.size());
//		
//		MemberEntity m = all.get(0);
//		assertEquals("admin", m.getId());
		
		// 데이터 추가
//		MemberEntity m1 = new MemberEntity();
//		
//		m1.setMemberId("admin");
//		m1.setPw("1111");
//		m1.setGrade(2);
//		this.memberRepository.save(m1);
//		
//		MemberEntity m2 = new MemberEntity();
//		
//		m2.setMemberId("aaaa");
//		m2.setPw("2222");
//		this.memberRepository.save(m2);
		
	}

	@Test
	void contextLoads() {
	}

}
