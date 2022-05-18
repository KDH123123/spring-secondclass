package com.nowon.test.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.nowon.test.domain.dto.GoodsDto;
import com.nowon.test.domain.dto.GoodsTimeDTO;
import com.nowon.test.service.GoodsService;

@Service // 안에 component포함됨. 실행하면 컨테이너에 저장됨. <- component scan대상
public class GoodsServiceImpl implements GoodsService {

	@Override // 상속 다시 공부하자 흑ㅡㅎㄱ
	public ModelAndView getList(ModelAndView model) {
		List<GoodsTimeDTO> result = new ArrayList<GoodsTimeDTO>();
		result.add(new GoodsTimeDTO("/images/index/time_1.jpg_300", "05:12:30", 409, "송이향 백화고(650g)", 30000));
		result.add(new GoodsTimeDTO("/images/index/time_2.jpg_300", "05:12:30", 409, "타이틀2", 30000));
		result.add(new GoodsTimeDTO("/images/index/time_3.jpg_300", "05:12:30", 409, "타이틀3", 30000));
		result.add(new GoodsTimeDTO("/images/index/time_4.jpg_300", "05:12:30", 409, "타이틀4", 30000));
		result.add(new GoodsTimeDTO("/images/index/time_5.jpg_300", "05:12:30", 409, "타이틀5", 30000));
		result.add(new GoodsTimeDTO("/images/index/time_6.jpg_300", "타이틀6", 409, "송이향 백화고(650g)", 30000));
		model.addObject("list", result);
		return model;
	}

	@Override
	public void getglist(Model model) {
		List<GoodsDto> list = new ArrayList<GoodsDto>();
		list.add(new GoodsDto("./images/index/goods_1.jpg_300", "[쿠폰할인/입점특가] GAP 저탄소 성주참외(5kg)", 0.2, 38800, 48600));
		list.add(new GoodsDto("./images/index/goods_2.jpg_300", "우리 한우 샤브샤브 불고기(300g/냉동)", 0.3, 10800, 15500));
		list.add(new GoodsDto("./images/index/goods_3.jpg_300", "참프레 고향집 토종닭 1,050g", 0.04, 11800, 12400));
		list.add(new GoodsDto("./images/index/goods_4.jpg_300", "(특품) 성주 꿀참외 (3입/팩)", 0.48, 7800, 15000));
		model.addAttribute("list", list);
	}

}
