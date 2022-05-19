package com.nowon.test.service;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.nowon.test.domain.dto.member.LoginDTO;
import com.nowon.test.domain.dto.member.MemberInsertDTO;



public interface MemberService {
	
	void save(MemberInsertDTO dto);

	boolean emailCheck(String email);


	String login(LoginDTO dto, Model model, HttpSession session);


}
