package com.nowon.test.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nowon.test.service.GoodsService;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

@Log4j2
//@RequestMapping("/goods/") //주소 공통요소는 전진배치 가능
@Controller  //서비스에게 일 시키는 놈
public class GoodsController {
	
	@Autowired//컨테이너에 저장된 객체를 연결
	private GoodsService goodsService;
	
	
	@GetMapping("/goods/time")
	public ModelAndView getGoodsTime(ModelAndView mav) {
		mav.setViewName("goods/timeList");//이동할 페이지 정보
		
		return goodsService.getList(mav);
	}
	
	@PostMapping("/goods/glist")
	public String glist(Model model) {
		
		goodsService.getglist(model);//메서드 호출=실행
		log.debug(">>>>"+model);
		return "goods/glist"; //.html 생략 
	}
}