package com.nowon.test.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GoodsDto {
	private String imgUrl;
	private String title;
	private double saleRate;
	private int salePrice;
	private int orginPrice;
}
