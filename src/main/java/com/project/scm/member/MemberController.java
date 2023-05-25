package com.project.scm.member;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/member")
@Controller
@RequiredArgsConstructor
public class MemberController {
	
	private final MemberService memberService;
	
	// 회원 요약 정보
	@GetMapping("/list")
	public String list(Model model, 
			@RequestParam(value = "page", defaultValue = "0") int page) {
		
//		List<MemberEntity> memberList = memberService.getList();
//		model.addAttribute("memberList", memberList);
		
		Page<MemberEntity> paging = memberService.getList(page);
		
		// 한번에 보여 줄 페이지 수
		int memberPerPage = 10;
		
		int start = (page / memberPerPage) * memberPerPage;
		int end = paging.getTotalPages() == 0 ? 1 : (start + (memberPerPage - 1))
				< paging.getTotalPages() ? start + (memberPerPage - 1) : paging.getTotalPages();
		
		int count = (int)paging.getTotalElements() - 1;
		
		if(end > count / memberPerPage) {
			end = count / memberPerPage;
		}
		
		model.addAttribute("paging", paging);
		model.addAttribute("memberPerPage", memberPerPage);	// 한번에 보여 줄 페이지 수
		model.addAttribute("start", start);
		model.addAttribute("end", end);
		
		return "member_list";
		
		
	}
	
	// 회원 상세정보
	@GetMapping(value = "/detail/{id}")
	public String detail(Model model, @PathVariable("id") String id) {
		
		MemberEntity memberEntity = memberService.getMemberEntity(id);
		model.addAttribute("memberEntity", memberEntity);
		
		return "member_detail";
	}
	
	// 회원 등록 버튼 작동 (등록 폼으로 이동)
	@GetMapping("/create")
	public String memberCreate(MemberForm memberForm) {
		return "member_form";
	}
	
	// 실제 회원 등록
	@PostMapping("/create")
	public String memberCreate(@Valid MemberForm memberForm, BindingResult bindingResult) {

		if(bindingResult.hasErrors()) {
			return "member_form";
		}
		
		if(!memberForm.getPw1().equals(memberForm.getPw2())) {
			bindingResult.rejectValue("pw2", "passwordIncorrect", "2개의 패스워드가 일치하지 않습니다.");
			return "member_form";
		}
		
		try {
			memberService.create(memberForm.getMemberId(), memberForm.getPw1(), memberForm.getName(), memberForm.getEmail(), memberForm.getPhone(), memberForm.getAddr());
		} catch(DataIntegrityViolationException e) {
			e.printStackTrace();
			bindingResult.reject("createFailed", "이미 등록 된 ID 혹은 email 입니다.");
			return "member_form";
		} catch (Exception e) {
			e.printStackTrace();
			bindingResult.reject("createFailed", e.getMessage());
			return "member_form";
		}
		
		return "redirect:/";
		
	}
	
	// 회원 정보 수정
	@GetMapping("/modify/{memberId}")
	public void getModify(@RequestParam("memberId") String memberId, Model model) throws Exception{
		
		MemberEntity memberEntity = memberService.getMemberEntity(memberId);
		
		model.addAttribute("memberEntity", memberEntity);
	}
	
	// 로그인 화면 이동
	@GetMapping("/login")
	public String login() {
		return "login_form";
	}
}






