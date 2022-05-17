package com.nowon.test.domain.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//dao의 역할
@Repository
public interface MemberEntityRepository extends JpaRepository<MemberEntity, Long>{
	//추가로 쿼리메서드 생성가능
	//<클래스이름, pk값의 데이터 타입>

}
