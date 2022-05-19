package com.nowon.test.domain.dto.member;

import com.nowon.test.domain.entity.MemberEntity;

import lombok.Getter;

@Getter//페이지에서 가져오기 위해
public class LogInfo {
	
	private String name;
	private String email;
	
	public LogInfo(MemberEntity entity) {
		this.name = entity.getName();
		this.email = entity.getEmail();
	}
	

}
