package com.project.scm.member;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberForm {
	
	@NotEmpty(message = "아이디는 필수항목입니다.")
	@Size(min = 3, max = 20)
	private String memberId;
	
	@NotEmpty(message = "비밀번호는 필수항목입니다.")
	private String pw1;
	
	@NotEmpty(message = "비밀번호 확인은 필수항목입니다.")
	private String pw2;
	
	@NotEmpty(message = "이름은 필수항목입니다.")
	private String name;
	
	@NotEmpty(message = "이메일은 필수항목입니다.")
	@Email
	private String email;
	
	@NotEmpty(message = "전화번호는 필수항목입니다.")
	private String phone;
	
	@NotEmpty(message = "주소는 필수항목입니다.")
	private String addr;
	
}
