package com.nowon.test.domain.dto.member;

import com.nowon.test.domain.entity.MemberEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter//controller의 파라미터로 세팅하기 위해
public class MemberInsertDTO {
	private String email;
	private String pass;
	private String name;
	
	//dto->Memberentity 클래스에 매핑하는 매서드
	public MemberEntity toEntity() {
		return MemberEntity.builder()
				.email(email).pass(pass).name(name).build();
	}
}