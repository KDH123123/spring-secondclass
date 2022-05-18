package com.nowon.test.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@SequenceGenerator(sequenceName = "seq_member", name = "gen_seq_member", allocationSize = 1) // 시퀀스 이름,제너레이터 이름, 증분값
@Table(name = "member") // 테이블 지정. 지정하지 않으면 클래스명이 테이블명이 됨.
@Entity // 엔터티 클래스. 물리적인 DB의 테이블과 맵핑되는 클래스.
@EntityListeners(AuditingEntityListener.class) //@EnableJpaAuditing 활성화 반영. 날짜정보 업데이트시 필수
public class MemberEntity {
	//DB의 테이블 대용입니다.
	//entity클래스가 테이블이라고 생각하고 작업하기

	@Id // 시퀀스 적용가능
	@GeneratedValue(generator = "gen_seq_member", strategy = GenerationType.SEQUENCE) // 시퀀스 자동 적용
	private long no;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String pass;
	
	// camel표기법 사용
	@CreatedDate//entity 생성될 때 자동으로 등록
	private LocalDateTime createdDate;//최초 가입시
	
	@LastModifiedDate//수정이 발생되면 자동으로 등록
	private LocalDateTime updatedDate;//정보 수정시 : 마지막 수정된 날짜
	
	@LastModifiedBy
	private String col;//컬럼 추가
}
