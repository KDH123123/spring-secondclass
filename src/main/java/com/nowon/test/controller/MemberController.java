package com.nowon.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nowon.test.domain.dto.member.MemberInsertDTO;
import com.nowon.test.service.MemberService;



@RequestMapping("/member/")
@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	//요청 uri패턴과 template의 path가 일치하면 void인 경우도 페이지 이동 가능
	@GetMapping("signin")
	public void signin(Model model,@RequestHeader("Referer") String prevUrl) {
		if(prevUrl.equals("http://localhost:8080/member/signup-page")) {
		String msg="로그인하세요";
		model.addAttribute("welcome", msg);
	}
	}
	
	
	@GetMapping("signup-page")
	public String signupPage() {
		return "member/signup";
	}
	
	@PostMapping("signup")
	public String signup(MemberInsertDTO dto, Model model) {
		service.save(dto);
		return "redirect:/member/signin";
		// url주소를 /로 수정
		// 재요청처리되어서 index페이지가 보임
	}
	
	@ResponseBody
	@PostMapping("emailCheck")
	public  boolean emailCheck(String email) {
		return service.emailCheck(email);
	}
	
	
}
