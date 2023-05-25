package com.project.scm.member;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.scm.DataNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	
	private final MemberRepository memberRepository;
	private final PasswordEncoder passwordEncoder;
	
	public List<MemberEntity> getList(){
		return memberRepository.findAll();
	}
	
	public MemberEntity getMemberEntity(String memberId) {
		
		Optional<MemberEntity> memberEntity = this.memberRepository.findBymemberId(memberId);
		
		if(memberEntity.isPresent()) {
			return memberEntity.get();
		} else {
			throw new DataNotFoundException("member not found");
		}
	}
	
	public MemberEntity create(String memberId, String pw, String name, String email, String phone, String addr) {
		
		MemberEntity member = new MemberEntity();
		
		member.setMemberId(memberId);
		member.setPw(passwordEncoder.encode(pw));
		member.setName(name);
		member.setEmail(email);
		member.setPhone(phone);
		member.setAddr(addr);
		member.setAvailableTime(0);
		
		memberRepository.save(member);
		
		return member;
		
	}
	
	// 페이지번호 전달 받아서 목록 리턴 (10개만)
	public Page<MemberEntity> getList(int page){
		
		// memberCode 역순정렬
		List<Sort.Order> sorts = new ArrayList<>();
		sorts.add(Sort.Order.desc("memberCode"));
		
		Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
		
		return memberRepository.findAll(pageable);
	}
	
	
	
}
