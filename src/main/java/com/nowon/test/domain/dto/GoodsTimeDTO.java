package com.nowon.test.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@RequiredArgsConstructor //final이랑 세투
@Builder // arg가 있는 생성자에만 쓸 수 있음
@AllArgsConstructor //arg를 가진 생성자
@NoArgsConstructor //디폴트 생성자 생성
@Getter
@Setter
public class GoodsTimeDTO {
	private String imgUrl;
	private String saleTime;
	private int buyingCount;
	private String title;
	private int price;

}
