package com.nowon.test.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.nowon.test.domain.dto.GoodsTimeDTO;
import com.nowon.test.service.GoodsService;

@Service // 안에 component포함됨. 실행하면 컨테이너에 저장됨. <- component scan대상
public class GoodsServiceImpl implements GoodsService {

	@Override // 상속 다시 공부하자 흑ㅡㅎㄱ
	public ModelAndView getList(ModelAndView model) {
		List<GoodsTimeDTO> result=new ArrayList <GoodsTimeDTO>();
		result.add(new GoodsTimeDTO("/images/index/time_1.jpg_300", "05:12:30", 409, "송이향 백화고(650g)", 30000));
		result.add(new GoodsTimeDTO("/images/index/time_2.jpg_300", "05:12:30", 409, "타이틀2", 30000));
		result.add(new GoodsTimeDTO("/images/index/time_3.jpg_300", "05:12:30", 409, "타이틀3", 30000));
		result.add(new GoodsTimeDTO("/images/index/time_4.jpg_300", "05:12:30", 409, "타이틀4", 30000));
		result.add(new GoodsTimeDTO("/images/index/time_5.jpg_300", "05:12:30", 409, "타이틀5", 30000));
		result.add(new GoodsTimeDTO("/images/index/time_6.jpg_300", "타이틀6", 409, "송이향 백화고(650g)", 30000));
		model.addObject("list", result);
		return model;
	}

}
