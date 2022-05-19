package com.nowon.test.domain.dto.member;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class LoginDTO {
	
	private String email;
	private String pass;
	private boolean idSave; //html과 타입 일치 필수
	
}
