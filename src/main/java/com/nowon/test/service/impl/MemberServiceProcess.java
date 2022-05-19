package com.nowon.test.service.impl;

import java.util.Optional;
import java.util.function.Function;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.nowon.test.domain.dto.member.LogInfo;
import com.nowon.test.domain.dto.member.LoginDTO;
import com.nowon.test.domain.dto.member.MemberInsertDTO;
import com.nowon.test.domain.entity.MemberEntity;
import com.nowon.test.domain.entity.MemberEntityRepository;
import com.nowon.test.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberServiceProcess implements MemberService {
	
	private final MemberEntityRepository repository;

	private final HttpSession httpSession;
	
	
	
	
	@Override
	public boolean emailCheck(String email) {
		//where email=입력된이메일
		//jpa제공하고 있는 쿼리메서드가 존재하지 않음
		//문법에 맞게 제작
		Optional<MemberEntity> result = repository.findByEmail(email);
		if(result.isPresent()) {
			return true;//이미 존재하면 사용 불가
		}
		return false;
	}
	
	
	@Override
	public void save(MemberInsertDTO dto) {
		//서비스 로직 처리
		MemberEntity entity = dto.toEntity();
		//DTO를 DB저장
		repository.save(entity);//MemberEntity로 리턴해주는 메서드 호출. 메서드는 dto에서 맹금.
	}
	
	@Override
	public String login(LoginDTO dto, Model model, HttpSession session) {
		//email,pass DB에서 일치하는 데이터의 존재 유무 확인
		//1. 이메일이 존재 하는지 확인(if)
		Optional<MemberEntity> result = repository.findByEmail(dto.getEmail());//email가져와서 db에있나확인
		//2. 이메일이 존재하면 비밀번호 확인(else)
		if(result.isPresent()) {
			//패스워드 확인
			String dbpass = result.get().getPass();//db에저장된 pass와 dtopass 둘 다 호출
			if(dto.getPass().equals(dbpass)) {

				//MemberEntity entity=result.get();
				//db의데이터를 페이지로 전송하기 위한 데이터
				//기본적으로 브라우저가 종료될때 까지느 유지하는 저장소
				//LogInfo info =new LogInfo(entity);
				
				LogInfo info = result.map(LogInfo::new).get();
				 
				session.setAttribute("logInfo", info);
				//httpSession.setAttribute("logInfoName", entity.getName());
				//httpSession.setAttribute("logInfoEmail", entity.getEmail());//엔터티의 이름만 session에 저장
				model.addAttribute("data", "의미없는데이터");//새로고침할때마다 model은 사라짐
				
				//비밀번호 일치하면 로그인 처리
				//성공시 인덱스페이지로
				return "redirect:/";//refresh
			}
			//비밀번호 틀린경우
		}
		//회원이 존재하지 않는 경우
		//응답페이지까지 전잘
		model.addAttribute("errmsg", "회원이 아니거나 비밀번호가 다릅니다.");
		return "member/signin";//응답페이지
	}


	
	
	
}
