package com.nowon.test.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nowon.test.domain.dto.member.MemberInsertDTO;
import com.nowon.test.domain.entity.MemberEntity;
import com.nowon.test.domain.entity.MemberEntityRepository;
import com.nowon.test.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberServiceProcess implements MemberService {
	
	
	
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
	
	private final MemberEntityRepository repository;
	@Override
	public void save(MemberInsertDTO dto) {
		//서비스 로직 처리
		MemberEntity entity = dto.toEntity();
		//DTO를 DB저장
		repository.save(entity);//MemberEntity로 리턴해주는 메서드 호출. 메서드는 dto에서 맹금.
	}
	
	
}
