package com.nowon.test.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nowon.test.domain.dto.member.LoginDTO;
import com.nowon.test.domain.dto.member.MemberInsertDTO;
import com.nowon.test.service.MemberService;



@RequestMapping("/member/")
@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping(value="signout")
	public String signout(HttpSession session) {
		
		//session.removeAttribute("logInfo");//특정 session 제거
		session.invalidate();//모든 session 제거
		
		return "redirect:/";
	}
	
	//로그인 처리
	@PostMapping(value="signin") //value가 같아도 메서드가 다르면 실행 가넝
	//public void signin(String email, String pass,@RequestParam(defaultValue = "0") int idSave) {//int형 파라미터에 null이 들어오면 오류발생, 이거 다 쓰면 귀찮으니까 class dto로 만듦.
	public String signin(LoginDTO dto, Model model, HttpSession session) {//null이면 0을 저장. 파라미터 기본값 설정 어노테이션
			//페이지 이동시 주소 정보를 쓰기 위해 String, 메시지 출력을 위한 model
		
		//email,pass DB에서 일치하는 데이터의 존재 유무
		return service.login(dto,model,session); //서비스에 로그인 가능 여부 확인

	}
	
	//요청 uri패턴과 template의 path가 일치하면 void인 경우도 페이지 이동 가능
	//이거 쓰지말자
	@GetMapping(value="signin")
	public void signin(Model model,@RequestHeader("Referer") String prevUrl,String name) {
		//회원가입 처리 이후에 로그인 페이지에 이동한 경우 메시지 출력
		if(prevUrl.equals("http://localhost:8080/member/signup-page")) {
		String msg=name+"로그인하세요";
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
		String encodedname = null;
		try {
			encodedname = URLEncoder.encode(dto.getName(), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "redirect:/member/signin?name="+encodedname;
		// url주소를 /로 수정
		// 재요청처리되어서 index페이지가 보임
	}
	
	@ResponseBody
	@PostMapping("emailCheck")
	public  boolean emailCheck(String email) {
		return service.emailCheck(email);
	}
	
	
}
