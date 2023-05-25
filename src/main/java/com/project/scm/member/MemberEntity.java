package com.project.scm.member;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DynamicInsert
public class MemberEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer memberCode;
	
	@Size(min = 3, max = 20)
	@Column(unique = true)
	private String memberId;

	private String pw;
	private String name;
	
	@Email
	private String email;
	
	private String phone;
	private String addr;
	
	@ColumnDefault("0")
	private Integer availableTime;
	
	@ColumnDefault("1")
	private Integer grade;
	
}
