package com.nowon.test.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nowon.test.service.GoodsService;

@Controller  //서비스에게 일 시키는 놈
public class GoodsController {
	
	@Autowired//컨테이너에 저장된 객체를 연결
	private GoodsService goodsService;
	
	
	@GetMapping("/goods/time")//위에꺼랑 똑같음
	public ModelAndView getGoodsTime(ModelAndView model) {
		model.setViewName("goods/timeList");//이동할 페이지 정보
		
		return goodsService.getList(model);
	}
}