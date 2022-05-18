package com.nowon.test.service;

import com.nowon.test.domain.dto.member.MemberInsertDTO;



public interface MemberService {
	void save(MemberInsertDTO dto);

	boolean emailCheck(String email);

}
