package com.nowon.test;

import java.time.LocalDateTime;
import java.util.Optional;


import org.aspectj.weaver.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.nowon.test.domain.entity.MemberEntity;
import com.nowon.test.domain.entity.MemberEntityRepository;

@SpringBootTest
class SpringTest04ApplicationTests {

	// Bean : application context에 객체로 저장되어 있는 것
	@Autowired // 저장소와 연결
	MemberEntityRepository repository = null;

	//@Test
	void 저장() {
		
		MemberEntity entity=new MemberEntity();
		entity.setEmail("test03@test.com");
		entity.setName("test");
		entity.setPass("1234");
		repository.save(entity);
	}
	
	//@Test
	void 수정() {
		//수정대상이 존재하는지 확인
		Optional<MemberEntity> result = repository.findById(42L);//pk값으로 수정 대상 찾기
		if(result.isEmpty()) {//쿼리 샐행결과가 비어 있는지 확인하는 메서드
			System.out.println("존재하지 않는 데이터");	
			return;//데이터가 없으면 실행 종료
		}
		
		//데이터가 존재 할 때만 사용가능
		MemberEntity entity = result.get();
		entity.setPass("8888");
		
		repository.save(entity);

	}
	
	@Rollback(false)
	@Transactional
	@Test
	void 수정2() {
		//수정대상이 존재하는지 확인
		Optional<MemberEntity> result = repository.findById(42L);//pk값으로 수정 대상 찾기
		if(result.isEmpty()) {//쿼리 샐행결과가 비어 있는지 확인하는 메서드
			System.out.println("존재하지 않는 데이터");	
			return;//데이터가 없으면 실행 종료
		}
		
		//데이터가 존재 할 때만 사용가능
		MemberEntity entity = result.get();
		entity.setPass("88188");
		//save를 처리하지 않아도 트랜잭션의 영속성 특징으로 entity필드가 수정되면 자동으로 update처리
		
	}
	
	//@Test
	void 맴버삭제() {
		//pk를 이용해서 데이터 삭제
		repository.deleteById(1L);//long형이라 L써줘야행
	}

}

